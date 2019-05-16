<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>admin</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/layuiadmin/layui/css/layui.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/layuiadmin/style/admin.css"
	media="all">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/static/favicon.ico" />

</head>
<body class="layui-layout-body">

	<div id="LAY_app">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<!-- 头部区域 -->
				<ul class="layui-nav layui-layout-left">
					<li class="layui-nav-item layadmin-flexible" lay-unselect><a
						href="javascript:;" layadmin-event="flexible" title="侧边伸缩"> <i
							class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect >
					<a href="${pageContext.request.contextPath }/${userinfo.userName }" target="_blank" title="前台"><i class="layui-icon layui-icon-website"></i>
					</a></li>
					<li class="layui-nav-item" lay-unselect><a href="javascript:;"
						layadmin-event="refresh" title="刷新"> <i
							class="layui-icon layui-icon-refresh-3"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><input
						type="text" placeholder="搜索..." autocomplete="off"
						class="layui-input layui-input-search" layadmin-event="serach"
						lay-action="template/search.html?keywords="></li>
				</ul>
				<ul class="layui-nav layui-layout-right"
					lay-filter="layadmin-layout-right">

					<li class="layui-nav-item" lay-unselect><a
						lay-href="app/message/index.html" layadmin-event="message"
						lay-text="消息中心"> <i class="layui-icon layui-icon-notice"></i>

							<!-- 如果有新消息，则显示小圆点 --> <span class="layui-badge-dot"></span>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="theme"> <i
							class="layui-icon layui-icon-theme"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="note"> <i
							class="layui-icon layui-icon-note"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="fullscreen"> <i
							class="layui-icon layui-icon-screen-full"></i>
					</a></li>
					<li class="layui-nav-item" lay-unselect><a href="javascript:;">
					<img src="${pageContext.request.contextPath }${userinfo.userImageUrl }" class="layui-nav-img">
							<cite>${userinfo.userNikename }</cite>
					</a>
						<dl class="layui-nav-child">
							<dd>
								<a lay-href="admin/set/user/info">基本资料</a>
							</dd>
							<dd>
								<a lay-href="admin/set/user/password">修改密码</a>
							</dd>
							<hr>
							<dd layadmin-event="logout" style="text-align: center;">
								<a>退出</a>
							</dd>
						</dl></li>

					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="about"><i
							class="layui-icon layui-icon-more-vertical"></i></a></li>
					<li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm"
						lay-unselect><a href="javascript:;" layadmin-event="more"><i
							class="layui-icon layui-icon-more-vertical"></i></a></li>
				</ul>
			</div>

			<!-- 侧边菜单 -->
			<div class="layui-side layui-side-menu">
				<div class="layui-side-scroll">
					<div class="layui-logo" lay-href="${pageContext.request.contextPath }/admin/console">
						<span>后台管理</span>
					</div>

					<ul class="layui-nav layui-nav-tree" lay-shrink="all"
						id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
						<li data-name="/" data-jump="/" class="layui-nav-item layui-this">
							<a href="javascript:;" lay-href="${pageContext.request.contextPath }/admin/console" lay-tips="控制台"
							lay-direction="2"> <i class="layui-icon layui-icon-console"></i>
								<cite>控制台</cite>
						</a>
						</li>
						<li data-name="article" data-jump="" class="layui-nav-item">
							<a href="javascript:;" lay-tips="写博客" lay-direction="2"> <i
								class="layui-icon layui-icon-edit"></i> <cite>写博客</cite> <span
								class="layui-nav-more"></span></a>
							<dl class="layui-nav-child">
								<dd data-name="edit" data-jump="article/edit" class="">
									<a href="javascript:;" lay-href="admin/article/edit">写文章</a>
								</dd>
								<dd data-name="trash" data-jump="article/trash" class="">
									<a href="javascript:;" lay-href="admin/article/trash">垃圾桶</a>
								</dd>
							</dl>
						</li>
						<li data-name="content" data-jump="" class="layui-nav-item">
							<a href="javascript:;" lay-tips="内容管理" lay-direction="2"> <i
								class="layui-icon layui-icon-app"></i> <cite>内容管理</cite> <span
								class="layui-nav-more"></span></a>
							<dl class="layui-nav-child">
								<dd data-name="list" data-jump="content/list" class="">
									<a href="javascript:;" lay-href="admin/content/list">文章列表</a>
								</dd>
								<dd data-name="tags" data-jump="tags/list" class="">
									<a href="javascript:;" lay-href="admin/content/tags/list">分类管理</a>
								</dd>
								<dd data-name="comment" data-jump="content/comment" class="">
									<a href="javascript:;" lay-href="admin/content/comment">评论管理</a>
								</dd>
							</dl>
						</li>
						
						<li data-name="senior" class="layui-nav-item"><a
							href="javascript:;" lay-tips="高级" lay-direction="2"> <i
								class="layui-icon layui-icon-senior"></i> <cite>高级</cite>
						</a>
							<dl class="layui-nav-child">
								<dd>
									<a layadmin-event="im">LayIM 通讯系统</a>
								</dd>
								<dd data-name="echarts">
									<a href="javascript:;">Echarts集成</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="senior/echarts/line.html">折线图</a>
										</dd>
										<dd>
											<a lay-href="senior/echarts/bar.html">柱状图</a>
										</dd>
										<dd>
											<a lay-href="senior/echarts/map.html">地图</a>
										</dd>
									</dl>
								</dd>
							</dl></li>
						<li data-name="user" class="layui-nav-item"><a
							href="javascript:;" lay-tips="用户" lay-direction="2"> <i
								class="layui-icon layui-icon-user"></i> <cite>用户</cite>
						</a>
							<dl class="layui-nav-child">
								<dd>
									<a lay-href="user/user/list.html">网站用户</a>
								</dd>
								<dd>
									<a lay-href="user/administrators/list.html">后台管理员</a>
								</dd>
								<dd>
									<a lay-href="user/administrators/role.html">角色管理</a>
								</dd>
							</dl></li>
						<li data-name="set" class="layui-nav-item"><a
							href="javascript:;" lay-tips="设置" lay-direction="2"> <i
								class="layui-icon layui-icon-set"></i> <cite>设置</cite>
						</a>
							<dl class="layui-nav-child">
								<dd >
									<a href="javascript:;">系统设置</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="admin/set/system/website">网站设置</a>
										</dd>
										<dd>
											<a lay-href="set/system/email.html">邮件服务</a>
										</dd>
									</dl>
								</dd>
								<dd >
									<a href="javascript:;">我的设置</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="admin/set/user/info">基本资料</a>
										</dd>
										<dd>
											<a lay-href="admin/set/user/password">修改密码</a>
										</dd>
										<dd>
											<a lay-href="admin/set/friendlylink/list">友情链接</a>
										</dd>
									</dl>
								</dd>
								
							</dl></li>
						
					</ul>
				</div>
			</div>

			<!-- 页面标签 -->
			<div class="layadmin-pagetabs" id="LAY_app_tabs">
				<div class="layui-icon layadmin-tabs-control layui-icon-prev"
					layadmin-event="leftPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-next"
					layadmin-event="rightPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-down">
					<ul class="layui-nav layadmin-tabs-select"
						lay-filter="layadmin-pagetabs-nav">
						<li class="layui-nav-item" lay-unselect><a
							href="javascript:;"></a>
							<dl class="layui-nav-child layui-anim-fadein">
								<dd layadmin-event="closeThisTabs">
									<a href="javascript:;">关闭当前标签页</a>
								</dd>
								<dd layadmin-event="closeOtherTabs">
									<a href="javascript:;">关闭其它标签页</a>
								</dd>
								<dd layadmin-event="closeAllTabs">
									<a href="javascript:;">关闭全部标签页</a>
								</dd>
							</dl></li>
					</ul>
				</div>
				<div class="layui-tab" lay-unauto lay-allowClose="true"
					lay-filter="layadmin-layout-tabs">
					<ul class="layui-tab-title" id="LAY_app_tabsheader">
						<li lay-id="${pageContext.request.contextPath }/admin/console" lay-attr="${pageContext.request.contextPath }/admin/console"
							class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
					</ul>
				</div>
			</div>


			<!-- 主体内容 -->
			<div class="layui-body" id="LAY_app_body">
				<div class="layadmin-tabsbody-item layui-show">
					<iframe src="${pageContext.request.contextPath }/admin/console"
						frameborder="0" class="layadmin-iframe"></iframe>
				</div>
			</div>

			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
	</div>
<script src="${pageContext.request.contextPath }/static/js/my.js"></script>
	<script src="${pageContext.request.contextPath }/static/layuiadmin/layui/layui.js"></script>
	<script>
		layui.config({
			base : '${pageContext.request.contextPath }/static/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use('index',function(){
			var cate = layui.data('layuiAdmin');
			console.log(cate.access_token)
			console.log();
			//$('#homeurl').html('');
		});
	</script>


</body>
</html>


