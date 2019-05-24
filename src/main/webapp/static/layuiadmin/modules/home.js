layui.define(['layer', 'util', 'jquery', 'flow','laytpl', 'element', 'layedit', 'code'], function(exports) { //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
    var i = layui.$,
        layer = layui.layer,
        flow = layui.flow,
        util = layui.util,
        element = layui.element,
        layedit = layui.layedit,
        code = layui.code,
        laytpl=layui.laytpl;

    //渲染创建评论编辑器
    layedit.build('comment', {
            height: 180, //设置编辑器高度
            tool: ['face', 'image', '|', 'strong',
                'italic', 'underline', '|', 'link',
                'code', 'preview'
            ]
        }),
        //渲染美化详情页代码样式
        code({
            elem: 'pre' //默认值为.layui-code
        }),
        //渲染右下角小工具
        util.fixbar({
            bar1: true,
            click: function(type) {
                console.log(type);
                if (type === 'bar1') {
                    alert('点击了bar1')
                }
            }
        }),
        //渲染加载导航栏用户信息栏
        i.get(resPath + '/home/getbloginfo?r='+Math.random()+'&u=' + username, function(res) {
        	if(res.code==0){
        		var getTpl=document.getElementById('right-view-tpl').innerHTML,
            	view = document.getElementById('right-view');
        		var data=res.data;
        		document.title=document.title+data.blogName+"的部落格";
        		i("#logourl").html(data.blogName);
        		i("#headid").append("<meta name='description' content="+data.blogDescription+"/>");
        		i("#headid").append("<meta name='keywords' content="+data.blogKeyword+"/>");
        		
        		laytpl(getTpl).render(data,function(html){
        			view.innerHTML = html;
        		})
        	}
        	
          
            
        }),
        //流加载渲染主页内容
        flow.load({
            elem: '#demo' //指定列表容器
                ,
            done: function(page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                console.log(resPath);
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                i.get(resPath + '/home/article?page=' + page + '&u=' + username, function(res) {
                	
                    //假设你的列表返回在data集合中
                    layui.each(res.data, function(index, item) {
                        lis.push('<div class="body-box-15 my-article-list"> <h3 class="mg-b-10"><a href="' + basePath + '/article/details/' + item.articleId + '" title="' + item.articleName + '">' +
                            item.articleName + '</a>');
                        if (item.articleUp == 1) {
                            lis.push(' <span class="layui-badge layui-bg-red">置顶</span>')
                        }
                        if (item.articleSupport == 1) {
                            lis.push(' <span class="layui-badge layui-bg-red">推荐</span>')
                        }
                        lis.push('</h3><div class="mg-b-10">');
                        lis.push('<span class="layui-badge layui-bg-orange">' + item.sortArticleName + '</span>');
                        lis.push('<span class="top-text"><i class="iconfont icon-time"></i>' + util.timeAgo(item.articleTime, true) + '</span>');
                        lis.push('<span class="top-text"><i class="iconfont icon-browse"></i>' + item.articleClick + '</span>');
                        lis.push('<span class="top-text"><i class="iconfont icon-message"></i>' + item.articleClick + '</span></div>');
                        lis.push('<p class="layui-elip layui-text">' + item.articleDescription + '</p></div><hr>');
                    });

                    i("#my-icon-loading").remove();
                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < res.pageCount);
                });
            }
        }),
        //渲染友情链接
        i.get(resPath + '/home/friendlyLink', function(res) {
            var obj = res.data;
            var lis = [];
            layui.each(res.data, function(index, item) {
                lis.push('<a href="' + item.linkUrl + '" target="_blank">' + item.linkName + '</a>');
            });
            i('#links').html(lis);
        });


    //输出home接口
    exports('home', {});
});