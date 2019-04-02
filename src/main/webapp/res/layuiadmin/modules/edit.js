//Demo
		layui.define([ 'form', 'layedit', 'jquery','inputTags' ], function(exports) {
			var form = layui.form, layedit = layui.layedit, $ = layui.$,inputTags = layui.inputTags;
			layedit.set({
				  uploadImage: {
				    url: resPath+'/api/file/article/image/upload' //接口url
				    ,type: 'post'
				  }
				});
			var index = layedit.build('editor', {
				height : 500
			//设置编辑器高度

			});
			console.log(resPath);
			
			$(":reset").on("click", function() {
				layedit.setContent(index, "");
				layedit.sync(index);
			});
			
			inputTags.render({
			      elem:'#inputTags',//定义输入框input对象
			      content: [],//默认标签
			      aldaBtn: true,//是否开启获取所有数据的按钮
			      done: function(value){ //回车后的回调
			        console.log(value)
			      }
			    })
			    
			getArticleSortList();
			//获取文章分类
        function getArticleSortList(){
			var resultData;

			var htmls = '<option value="">直接选择或搜索选择</option>'; //全局变量
			$.ajax({
				url : resPath+"/api/article/sort/getlist?r=" + Math.random(),
				type : "get",
				dataType : "json",
				headers: { //通过 request 头传递
				    access_token: layui.data('layuiAdmin').access_token
				  },
				success : function(res) {
				resultData = res.data;
				for ( var x in resultData) {
					htmls += '<option value = "' + resultData[x].sort_article_id + '">'
					+ resultData[x].sort_article_name
					+ '</option>'
			}
				$("#article_sort").html(htmls);
		}
	});
			form.render('select');//需要渲染一下
			};
			$("#addType").on(
					"click",
					function() {
						layer.prompt({
							title : '添加分类'
						}, function(value, index, elem) {
							$.ajax({
								url : resPath+"/api/article/sort/addsort?r=" + Math.random(),
								type : "post",
								data : {
									"articleSort" : value
								},
								dataType : "json",
								success : function(res) {
									if (res.data == true) {
										layer.close(index);
										getArticleSortList();
										layer.msg('添加中...', {
											  icon: 16
											  ,shade: 0.01
											},function(){
												layer.msg(res.msg);
											});
										
									} else {
										layer.msg('添加失败！');
									}
								},
								error : function(XMLHttpRequest, textStatus,
										errorThrown) {
									// 状态码
									console.log(XMLHttpRequest.status);
									// 状态
									console.log(XMLHttpRequest.readyState);
									// 错误信息   
									console.log(textStatus);
								}
							});

						});
					})
			//保存文章
			form.on('submit(formDemo)', function(data) {
				data.field.articleType = data.field.articleType ? 1 : 0;
				data.field.articleUp = data.field.articleUp ? 1 : 0;
				data.field.articleSupport = data.field.articleSupport ? 1 : 0;
				console.log(data.field.articleType); 
				console.log(JSON.stringify(data.field));
				$.ajax({
					url : resPath+"/api/article/save?r=" + Math.random(),
					type : "post",
					data :JSON.stringify(data.field),
					contentType:"application/json",
					dataType : "json",
					success : function(res) {
						if(res.code==0){
							layer.msg(res.msg);
						}else{
							layer.msg(res.msg);
						}
					},
					error : function(XMLHttpRequest, textStatus,
							errorThrown) {
						// 状态码
						console.log(XMLHttpRequest.status);
						// 状态
						console.log(XMLHttpRequest.readyState);
						// 错误信息   
						console.log(textStatus);
					}
				});

			
				return false;
			});
			form.verify({
				content : function(value) {
					if (layedit.getContent(index).length < 5) {
						return '文章字数太少啦~'
					}
					console.log(layedit.getText(index));
					//获取编辑器纯文本  截取55字
					var GET_EDITOR_DESCRIPTION_TEXT=layedit.getText(index);
					if(GET_EDITOR_DESCRIPTION_TEXT.length>55){
						GET_EDITOR_DESCRIPTION_TEXT=GET_EDITOR_DESCRIPTION_TEXT.substring(0,55);
					}
					console.log(GET_EDITOR_DESCRIPTION_TEXT);
					$("#articleDescription").val(GET_EDITOR_DESCRIPTION_TEXT);
					//同步编辑器内容
					return layedit.sync(index);
				}
			});
			 exports('edit', {});
		});
		
