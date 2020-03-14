<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>500</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layuiadmin/style/admin.css" media="all">
</head>
<body>


<div class="layui-fluid">
  <div class="layadmin-tips">
    <i class="layui-icon" face>&#xe664;</i>
    
    <div class="layui-text" style="font-size: 20px;">
      好像没有权限呢！刷新重进一下试试呢！
     <div><span id="time">3</span>

秒钟之后自动跳转，如果不跳转，请点击下面链接
</div>
<div><a href="../account/login">点击这里</a></div>
    </div>
  </div>
</div>



<script language="JavaScript1.2" type="text/javascript">
delayURL("../account/login", 3000);
function delayURL(url, time) {

setTimeout("top.location.href='" + url + "'", time);

}

</script>
  <script src="${pageContext.request.contextPath }/static/layuiadmin/layui/layui.js"></script>
  <script>
  layui.config({
    base: '${pageContext.request.contextPath }/static/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index']);
  </script>
</body>
</html>