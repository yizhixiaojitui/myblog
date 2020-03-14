package cn.broccoli.blog.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import cn.broccoli.blog.dto.SysAdminUserDTO;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.utils.LoginHelper;
import cn.broccoli.blog.utils.UserHelper;
import cn.broccoli.blog.utils.UserList;

public interface UserService {
	int selectIdByName(String name);

	String countByName(String name);
	//根据用户名查询用户
	User findUserByUsername(String name);
	//根据id查询用户
	User findUserById(Integer userId);
	//登出
	boolean userLogout(HttpServletResponse response);
	//登陆
	Map<String, String> LoginSignup(HttpServletRequest request,HttpServletResponse response,LoginHelper login);
	//修改用户密码
	int modifyUserPassword(Integer userid,String oldPassword,String password);
	//根据用户id查询用户详细信息
	UserHelper findUserInfoById(Integer userId);
	//修改用户信息
	int modifyUserInfo(UserHelper userHelper,Integer userid);
	//查询网站所有用户
	List<UserList> findUsersList(int page,int limit,Integer userId,String userNikename,String userEmail,String userSex);

	//新增用户
	int addUser(HttpServletRequest request,User user);
	//锁定用户
	int modifyUserLock(Integer userId,Integer userLock);
	//查询角色授权列表list
	List<SysAdminUserDTO> findAdminUsers(int page,int limit,Integer userId,String userNikename,Long roleId);
	//查询角色授权列表list 总行数
	int findAdminUsersCount(Integer userId,String userNikename,Long roleId);
	
	//添加用户角色
    int addAdminUserRole(Integer userId,Long roleId); 
    //查询是否已添加角色
    int findAdminUserRoleByuserIdOrRoleId(Integer userId,Long roleId);
    //修改用户角色
    int modifyAdminUserRoleByuserIdOrRoleId(Integer userId,Long roleId);
    //批量删除用户拥有的这个角色
    int removeAdminUserRoleByuserIdOrRoleId(List<SysAdminUserDTO> sysAdminUserDTO);
}
