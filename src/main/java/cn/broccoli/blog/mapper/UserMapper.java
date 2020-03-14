package cn.broccoli.blog.mapper;

import cn.broccoli.blog.dto.SysAdminUserDTO;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.po.UserExample;
import cn.broccoli.blog.utils.UserHelper;
import cn.broccoli.blog.utils.UserList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int countByName(String name);
    //根据用户名查询用户id
    Integer selectIdByName(String name);
    //根据用户名查询用户
    User selectByUserName(String name);
    //修改密码
    int updatePassword(@Param("userId")Integer userId,@Param("password")String password);
    //根据用户id查询用户详细信息
    UserHelper selectUserInfoById(Integer userId) ;
    //修改用户信息
    int updateUserInfo(UserHelper userHelper);
    //查询用户列表
    List<UserList> selectUsers(@Param("page")int page,@Param("limit")int limit,@Param("userId")Integer userId,@Param("userNikename")String userNikename,@Param("userEmail")String userEmail,@Param("userSex")String userSex);
    //根据userid锁定用户
    int updateUserLockByUserId(@Param("userId")Integer userId,@Param("userLock")Integer userLock);
    //查询用户角色授权list
    List<SysAdminUserDTO> selectAdminUsers(@Param("page")int page,@Param("limit")int limit,@Param("userId")Integer userId,@Param("userName")String userName,@Param("roleId")Long roleId);
    //查询用户角色授权 总行数
    int selectAdminUsersCount(@Param("userId")Integer userId,@Param("userName")String userName,@Param("roleId")Long roleId);
    //添加用户角色
    int insertAdminUserRole(@Param("userId")Integer userId,@Param("roleId")Long roleId); 
    //查询是否已添加角色
    int selectAdminUserRoleByuserIdOrRoleId(@Param("userId")Integer userId,@Param("roleId")Long roleId);
    //修改用户角色
    int updateAdminUserRoleByuserIdOrRoleId(@Param("userId")Integer userId,@Param("roleId")Long roleId);
    //批量删除用户拥有的这个角色
    int deleteAdminUserRoleByuserIdOrRoleId(List<SysAdminUserDTO> sysAdminUserDTO);
    
}