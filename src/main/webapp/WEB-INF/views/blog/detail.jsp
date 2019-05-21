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
  
<title>${article.articleName } - </title>
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
					<div class="layui-logo-brand">
					<a href="${pageContext.request.contextPath }/${user}"><h1 id="logourl"></h1></a>
					</div>
				</div>
				<div class="layui-layout-right">
					<ul class="layui-nav">
						<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/${user}"><i
								class="layui-icon layui-icon-home"></i>首页</a></li>
						<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/${user}/module/1"><i
								class="layui-icon layui-icon-fonts-code"></i>问题库<span
								class="layui-badge-dot"></span></a></li>
						<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/${user}/module/2"><i
								class="layui-icon layui-icon-snowflake"></i>随笔<span
								class="layui-badge-dot"></span></a></li>
						<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/${user}/module/3"><i
								class="layui-icon layui-icon-component"></i>音乐<span
								class="layui-badge-dot"></span></a></li>
						<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/${user}/line"><i
								class="iconfont icon-eit"></i>部落格<span class="layui-badge-dot"></span></a>
						</li>
						<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/${user}/about"><i
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
					<div class="border-box bgc-fff mg-b-10 body-box-15 detail">
						<div class="my-article-detail">
							<h1 class="mg-b-20 center">${article.articleName }</h1>
							<div class="my-article-detail-blogger mg-b-10 center">
							<span class="top-text"><i
									class="layui-icon layui-icon-friends"></i>分类JAVA</span>
								<span class="top-text"><i
									class="layui-icon layui-icon-friends"></i>${article.userNikename }</span>
								<span class="top-text"><i class="iconfont icon-time"></i>
								<fmt:formatDate value="${article.articleTime }"
										pattern="yyyy-MM-dd HH:mm" /></span> <span class="top-text"><i
									class="iconfont icon-browse"></i>${article.articleClick }</span> <span
									class="top-text"><i class="iconfont icon-message"></i>${article.articleClick }</span>
									
							</div>
							<hr>
						</div>
						<p class="my-article-content">${article.articleContent }</p>
					</div>
					<div class="border-box bgc-fff body-box-15 my-article-comment">
						<h3 class="mg-b-10">评论</h3>
						<div class="layui-form-item my-article-comment-validate mg-b-10">
							<span class="layui-col-md3 "><input type="text"
								name="email" lay-verify="email" autocomplete="off"
								class="layui-input" placeholder="请输入联系邮箱"></span> <span
								class="layui-col-md3 mg-l-20"><input type="text"
								name="username" lay-verify="required" placeholder="请输入留言昵称"
								autocomplete="off" class="layui-input"></span>
						</div>
						<div class="mg-b-10">
							<textarea id="comment" style="display: none;"></textarea>
						</div>
						<button class="layui-btn ">提交</button>
					</div>
				</div>
				<div class="layui-col-md3">
					<div class=" mg-l-10" id="right-view"></div>
				</div>
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
		}).use([ 'index', 'home' ],function() {
			
			
		});
				
	</script>
	<script id="right-view-tpl" type="text/html">
						<div class=" pd-15-20 mg-b-10 border-box" id="u_box">
							<div class="my-blogger-img mg-b-20">
								<a href="#">
<img src="${pageContext.request.contextPath }{{ d.userImageUrl }}"></a>
							</div>
							<div class="my-blogger-detail center">
								<div class="mg-b-10">
									<span class="my-blogger-name">{{d.userNikename}}</span><span
										class="my-blogger-sex"><i
										class="layui-icon layui-icon-female"></i></span>
								</div>
								<p class="mg-b-10">{{ d.userDescription}}</p>
								<div class="my-article-class">
									<div class="my-article-class-title layui-row layui-col-space10">
										<div class="layui-col-md6">文章</div>
										<div class="layui-col-md6">标签</div>
									</div>
									<div class="my-article-class-num layui-row layui-col-space10">
										<div class="layui-col-md6">
											<a href="#">{{ d.articleNum }}</a>
										</div>
										<div class="layui-col-md6">
											<a href="#">{{ d.pageView }}</a>
										</div>
									</div>
								</div>
							</div>
							<div class="user-backgroup-image"
								style="background-image: url(http://127.0.0.1:8080/myblog/static/images/bg.jpg)"></div>
						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-blue">阅读榜单</div>
							<div class="layui-card-body">
								{{#  layui.each(d.articleHots, function(index, item){ }}
								<a href="${pageContext.request.contextPath }/${{ d.userName }}/article/{{item.articleId}}">{{ item.articleName }}({{item.articleClick}})</a></br> 
								{{#  }); }}
							</div>
						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-green">标签</div>
							<div class="layui-card-body tags">
								<ul>
									{{#  layui.each(d.tags, function(index, item){ }}
										<a href="${pageContext.request.contextPath }/tag/{{ item.id }}" target="_blank">{{ item.tagName }}({{ item.articleNumber }})</a>
									{{#  }); }}
								</ul>
							</div>
						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-cyan">推荐榜单</div>
							<div class="layui-card-body">
								{{#  layui.each(d.articleTop, function(index, item){ }}
								<a href="${pageContext.request.contextPath }/{{item.articleId}}">{{ item.articleName }}</a></br> 
								{{#  }); }}
							</div>
						</div>
						<div class="layui-card border-box bgc-fff mg-b-10">
							<div class="layui-card-header layui-bg-gray">友情链接</div>
							<div class="layui-card-body links">
								<ul id="links">
									{{#  layui.each(d.friendlyLinks, function(index, item){ }}
									<a href="{{item.linkUrl}}" target="_blank">{{ item.linkName}}</a>
									{{#  }); }}
								</ul>
							</div>
						</div>
						</script>
</body>

</html>