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
        });
        
       

    //输出home接口
    exports('home', {});
});