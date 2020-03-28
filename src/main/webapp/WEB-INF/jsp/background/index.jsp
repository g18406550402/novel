<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户关系管理</title>
<script src="http://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>
<link rel="stylesheet" href="/layui/css/layui.css">
<link rel="stylesheet"
	href="/css/bootstrapSwitch/css/bootstrap3/bootstrap-switch.min.css">
<script src="/layui/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap-3.3.7/css/bootstrap.min.css">
<script src="/css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="/css/bootstrapSwitch/js/bootstrap-switch.min.js"></script>
<script src="/layui/js/router.js"></script>
<style src="/layui/css/index.css"></style>
<style type="text/css">
#inner p:first-child {
	margin-left: 300px;
	margin-top: 110px;
	font-size: 80px;
	color: white;
	text-shadow: black 0 0 10px;
}

#inner p:last-child {
	color: white;
	text-shadow: black 0 0 10px;
	margin-left: 550px;
	margin-top: 50px;
	font-size: 50px;
}

#inner {
	width: 1140px;
	overflow: hidden;
}

.layui-footer {
	text-align: center;
}

.layui-icon-chart-screen {
	position: relative;
	top: 15px;
	left: 5px;
	font-size: 30px;
	font-weight: bolder;
	color: #cde6c7;
}

.layui-body {
	padding: 10px;
	background-color: #F0F0F0;
	overflow: auto;
}

.layui-body>div {
	position: absolute;
	background-color: white;
	width: 100%;
	min-height: 550px;
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<i class="layui-icon layui-icon-chart-screen"></i>
			<div class="layui-logo" style="font-size: 18px; font-weight: bolder;">buke后台管理系统</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img">
						${admin.username}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">修改密码</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="/background/logout">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item"><a href="javascript:;">栏目管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">栏目信息查询</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item"><a href="javascript:;">文章管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">文章信息查询</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item"><a href="javascript:;">章节管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">章节信息查询</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item"><a href="javascript:;">读者管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">读者信息查询</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item"><a href="javascript:;">系统设置</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">角色管理</a>
							</dd>
							<dd>
								<a href="javascript:;">用户管理</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>

		<div class="layui-body" id="main">
			<!-- 内容主体区域 -->
			<div id="inner">
				<p>欢迎使用</p>
				<p>buke后台系统</p>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			buke 后台管理人员专用系统
		</div>
	</div>
	<script src="/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
</html>