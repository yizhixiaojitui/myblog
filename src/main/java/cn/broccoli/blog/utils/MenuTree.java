package cn.broccoli.blog.utils;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {

	private List<Menu> menuList=new ArrayList<Menu>();
	public MenuTree(List<Menu> list) {
		this.menuList=list;
	}
	
	//建立树形结构
	public List<Menu> builTree(){
		List<Menu> treeMenus =new  ArrayList<Menu>();
		//循环获取的父节点
		 for(Menu menuNode : getRootNode()) {
			 menuNode=buildChilTree(menuNode);
			 treeMenus.add(menuNode);
		 }
		return treeMenus;
	}
	
	private Menu buildChilTree(Menu menu) {
		//初始化子树形 children list
		List<Menu> chilMenus =new  ArrayList<Menu>();
		for (Menu menuNode : menuList) {
			if(menu.getMenuCode().equals(menuNode.getParentMenucode())) {
				chilMenus.add(buildChilTree(menuNode));
			}
		}
		menu.setChildren(chilMenus);
		return menu;
	}
	
	//获取根节点
	private List<Menu> getRootNode(){
		List<Menu> rootMenuList=new ArrayList<Menu>();
		for (Menu menu : menuList) {
			if("".equals(menu.getParentMenucode())) {
				rootMenuList.add(menu);
			}
		}
		
		
		return rootMenuList;
	}
}
