<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>修改</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/layuiadmin/layui/css/layui.css"
	media="all">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/inputTags.css"
	media="all">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/layuiadmin/style/admin.css"
	media="all">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/my.css"
	media="all">
</head>
<body>
 <div class="layui-fluid">
    <div class="layui-card pd-20">
	<div class="layui-form pd-tb-10" >
		<div class="layui-form-item">
			<label class="layui-form-label">文章标题</label>
			<div class="layui-input-block">
				<input type="text" name="articleName" lay-verify="title"
					autocomplete="off" placeholder="请输入标题" class="layui-input" autofocus="autofocus">
			</div>
		</div>


		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea layui-hide" name="articleContent"
					lay-verify="content" id="editor"></textarea>
					<input id="articleDescription" type="hidden" name="articleDescription" >
			</div>
		</div>



		<div class="layui-form-item">

			<div class="layui-inline">
				<label class="layui-form-label">个人分类</label>
				<div class="layui-input-inline">
					<select id="article_sort" name="sortArticleId" lay-verify="required"
						lay-search="">
					</select>
				</div>
			</div>
			<a href="javascript:;" id="addType">添加个人分类</a>
		</div>

<div class="layui-form-item">
			<label class="layui-form-label">所属模块</label>
			<div class="layui-input-block">
				<select  name="moduleType"  >
				<option value="1" >问题库</option>
				<option value="2">随笔</option>
				<option value="3">分享</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">文章标签</label>
			<div class="layui-input-block">
				<div class="tags" id="tags">
    <input type="text" name="" id="inputTags" placeholder="回车生成标签" autocomplete="off">
    <input id='hidetext' name="articleLabel" type="hidden" />
                </div>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">文章置顶</label>
			<div class="layui-input-block">
				<input id="articleUp" type="checkbox" checked="" name="articleUp" value="1" lay-skin="switch"
					lay-filter="switchTest" lay-text="ON|OFF">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章推荐</label>
			<div class="layui-input-block">
				<input id="articleSupport" type="checkbox" checked="" name="articleSupport" value="1" lay-skin="switch"
					lay-filter="switchTest" lay-text="ON|OFF">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章公开</label>
			<div class="layui-input-block">
				<input id="articleType" type="checkbox" checked="" name="articleType" value="1" lay-skin="switch"
					lay-filter="switchTest" lay-text="ON|OFF">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章状态</label>
			<div class="layui-input-block">
				<select  name="articleStatus"  >
				<option value="0" selected>立刻发布</option>
				<option value="1">待修改</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button type="button" class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script
		src="${pageContext.request.contextPath }/static/js/my.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/layuiadmin/layui/layui.js"></script>
		
	<script>
	layui.config({
        base: '${pageContext.request.contextPath }/static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'edit']);
		
	</script>
</body>
</html>