/** index.js By Beginner Emain:zheng_jinfan@126.com HomePage:http://www.zhengjinfan.cn */
layui.config({
	base: 'resources/js/'
}).use(['element', 'layer', 'navbar', 'tab'], function() {
	var $ = layui.jquery,
		navbar = layui.navbar(),
		tab = layui.tab({
			elem: '.admin-nav-card' //设置选项卡容器
		});
	//iframe自适应
	$(window).on('resize', function() {
		var $content = $('.admin-nav-card .layui-tab-content');
		$content.height($(this).height() - 147);
		$content.find('iframe').each(function() {
			$(this).height($content.height());
		});
	}).resize();

	//设置navbar
	navbar.set({
		spreadOne: true,
		elem: '#admin-navbar-side',
		cached: true,
		data: navs
			/*cached:true,
			url: 'datas/nav.json'*/
	});
	//渲染navbar
	navbar.render();
	//监听点击事件
	navbar.on('click(side)', function(data) {
		tab.tabAdd(data.field);
	});
});
var navs = [{
	"title": "基本信息管理",
	"icon": "fa-cubes",
	"spread": true,
	"children": [{
		"title": "学生信息",
		"icon": "&#xe641;",
		"href": "stu?cmd=list"
	},{
		"title": "课程管理",
		"icon": "&#xe641;",
		"href": "course?cmd=list"
	},{
		"title": "老师管理",
		"icon": "&#xe641;",
		"href": "teacher?cmd=list"
	}]
}, {
	"title": "综合查询",
	"icon": "fa-cogs",
	"spread": false,
	"children": [{
		"title": "学生成绩管理",
		"icon": "fa-table",
		"href":"studentCourse?cmd=studentCourseResult"
	}, {
		"title": "老师授课管理",
		"icon": "fa-navicon"
	}]
}, {
	"title": "系统管理",
	"icon": "fa-cogs",
	"spread": false,
	"children": [{
		"title": "系统用户",
		"icon": "fa-table",
		"href":"/user/index"
	}]
}];