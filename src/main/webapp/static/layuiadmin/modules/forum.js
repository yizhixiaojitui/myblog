/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(e) {
    var t = layui.$,
        i = layui.table;
    layui.form;
    i.render({
        elem: "#LAY-app-forum-list",
        url: layui.setter.base + "json/forum/list.js",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "id", width: 100, title: "ID", sort: !0 }, { field: "poster", title: "发帖人" }, { field: "avatar", title: "头像", width: 100, templet: "#imgTpl" }, { field: "content", title: "发帖内容" }, { field: "posttime", title: "发帖时间", sort: !0 }, { field: "top", title: "置顶", templet: "#buttonTpl", minWidth: 80, align: "center" }, { title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-forum-list" }]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-app-forum-list)", function(e) {
        e.data;
        if ("del" === e.event) layer.confirm("确定删除此条帖子？", function(t) { e.del(), layer.close(t) });
        else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑帖子",
                content: "../../../views/app/forum/listform.html",
                area: ["550px", "400px"],
                btn: ["确定", "取消"],
                resize: !1,
                yes: function(e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = "LAY-app-forum-submit",
                        o = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function(t) {
                        t.field;
                        i.reload("LAY-app-forum-list"), layer.close(e)
                    }), o.trigger("click")
                },
                success: function(e, t) {}
            })
        }
    }), i.render({
        elem: "#LAY-app-forumreply-list",
        url: layui.setter.base + "json/forum/replys.js",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "id", width: 100, title: "ID", sort: !0 }, { field: "replyer", title: "回帖人" }, { field: "cardid", title: "回帖ID", sort: !0 }, { field: "avatar", title: "头像", width: 100, templet: "#imgTpl" }, { field: "content", title: "回帖内容", width: 200 }, { field: "replytime", title: "回帖时间", sort: !0 }, { title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-forum-replys" }]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-app-forumreply-list)", function(e) {
        e.data;
        if ("del" === e.event) layer.confirm("确定删除此条评论？", function(t) { e.del(), layer.close(t) });
        else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑评论",
                content: "../../../views/app/forum/replysform.html",
                area: ["550px", "350px"],
                btn: ["确定", "取消"],
                resize: !1,
                yes: function(t, i) {
                    var l = i.find("iframe").contents().find("#layuiadmin-form-replys"),
                        r = l.find('textarea[name="content"]').val();
                    e.update({ content: r }), layer.close(t)
                },
                success: function(e, t) {}
            })
        }
    }), e("forum", {})
});