package cn.broccoli.blog.shiro;

import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* 类描述：  解决第一次登录时，url带jsessionid的问题
* 项目名称：store   
* 类名称：MySpringShiroFilter      
* 创建人：ZLY   
* 创建时间：2019年4月2日 上午9:34:00     
* 备注：
 */
public class MySpringShiroFilter extends AbstractShiroFilter {
    protected MySpringShiroFilter(WebSecurityManager webSecurityManager, FilterChainResolver resolver) {
        super();
        if (webSecurityManager == null) {
            throw new IllegalArgumentException("WebSecurityManager property cannot be null.");
        }
        setSecurityManager(webSecurityManager);
        if (resolver != null) {
            setFilterChainResolver(resolver);
        }
    }

    @Override
    protected ServletResponse wrapServletResponse(HttpServletResponse orig, ShiroHttpServletRequest request) {
        return new MyShiroHttpServletResponse(orig, getServletContext(), request);
    }
}
