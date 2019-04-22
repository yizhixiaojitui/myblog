package cn.broccoli.blog.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.broccoli.blog.mapper.UserMapper;

public class HomeInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(HomeInterceptor.class);
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String name="";
		try {
			name=(String)pathVariables.get("name");
		} catch (Exception e) {
			name="";
		}
		if(!"".equals(name)||null!=name) {
			
			System.out.println("requestURL"+request.getRequestURL());
			System.out.println("------preHandle--------"+name);
			if(userMapper.countByName(name)==1) {
				System.out.println("----校验成功----");
				return true;
			}else {
				
				System.out.println("----校验失败,'"+name+"' 此用户不存在----");
				request.getRequestDispatcher(request.getContextPath()+"/404.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/404.jsp");
				return false;
			}
		}else {
			return false;
		}
		
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
