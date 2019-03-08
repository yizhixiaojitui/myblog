<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title></title>
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_959643_ibxvenqnukf.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/res/layuiadmin/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/res/css/my.css">
 
</head>

<body class="layui-layout-body my-theme-default bgc-f4">

    <div class="layui-layout layui-layout-admin">
        <!--导航-->
        <div class="layui-header">
            <div class="layui-main">
                <div class="layui-logo">
                    <div class="layui-logo-brand">
                        
                    </div>
                </div>
                <div class="layui-layout-right">
                    <ul class="layui-nav">
                        <li class="layui-nav-item">
                            <a href=""><i class="layui-icon layui-icon-home"></i>首页</a>
                        </li>
                        <li class="layui-nav-item">
                            <a href=""><i class="layui-icon layui-icon-fonts-code"></i>问题库<span class="layui-badge-dot"></span></a>
                        </li>
                        <li class="layui-nav-item">
                            <a href=""><i class="layui-icon layui-icon-snowflake"></i>随笔<span class="layui-badge-dot"></span></a>
                        </li>
                        <li class="layui-nav-item">
                            <a href=""><i class="layui-icon layui-icon-component"></i>音乐<span class="layui-badge-dot"></span></a>
                        </li>
                        <li class="layui-nav-item">
                            <a href=""><i class="iconfont icon-eit"></i>部落格<span class="layui-badge-dot"></span></a>
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
                    <div class="border-box bgc-fff" id="demo">
                        
                       
                    </div>
                </div>
                <div class="layui-col-md3">
                    <div class=" mg-l-10" >
                        <div class="bgc-fff pd-15-20 mg-b-10 border-box" id="u_box">
                            
                        </div>
                        <div class="layui-card border-box bgc-fff mg-b-10">
                            <div class="layui-card-header layui-bg-blue">阅读榜单</div>
                            <div class="layui-card-body">
                                <a href="#">文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                            </div>
                        </div>
                        <div class="layui-card border-box bgc-fff mg-b-10">
                            <div class="layui-card-header layui-bg-green">归档</div>
                            <div class="layui-card-body">
                                <a href="#">文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                            </div>
                        </div>
                        <div class="layui-card border-box bgc-fff mg-b-10">
                            <div class="layui-card-header layui-bg-cyan">推荐榜单</div>
                            <div class="layui-card-body">
                                <a href="#">文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                                <a href="#">文章名称文章名称文章名称文章名称</a></br>
                            </div>
                        </div>
                        <div class="layui-card border-box bgc-fff mg-b-10">
                            <div class="layui-card-header layui-bg-gray">友情链接</div>
                            <div class="layui-card-body">
                                <a href="#">文章名称文章名称文章名称</a>
                                <a href="#">文章名称文章名称文章名称文章名称</a>
                                <a href="#">文章名称文章名称文章名称文章名称</a>
                                <a href="#">文章名称文章名称文章名称文章名称</a>
                                <a href="#">文章名称文章名称文章名称文章名称</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <!--内容结束-->
        <footer class="center">
            <div>
                Copyright © 2018 xiaojitui. All Rights Reserved
            </div>
        </footer>
    </div>
    <!-- 你的HTML代码 -->
    <script src="${pageContext.request.contextPath }/res/js/my.js"></script>
    <script src="${pageContext.request.contextPath }/res/layuiadmin/layui/layui.js"></script>
    <script>
    //一般直接写在一个js文件中
  
    layui.config({
        base: '${pageContext.request.contextPath }/res/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'home']);
    </script>
</body>

</html>