/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(function(e) {
    var i = (layui.$, layui.layer, layui.laytpl, layui.setter, layui.view, layui.admin);
    i.events.logout = function() { i.req({ url: resPath + "/account/logout", type: "get", data: {}, done: function(e) { i.exit(function() { layer.msg('玩命卖萌中', function(){location.href = "/account/login"}); }) } }) }, e("common", {})
});