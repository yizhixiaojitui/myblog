package cn.broccoli.blog.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import plm.common.beans.ResultBean;
import plm.common.exceptions.UnloginException;

public class AdminInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(AdminInterceptor.class);
	@Autowired
	JWTUtil jwtUtil;
	@Autowired
	UserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String contextPath=request.getContextPath();
		//session不为空
			String token=jwtUtil.getCookieToken(request);
			
			logger.info("*************"+token);
			if(jwtUtil.checkToken(token)) {
				Integer id=Integer.valueOf(JWTUtil.verifyToken(token).getId());
				System.out.println("AdminInterceptor.preHandle().id:"+id);
				User user=userService.findUserById(id);
				if(user!=null&&id.equals(user.getUserId())) {
					Cookie cookie = new Cookie("access_token",JWTUtil.updateToken(token));
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
					return true;
				}
			}
			response.sendRedirect(contextPath+"/login");
			System.out.println("requestURL"+request.getRequestURL());
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
	private boolean isAjaxResponse(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// ajax请求
		/**
		 * 判断是否已经踢出
		 * 1.如果是Ajax 访问，那么给予json返回值提示。
		 * 2.如果是普通请求，直接跳转到登录页
		 */
		//判断是不是Ajax请求
		//ResultBean<Boolean> responseResult ;
		//if (ShiroFilterUtils.isAjax(request) ) {
			//logger.debug(getClass().getName()+ "，当前用户的信息或权限已变更，重新登录后生效！");
			//responseResult.setCode(IStatusMessage.SystemStatus.UPDATE.getCode());
			//responseResult.setMessage("您的信息或权限已变更，重新登录后生效");
			//out(response, responseResult);
		//}else{
			// 重定向
			//WebUtils.issueRedirect(request, response, kickoutUrl);
		//}
		return false;
	}
	//ResponseResult result
	public static void out(HttpServletResponse response){
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");//设置编码
			response.setContentType("application/json");//设置返回类型
			out = response.getWriter();
			logger.error("用户在线数量限制【wyait-manage-->UserActionInterceptor.out】响应json信息成功");
		} catch (Exception e) {
			logger.error("用户在线数量限制【wyait-manage-->UserActionInterceptor.out】响应json信息出错", e);
		}finally{
			if(null != out){
				out.flush();
				out.close();
			}
		}
	}
}
