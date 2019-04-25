<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>列表</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/my.css"
	media="all">
</head>
<body>

	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-form layui-card-header layuiadmin-card-header-auto">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">文章ID</label>
						<div class="layui-input-inline">
							<input type="text" name="articleId" placeholder="请输入"
								autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-inline">
						<label class="layui-form-label">文章标题</label>
						<div class="layui-input-inline">
							<input type="text" name="articleName" placeholder="请输入"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">文章状态</label>
						<div class="layui-input-inline">
							<select name="articleStatus">
								<option value="">请选择文章状态</option>
								<option value="0">已发布</option>
								<option value="1">待修改</option>
							</select>
						</div>
					</div>
					<div class="layui-inline">
						<button class="layui-btn layuiadmin-btn-list" lay-submit
							lay-filter="content-list-search">
							<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
						</button>
					</div>
				</div>
			</div>

			<div class="layui-card-body">
				<div style="padding-bottom: 10px;">
					<button class="layui-btn layuiadmin-btn-list" data-type="batchdel">删除</button>
					<button class="layui-btn layuiadmin-btn-list" data-type="add">添加</button>
				</div>
				<table id="content-list" lay-filter="content-list"></table>
				<script type="text/html" id="buttonTpl">
          {{#  if(d.articleStatus){ }}
            <button class="layui-btn layui-btn-primary layui-btn-xs">待修改</button>
          {{#  } else { }}
            <button class="layui-btn  layui-btn-xs">已发布</button>
          {{#  } }}
        </script>
				<script type="text/html" id="moduleTpl">
          {{#  if(d.moduleType==1){ }}
            <span class="layui-bg-blue"><i class="layui-icon layui-icon-fonts-code"></i>问题库</span>
          {{#  } if(d.moduleType==2) { }}
            <span class="layui-badge"><i class="layui-icon layui-icon-snowflake"></i>随笔</span>
          {{#  }if(d.moduleType==3){ }}
 			<span class="layui-bg-green"><i class="layui-icon layui-icon-component"></i>音乐</span>
		  {{#  } }}
        </script>
				<script type="text/html" id="table-content-list">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/static/js/my.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/layuiadmin/layui/layui.js"></script>
	<script>
	layui.config({
		base: '${pageContext.request.contextPath }/static/layuiadmin/' //静态资源所在路径
	}).extend({
		index: 'lib/index' //主入口模块
	}).use(['index', 'contlist', 'table'],
  function() {
    var table = layui.table,
    form = layui.form;
    //监听搜索
    form.on('submit(content-list-search)',
    function(data) {
      var field = data.field;
      //执行重载
      console.log(field);
      table.reload('content-list', {
        where: field
      });
    });

    var $ = layui.$,
    active = {
      batchdel: function() {
        var checkStatus = table.checkStatus('content-list'),
        checkData = checkStatus.data; //得到选中的数据
        if (checkData.length === 0) {
          return layer.msg('请选择数据');
        }
        layer.confirm('确定删除吗？',
        function(index) {
          //执行 Ajax 后重载
          //修改接口参数为ID 不传obj checkData.articleId
          $.ajax({
            url: resPath + "/api/article/delete?r=" + Math.random(),
            type: "Delete",
            data: JSON.stringify(checkData),
            contentType: "application/json",
            dataType: "json",
            success: function(res) {
              if (res.code == 0) {
                layer.msg('已删除' + res.msg);
                table.reload('content-list');
              } else {
                layer.msg(res.msg);
              }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
              // 状态码
              console.log(XMLHttpRequest.status);
              // 状态
              console.log(XMLHttpRequest.readyState);
              // 错误信息   
              console.log(textStatus);
            }
          });

        });
      },
      add: function() {
        layer.open({
          type: 2,
          title: '添加文章',
          content: '../article/edit',
          maxmin: true,
          area: ['550px', '550px']
        });
      }
    };

    $('.layui-btn.layuiadmin-btn-list').on('click',
    function() {
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });

  });</script>
</body>
</html>
