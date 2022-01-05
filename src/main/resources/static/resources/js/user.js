layui.use(['table', 'layer', 'form', 'laydate'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;
    //使用jquery
    var $ = layui.jquery;

    //绑事件必须放在请求成功之后，或者直接把时间绑定到body上,然后二次选择
    $('body').on('click', '#saveBtn', function () {
        //获取form数据
        var data = form.val("userForm");
        // console.log(data);
        //发送请求
        $.post("/user/save", data, function () {
            layer.closeAll();
            $("#searchBtn").click();
        })
    })
    //推送数据给后台

    //给新增按钮绑定事件
    $("#addBtn").on("click", function () {
        layer.open({
            type: 1,
            areas: ['400px', '400px'],
            title: "新增用户",
            content: $('#addUserTemplate').html()
        });
        form.render();
        laydate.render({
            elem: '#birthday'
        });
        // //    必须把窗口弹出才能绑事件
        // //    给新增窗口绑事件
        // $('#saveBtn').on('click', function () {
        //     //获取form数据
        //     var data = form.val("userForm");
        //     // console.log(data);
        //     //发送请求
        //     $.post("/user/save", data, function () {
        //         layer.closeAll();
        //         $("#searchBtn").click();
        //     })
        //     //推送数据给后台
    })

//给查询按钮绑定事件
    $("#searchBtn").on("click", function () {
        table.render({
            elem: '#userTable' //# + 元素id
            // ,height: 312
            , url: '/user/list' //数据接口
            , page: true //开启分页
            , cols: [[ //表头   双括号会被解析为thymeleaf模板
                {field: 'id', title: 'ID', width: '16%', sort: true, fixed: 'left'}
                , {field: 'username', title: '用户名', width: '20%'}
                , {field: 'sex', title: '性别', width: '16%'}
                , {field: 'name', title: '姓名', width: '16%'}
                , {field: 'age', title: '年龄', width: '16%'}
                , {title: '操作', width: '16%', toolbar: '#operateTemplate'}
            ]],
            limits: [5, 10, 15, 20],
            limit: 5,
            where: {"keyword": $("#searchUsername").val()}
        });
        table.on('tool(userTable1)', function (obj) {
            var id = obj.data.id;//获取当前操作行的id
            if (obj.event === "del") {
                layer.confirm("确定删除该用户？", function () {
                    $.post('/user/del', {id: id}, function () {
                        layer.closeAll();
                        $("#searchBtn").click();
                    })

                })
            } else if (obj.event === "edit") {
                $.get("/user/" + id, function (u) {
                    layer.open({
                        type: 1,
                        areas: ['400px', '400px'],
                        title: "编辑用户",
                        content: $('#addUserTemplate').html()
                    })
                    form.val("userForm", u);
                })
            } else {
                $.get("/role/all", {userId: id}, function (roles) {
                    //弹窗
                    layer.open({
                        type: 1,
                        title: '绑定角色',
                        area: ['400px', '400px'],
                        content: $("#userRoleTemplate").html()
                    });
                    //所有的角色放到弹出窗口的div里展示
                    $.each(roles, function (i, v) {
                        $("#userRoleDiv").append("<input type='checkbox' " + (v.selected ? "checked" : "") + " value='" + v.id + "' title='" + v.name + "'>");
                    });
                    //渲染form
                    form.render();
                    //form表单添加复选框选择事件
                    form.on('checkbox', function (data) {
                        var roleId = data.value;
                        console.log(data.elem.checked);
                        $.post("/userRole/operate", {
                            userId: userId,
                            roleId: roleId,
                            type: data.elem.checked ? 'add' : 'cancel'
                        });
                    });
                });
            }
        })
    }).click();

// table.render({
//     elem: '#userTable' //# + 元素id
//     // ,height: 312
//     , url: '/user/list' //数据接口
//     , page: true //开启分页
//     , cols: [[ //表头   双括号会被解析为thymeleaf模板
//         {field: 'id', title: 'ID', width: '20%', sort: true, fixed: 'left'}
//         , {field: 'username', title: '用户名', width: '20%'}
//         , {field: 'sex', title: '性别', width: '20%', sort: true}
//         , {field: 'name', title: '姓名', width: '20%', sort: true}
//         , {field: 'age', title: '年龄', width: '20%', sort: true}
//     ]],
//     limits: [5, 10, 15, 20],
//     limit: 5
// });
// $("#searchBtn").click();
})