/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(t) {
    var e = layui.$,
        i = layui.table,
        n = layui.form;
    i.render({
        elem: "#content-list",
        url: resPath + "/api/article/getAllArticle",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "articleId", title: "ID", width: 60, sort: !0 }, { field: "articleName", title: "标题", minWidth: 100 }, { field: "userNikename", title: "作者" }, { field: "articleClick", title: "人数", sort: !0 }, { field: "sortArticleName", title: "分类" }, { field: "articleTime", width: 150, title: "发布时间", sort: !0, templet: "<div>{{layui.util.toDateString(d.articleTime,'yyyy-MM-dd HH:mm:ss')}}</div>" }, { field: "articleStatus", title: "所属模块", templet: "#moduleTpl", minWidth: 60, align: "center" }, { field: "articleStatus", title: "发布状态", templet: "#buttonTpl", minWidth: 80, align: "center" }, { title: "操作", minWidth: 150, align: "center", fixed: "right", toolbar: "#table-content-list" }]
        ],
        headers: { //通过 request 头传递
            access_token: layui.data('layuiAdmin').access_token
        },
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！"
    }), i.on('tool(content-list)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = JSON.stringify(obj.tr); //获得当前行 tr 的DOM对象

        if (layEvent === 'detail') { //查看
            //do somehing
        } else if (layEvent === 'del') { //删除
            layer.confirm('真的删除ID为' + data.articleId + '的文章吗？', function(index) {
                console.log(JSON.stringify(data));
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                var arr = [];
                arr.push(data);
                console.log(arr);
                console.log(JSON.stringify(arr));
                //向服务端发送删除指令 ajax
                e.ajax({
                    url: resPath + "/api/article/delete?r=" + Math.random(),
                    type: "Delete",
                    data: JSON.stringify(arr),
                    headers: { //通过 request 头传递
                        access_token: layui.data('layuiAdmin').access_token
                    },
                    contentType: "application/json",
                    dataType: "json",
                    success: function(res) {
                        if (res.code == 0) {
                            layer.msg('已删除' + res.data);
                            i.reload('content-list');
                        } else {
                            layer.msg(res.msg);
                        }
                    },
                    error: function(XMLHttpRequest, textStatus,
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
        } else if (layEvent === 'edit') { //编辑
            //do something
        	
        	var layerindex=layer.open({
                type: 2,
                title: '修改文章',
                content: '../article/revise',
                maxmin: true,
                area: ['550px', '550px'],
                btn: ['确定', '取消'],
                maxmin: true,
                success: function(layero, index){
                	var iframe = window['layui-layer-iframe'+index];//获取子页面dom对象
                	iframe.child(data.articleId);
                	//向子页面传递id
                },
                yes: function(index, layero){
                	console.log('yes');
                	var iframeWindow = window['layui-layer-iframe'+ index]
                    ,submitID = 'edit-article'
                    ,submit = layero.find('iframe').contents().find('#'+ submitID);
                    //监听提交
                    iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                      var field = data.field; //获取提交的字段
                      field.articleType = field.articleType ? 1 : 0;
                      field.articleUp = field.articleUp ? 1 : 0;
                      field.articleSupport = field.articleSupport ? 1 : 0;
                      console.log(field.articleType);
                      console.log(JSON.stringify(field));
                      e.ajax({
                          url: resPath + "/api/article/update",
                          type: "post",
                          data: JSON.stringify(field),
                          contentType: "application/json",
                          dataType: "json",
                          success: function(res) {
                              if (res.code == 0) {
                              	 layer.msg(res.msg);
                              	 layer.close(index); 
                              } else {
                                  layer.msg(res.msg);
                              }
                          },
                          error: function(XMLHttpRequest, textStatus,
                              errorThrown) {
                              // 状态码
                              console.log(XMLHttpRequest.status);
                              // 状态
                              console.log(XMLHttpRequest.readyState);
                              // 错误信息   
                              console.log(textStatus);
                          }
                      });
                      //提交 Ajax 成功后，静态更新表格中的数据
                      //$.ajax({});
                     
                     //关闭弹层
                    }); 
                    submit.trigger('click');
                  }
              });
        	layer.full(layerindex);
        	
        	
            //同步更新缓存对应的值

        }
    }), i.render({
        elem: "#LAY-app-content-tags",
        url: layui.setter.base + "json/content/tags.js",
        cols: [
            [{ type: "numbers", fixed: "left" }, { field: "id", width: 100, title: "ID", sort: !0 }, { field: "tags", title: "分类名", minWidth: 100 }, { title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#layuiadmin-app-cont-tagsbar" }]
        ],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-app-content-tags)", function(t) {
        var i = t.data;
        if ("del" === t.event) layer.confirm("确定删除此分类？", function(e) { t.del(), layer.close(e) });
        else if ("edit" === t.event) {
            e(t.tr);
            layer.open({
                type: 2,
                title: "编辑分类",
                content: "../../../views/app/content/tagsform.html?id=" + i.id,
                area: ["450px", "200px"],
                btn: ["确定", "取消"],
                yes: function(e, i) {
                    var n = i.find("iframe").contents().find("#layuiadmin-app-form-tags"),
                        l = n.find('input[name="tags"]').val();
                    l.replace(/\s/g, "") && (t.update({ tags: l }), layer.close(e))
                },
                success: function(t, e) {
                    var n = t.find("iframe").contents().find("#layuiadmin-app-form-tags").click();
                    n.find('input[name="tags"]').val(i.tags)
                }
            })
        }
    }), i.render({
        elem: "#LAY-app-content-comm",
        url: layui.setter.base + "json/content/comment.js",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "id", width: 100, title: "ID", sort: !0 }, { field: "reviewers", title: "评论者", minWidth: 100 }, { field: "content", title: "评论内容", minWidth: 100 }, { field: "commtime", title: "评论时间", minWidth: 100, sort: !0 }, { title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-content-com" }]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-app-content-comm)", function(t) {
        t.data;
        "del" === t.event ? layer.confirm("确定删除此条评论？", function(e) { t.del(), layer.close(e) }) : "edit" === t.event && layer.open({
            type: 2,
            title: "编辑评论",
            content: "../../../views/app/content/contform.html",
            area: ["450px", "300px"],
            btn: ["确定", "取消"],
            yes: function(t, e) {
                var n = window["layui-layer-iframe" + t],
                    l = "layuiadmin-app-comm-submit",
                    a = e.find("iframe").contents().find("#" + l);
                n.layui.form.on("submit(" + l + ")", function(e) {
                    e.field;
                    i.reload("LAY-app-content-comm"), layer.close(t)
                }), a.trigger("click")
            },
            success: function(t, e) {}
        })
    }), t("contlist", {})
});