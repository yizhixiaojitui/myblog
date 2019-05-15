<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  
<title></title>
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
						<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/about"><i
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
				<div class="layui-col-md9 ">
					<div class="border-box bgc-fff" >
					<div class="">
					<ul class="layui-timeline">
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">8月18日</h3>
      <p>
        layui 2.0 的一切准备工作似乎都已到位。发布之弦，一触即发。
        <br>不枉近百个日日夜夜与之为伴。因小而大，因弱而强。
        <br>无论它能走多远，抑或如何支撑？至少我曾倾注全心，无怨无悔 <i class="layui-icon"></i>
      </p>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">8月16日</h3>
      <p>杜甫的思想核心是儒家的仁政思想，他有“<em>致君尧舜上，再使风俗淳</em>”的宏伟抱负。个人最爱的名篇有：</p>
      <ul>
        <li>《登高》</li>
        <li>《茅屋为秋风所破歌》</li>
      </ul>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">8月15日</h3>
      <p>
        中国人民抗日战争胜利72周年
        <br>常常在想，尽管对这个国家有这样那样的抱怨，但我们的确生在了最好的时代
        <br>铭记、感恩
        <br>所有为中华民族浴血奋战的英雄将士
        <br>永垂不朽
      </p>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <div class="layui-timeline-title">过去</div>
    </div>
  </li>
</ul></div>
					</div>
				</div>
				<div class="layui-col-md3">
					<div class=" mg-l-10">
						<div class=" pd-15-20 mg-b-10 border-box" id="u_box">

						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-blue">阅读榜单</div>
							<div class="layui-card-body">
								<a href="#">文章名称文章名称文章名称</a></br> <a href="#">文章名称文章名称文章名称文章名称</a></br> <a
									href="#">文章名称文章名称文章名称文章名称</a></br> <a href="#">文章名称文章名称文章名称文章名称</a></br>
								<a href="#">文章名称文章名称文章名称文章名称</a></br>
							</div>
						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-green">标签</div>
							<div class="layui-card-body tags">
							<ul>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
								<a href="/e/tags/?tagname=%E6%95%99%E7%A8%8B&amp;tempid=8" target="_blank">教程</a>
							</ul>
							</div>
						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-cyan">推荐榜单</div>
							<div class="layui-card-body">
								<a href="#">文章名称文章名称文章名称</a></br> <a href="#">文章名称文章名称文章名称文章名称</a></br> <a
									href="#">文章名称文章名称文章名称文章名称</a></br> <a href="#">文章名称文章名称文章名称文章名称</a></br>
								<a href="#">文章名称文章名称文章名称文章名称</a></br>
							</div>
						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-gray">友情链接</div>
							<div class="layui-card-body links">
								<ul id="links">
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<!--内容结束-->
		<footer class="center">
		<div>Copyright © 2018 xiaojitui. All Rights Reserved</div>
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
		}).use([ 'index', 'home' ],function() {
			
			
		});
	</script>
</body>

</html>