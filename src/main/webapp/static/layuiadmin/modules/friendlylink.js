/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(t) {
    var e = layui.$,
        i = layui.table,
        n = layui.form;
    i.render({
        elem: "#friendlylink-list",
        url: resPath + "/api/friendlyLink/getlist",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "linkId", title: "ID", sort: !0 }, { field: "linkName", title: "名称" }, { field: "linkUrl", title: "地址" }, { field: "showOrder", title: "排序" }, { title: "操作", minWidth: 150, align: "center", fixed: "right", toolbar: "#table-content-list" }]
        ],
        headers: { //通过 request 头传递
            access_token: layui.data('layuiAdmin').access_token
        },
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！"
    }), i.on('tool(friendlylink-list)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = JSON.stringify(obj.tr); //获得当前行 tr 的DOM对象

        if (layEvent === 'detail') { //查看
            //do somehing
        } else if (layEvent === 'del') { //删除
            layer.confirm('真的删除ID为:' + data.linkId + '的文章吗？', function(index) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                var arr = [];
                arr.push(data);
                //向服务端发送删除指令 ajax
                e.ajax({
                    url: resPath + "/api/friendlyLink/delete?r=" + Math.random(),
                    type: "Delete",
                    data: JSON.stringify(arr),
                    headers: { //通过 request 头传递
                        access_token: layui.data('layuiAdmin').access_token
                    },
                    contentType: "application/json",
                    dataType: "json",
                    success: function(res) {
                        if (res.code == 0) {
                            layer.msg('已删除-' + res.data);
                            i.reload('friendlylink-list');
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
    }), t("friendlylink", {})
});