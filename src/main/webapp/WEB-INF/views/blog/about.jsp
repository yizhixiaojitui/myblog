<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  
<title>关于</title>
<link rel="stylesheet" type="text/css"
	href="http://at.alicdn.com/t/font_959643_ibxvenqnukf.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/layuiadmin/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/my.css">
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/static/favicon.ico" />
</head>

<body class="layui-layout-body my-theme-default bgc-f4">
	<div class="layui-layout layui-layout-admin">
		<!--导航-->
		<div class="layui-header">
			<div class="layui-main">
				<div class="layui-logo">
					<div class="layui-logo-brand"></div>
				</div>
				<div class="layui-layout-right">
					<ul class="layui-nav">
						<li class="layui-nav-item"><a href=""><i
								class="layui-icon layui-icon-home"></i>首页</a></li>
						<li class="layui-nav-item"><a href=""><i
								class="layui-icon layui-icon-fonts-code"></i>问题库<span
								class="layui-badge-dot"></span></a></li>
						<li class="layui-nav-item"><a href=""><i
								class="layui-icon layui-icon-snowflake"></i>随笔<span
								class="layui-badge-dot"></span></a></li>
						<li class="layui-nav-item"><a href=""><i
								class="layui-icon layui-icon-component"></i>音乐<span
								class="layui-badge-dot"></span></a></li>
						<li class="layui-nav-item"><a href=""><i
								class="iconfont icon-eit"></i>部落格<span class="layui-badge-dot"></span></a>
						</li>
						<li class="layui-nav-item"><a href=""><i
								class="layui-icon layui-icon-about"></i>关于<span class="layui-badge-dot"></span></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--导航结束-->
		<div class="mg-b-20"></div>
		<!--内容开始-->
		<div class="layui-container mg-b-20">
			<div class="layui-row my-content mg-b-20">
				
					
					<h1>关于</h1>
					<h1>关于</h1>
					<h1>关于</h1>
					<h1>关于</h1>
					<h1>关于</h1>
					<h1>关于</h1>
					<h1>关于</h1>
				
				
			</div>
		</div>
		<hr>
		<!--内容结束-->
		<footer class="center ">
		<div class="pd-tb-10">Copyright © 2018 xiaojitui. All Rights Reserved</div>
		</footer>
	</div>
	<!-- 你的HTML代码 -->
	<script src="${pageContext.request.contextPath }/static/js/my.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/layuiadmin/layui/layui.js"></script>
	<script>
		//一般直接写在一个js文件中
		var username='${user}';
		layui.config({
			base : '${pageContext.request.contextPath }/static/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'index'],function() {
			
			
		});
				
	</script>
</body>

</html>