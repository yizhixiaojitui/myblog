layui.define(['layer','util', 'jquery','flow'],function(exports){ //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
	 var $ = layui.$,
     layer = layui.layer,
     flow = layui.flow,
     util=layui.util;
	 
	
              $.get(basePath+'/getbloginfo', function(res){
            	  var obj=res.data;
            	  document.title =obj.blogTitle;
            	  $('.layui-logo-brand').html('<a href="'+basePath+'"><h2>'+obj.blogName+'</h2></a>');
            	 var htmlStr='<div class="my-blogger-img mg-b-20"> <a href="'+basePath+'"><img src="'+resPath+'/res/images/'+
            			  obj.userImageUrl+'"></a></div><div class="my-blogger-detail center"><div class="mg-b-10"><span class="my-blogger-name">'
            			  +obj.userNikename+'</span><span class="my-blogger-sex">';
            	 if(obj.userSex==1){
            		 htmlStr+='<i class="layui-icon layui-icon-male"></i>';
            	 };
            	 if(obj.userSex==0){
            		 htmlStr+='<i class="layui-icon layui-icon-female"></i>';
            	 };
            	 htmlStr+='</span></div><p class="mg-b-10">'
            		 +obj.userDescription+'</p><div class="my-article-class"><div class="my-article-class-title layui-row layui-col-space10"><div class="layui-col-md6">文章</div><div class="layui-col-md6">浏览人数</div></div><div class="my-article-class-num layui-row layui-col-space10"><div class="layui-col-md6"><a href="#">'
            		 +obj.articleNum+'</a></div><div class="layui-col-md6"><a href="#">'+obj.pageView+'</a></div></div></div></div>';
            
              $('#u_box').html(htmlStr);
              });

		  flow.load({
	            elem: '#demo' //指定列表容器
	            ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
	              var lis = [];
	              //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
	              $.get(basePath+'/article?page='+page, function(res){
	                //假设你的列表返回在data集合中
	                 console.log(page);
	                layui.each(res.data, function(index, item){
	                  lis.push('<div class="body-box-15 mg-b-10 my-article-list"> <h3 class="mg-b-10"><a href="'+basePath+'/article/details/'+item.articleId+'" title="'+item.articleName+'">'+
	                		  item.articleName+'</a>');
	                  if(item.articleSupport==1){
		                	lis.push(' <span class="layui-badge layui-bg-red">推荐</span>')
		                }
	                  lis.push('</h3><div class="mg-b-10">');
	               
	                lis.push('<span class="layui-badge layui-bg-orange">'+item.sortArticleName+
	                		'</span><span class="top-text"><i class="iconfont icon-time"></i>'+util.timeAgo(item.articleTime, true)+'</span><span class="top-text"><i class="iconfont icon-browse"></i>'+item.articleClick+'</span><span class="top-text"><i class="iconfont icon-message"></i>'+item.articleClick+'</span></div><p class="layui-elip layui-text">'+item.articleDescription+'</p></div><hr>')
	                }); 
	                
	                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
	                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
	                next(lis.join(''), page < res.pageCount);    
	              });
	            }
	          });

  
  //输出test接口
		  exports('home', {});
});  