/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["table", "form"], function(e) {
    var t = layui.$,
        i = layui.table;
    layui.form;
    i.render({
        elem: "#LAY-user-manage",
        url:  "../../../api/user/users/list",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "userId", width: 100, title: "ID", sort: !0 }, { field: "userNikename", title: "用户名", minWidth: 100 }, { field: "userImageUrl", title: "头像", width: 100, templet: "#imgTpl" }, { field: "userPhone", title: "手机" }, { field: "userEmail", title: "邮箱" }, { field: "userSex", width: 80, title: "性别" ,templet: "#sexTpl" }, { field: "userRegisterIp", title: "IP" }, { field: "userRegisterTime", title: "加入时间", sort: !0 , templet: "<div>{{layui.util.toDateString(d.userRegisterTime,'yyyy-MM-dd HH:mm:ss')}}</div>"},{field:'userLock', title:'是否锁定', width:110, templet: '#lockTpl', unresize: true}, { title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-useradmin-webuser" }]
        ],
        page: !0,
        limit: 30,
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-user-manage)", function(e) {
        var data=e.data;
        if ("del" === e.event) layer.prompt({ formType: 1, title: "敏感操作，请验证口令" }, function(t, i) { layer.close(i), layer.confirm("真的删除行么", function(t) { e.del(), layer.close(t) }) });
        else if ("edit" === e.event) {
            t(e.tr);
            
            console.log("data:"+data.userId);
            layer.open({
                type: 2,
                title: "编辑用户",
                content: "../../user/users/userform",
                maxmin: !0,
                area: ["500px", "450px"],
                btn: ["确定", "取消"],
                yes: function(e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = "LAY-user-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function(t) {
                        t.field;
                        i.reload("LAY-user-front-submit"), layer.close(e)
                    }), n.trigger("click")
                },
                success: function(e, t) {
                }
            })
        }
    }), i.render({
        elem: "#LAY-user-back-manage",
        url: "../../../api/user/administrator/list",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "userId", width: 80, title: "ID", sort: !0 }, { field: "userName", title: "登录名" }, { field: "userPhone", title: "手机" }, { field: "roleName", title: "角色" },{ field: "description", title: "角色介绍" }, { title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-useradmin-admin" }]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-user-back-manage)", function(e) {
        e.data;
        if ("del" === e.event) layer.prompt({ formType: 1, title: "敏感操作，请验证口令" }, function(s, i) { 
        	layer.close(i), layer.confirm("确定删除此管理员？", function(s) {
        	console.log(e.data);
        	var arr = [];
            arr.push(e.data);
        	t.ajax({
    			url : "../../../api/user/administrator/role/delete",
    			type : "DELETE",
    			contentType : "application/json",
    			dataType : "json",
    			data: JSON.stringify(arr),
    			success : function(res) {
    				if (res.code == 0) {
    					layer.msg("删除成功！");
    				} else {
    					layer.msg(res.msg);
    				}
    		},
    			error : function(XMLHttpRequest, textStatus, errorThrown) {
    			// 状态码
    			console.log(XMLHttpRequest.status);
    			// 状态
    			console.log(XMLHttpRequest.readyState);
    			// 错误信息   
    			console.log(textStatus);
    	}
    });
        	console.log(e), e.del(), layer.close(s) 
        	}) 
        	});
        else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑管理员",
                content: "../../user/administrators/adminform",
                area: ["420px", "420px"],
                btn: ["确定", "取消"],
                yes: function(e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = "LAY-user-back-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function(res) {
                        l.layui.$.ajax({
        					url : "../../../api/user/administrator/role/update",
        					type : "PUT",
        					contentType : "application/json",
        					dataType : "json",
        					data: JSON.stringify(res.field),
        					success : function(res) {
        						if (res.code == 0) {
        							layer.msg("修改成功！");
        						} else {
        							layer.msg(res.msg);
        						}
        					},
        					error : function(XMLHttpRequest, textStatus, errorThrown) {
        						// 状态码
        						console.log(XMLHttpRequest.status);
        						// 状态
        						console.log(XMLHttpRequest.readyState);
        						// 错误信息   
        						console.log(textStatus);
        					}
        				});
                        i.reload("LAY-user-back-manage"), layer.close(e)
                    }), n.trigger("click")
                },
                success: function(e, t) {
                	
                }
            })
        }
    }), i.render({
        elem: "#LAY-user-back-role",
        url: "../../../api/administrators/role/list",
        cols: [
            [{ type: "checkbox", fixed: "left" }, { field: "id", width: 80, title: "ID", sort: !0 }, { field: "roleName", title: "角色名" },{ field: "description", title: "具体描述" }, { field: "createTime", title: "创建时间", sort: !0 , templet: "<div>{{layui.util.toDateString(d.createTime,'yyyy-MM-dd HH:mm:ss')}}</div>"},{field:'status', title:'是否锁定', width:110, templet: '#lockRoleTpl', unresize: true}, { title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-useradmin-admin" }]
        ],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-user-back-role)", function(e) {
        var field=e.data;
        if ("del" === e.event) layer.confirm("确定删除此角色？", function(t) { e.del(),console.log(field), layer.close(t) });
        else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑角色",
                content: "../../user/administrators/editroleform",
                area: ["500px", "480px"],
                btn: ["确定", "取消"],
                yes: function(e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = t.find("iframe").contents().find("#LAY-user-role-submit");
                    l.layui.form.on("submit(LAY-user-role-submit)", function(res) {
                    	res.field;
                        console.log(JSON.stringify(res.field));
                        layui.$.ajax({
        					url : "../../../api/administrators/role/update",
        					type : "PUT",
        					contentType : "application/json",
        					dataType : "json",
        					data: JSON.stringify(res.field),
        					success : function(res) {
        						if (res.code == 0) {
        							layer.msg("修改成功！");
        						} else {
        							layer.msg(res.msg);
        						}
        					},
        					error : function(XMLHttpRequest, textStatus, errorThrown) {
        						// 状态码
        						console.log(XMLHttpRequest.status);
        						// 状态
        						console.log(XMLHttpRequest.readyState);
        						// 错误信息   
        						console.log(textStatus);
        					}
        				});
                        i.reload("LAY-user-back-role"), layer.close(e)
                    }), r.trigger("click")
                },
                success: function(layero, index) {
                	var iframeWindow = window['layui-layer-iframe'+ index];
                	var arr=[];
                	
                	t.ajax({
    					url : "../../../api/authority/checked/list",
    					type : "GET",
    					contentType : "application/json",
    					dataType : "json",
    					data: {
                            "roleId": field.id
                        },
    					success : function(res) {
    						if (res.code == 0) {
    							var resultData=res.data;
    							for (var x in resultData) {
    								console.log(resultData[x]);
    								arr.push(resultData[x]);
    					           }
    							//console.log(ids.map(Number));
    							
    						} else {
    							layer.msg(res.msg);
    						}
    					},
    					error : function(XMLHttpRequest, textStatus, errorThrown) {
    						// 状态码
    						console.log(XMLHttpRequest.status);
    						// 状态
    						console.log(XMLHttpRequest.readyState);
    						// 错误信息   
    						console.log(textStatus);
    					}
    				});
                	iframeWindow.child(arr,JSON.stringify(field));
                }
            })
        }
    }), e("useradmin", {})
});