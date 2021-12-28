layui.use(['table',], function () {
    var table = layui.table;
    //使用jquery
    var $ = layui.jquery;
    //给查询按钮绑定事件
    $("#searchBtn").on("click", function () {
        table.render({
            elem: '#userTable' //# + 元素id
            // ,height: 312
            , url: '/user/list' //数据接口
            , page: true //开启分页
            , cols: [[ //表头   双括号会被解析为thymeleaf模板
                {field: 'id', title: 'ID', width: '20%', sort: true, fixed: 'left'}
                , {field: 'username', title: '用户名', width: '20%'}
                , {field: 'sex', title: '性别', width: '20%', sort: true}
                , {field: 'name', title: '姓名', width: '20%', sort: true}
                , {field: 'age', title: '年龄', width: '20%', sort: true}
            ]],
            limits: [5, 10, 15, 20],
            limit: 5,
            where: {"keyword": $("#searchUsername").val()}
        });
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