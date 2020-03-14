/**  
* @Title: UserRealm.java  
* @Package cn.broccoli.blog.shiro  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Administrator  
* @date 2019年8月18日  
* @version V1.0  
*/
package cn.broccoli.blog.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.broccoli.blog.po.SysRoleAuthority;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.SysRoleAuthorityService;
import cn.broccoli.blog.service.SysRoleService;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.JWTUtil;
import plm.common.exceptions.UnloginException;
import plm.common.utils.SaleUtil;

/**  
* @ClassName: UserRealm  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author Administrator  
* @date 2019年8月18日  
*    
*/
public class UserRealm extends AuthorizingRealm{
	private static Logger logger = Logger.getLogger(UserRealm.class);
	
	 @Autowired  
	 private UserService userService;  
	 @Autowired
	 private SysRoleService sysRoleService;
	 @Autowired
	 private SysRoleAuthorityService sysRoleAuthorityService;
	/**
	* <p>Title: doGetAuthorizationInfo</p>  
	* <p>Description: </p>  
	* @param arg0
	* @return  
	* @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)  
	*/ 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		User user = (User) principalCollection.getPrimaryPrincipal();
		System.out.println("doGetAuthorizationInfo=>"+user.getUserName());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roleNames = new HashSet<String>();
        List<String> roleNameList=sysRoleService.findRoleNameByUserId(user.getUserId());
        for (String roleName : roleNameList) {
        	System.out.println("roleName:"+roleName);
        	roleNames.add(roleName);
		}
		authorizationInfo.setRoles(roleNames);
		Set<String> permissionNames = new HashSet<String>();
		List<String> permissionList=sysRoleAuthorityService.findAuthorityByUserid(user.getUserId());
		for (String authorName : permissionList) {
			System.out.println("authorName:"+authorName);
			permissionNames.add(authorName);
		}
		authorizationInfo.setStringPermissions(permissionNames);
		return authorizationInfo;
	}

	/**
	* <p>Title: doGetAuthenticationInfo</p>  
	* <p>Description: </p>  
	* @param arg0
	* @return
	* @throws AuthenticationException  
	* @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)  
	*/ 
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token=(UsernamePasswordToken)authcToken;
		String username = token.getUsername();
		String password = String.valueOf(token.getPassword());
		logger.info("doGetAuthenticationInfo =>> password:"+password);
		User user = userService.findUserByUsername(username);
		//当用户存在时
		if(user!=null) {
			if (user.getUserLock()==1) {
				logger.info("用户已锁定："+username);
	            throw new LockedAccountException();
	        }
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getUserPwd(),username);
		//生成token 存入session
		Session session=SecurityUtils.getSubject().getSession();
		String accessToken=JWTUtil.generToken(user.getUserId().toString(),null, null);
		session.setAttribute("access_token",accessToken);
		return info;
		}
		return null;
	}

}
