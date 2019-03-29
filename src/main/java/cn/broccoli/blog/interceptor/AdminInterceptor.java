package cn.broccoli.blog.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.broccoli.blog.utils.JWTUtil;

public class AdminInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(AdminInterceptor.class);
	@Autowired
	JWTUtil jwtUtil;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String contextPath=request.getContextPath();
		Object sessionToken=request.getSession().getAttribute("access_token");
		logger.info("sessionToken"+(String)sessionToken);
		//session不为空
		if(sessionToken!=null) {
			
			//jwt是否在有效期  不在清除session 跳转login
			logger.info("headerToken==null");
			
			
			return true;
		}
		//如果是ajax请求 请求头会有x-requested-with
		String requestWith = request.getHeader("x-requested-with" );
		if(requestWith != null && requestWith.equalsIgnoreCase("XMLHttpRequest" )) {
			String headerToken=request.getHeader("access_token");
			if(headerToken!=null) {
				//请求头token不为空 验证有效期 不在跳转login
				return true;
			}else {
				return false ; 
			}
		}else {
			  response.sendRedirect(contextPath+"/login");
		}
		System.out.println("requestURL"+request.getRequestURL());
		System.out.println("AdminInterceptor.preHandle()");
			return false;
		
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AdminInterceptor.postHandle()");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AdminInterceptor.afterCompletion()");
	}

}
