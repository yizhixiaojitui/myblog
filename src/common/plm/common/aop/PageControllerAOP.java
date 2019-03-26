package plm.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import plm.common.beans.PageResultBean;
import plm.common.exceptions.CheckException;
import plm.common.exceptions.NoPermissionException;
import plm.common.exceptions.UnloginException;

/**
 * 处理和包装异常
 * 
 * @author 晓风轻 https://github.com/xwjie/PLMCodeTemplate
 */
public class PageControllerAOP {
	private static final Logger logger = LoggerFactory.getLogger(PageControllerAOP.class);

	public Object handlerPageControllerMethod(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();

		PageResultBean<?> result=new PageResultBean();;

		try {
			result = (PageResultBean<?>) pjp.proceed();
			
			// 如果需要打印入参，可以从这里取出打印
			// Object[] args = pjp.getArgs();

			logger.info("************PageControllerAOP***********");
			// 本次操作用时（毫秒）
			long elapsedTime = System.currentTimeMillis() - startTime;
			logger.info("[{}]use time: {}", pjp.getSignature(), elapsedTime);
		} catch (Throwable e) {
			result = handlerException(pjp, e);
		}

		return result;
	}

	private PageResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
		PageResultBean<?> result = new PageResultBean();

		// 已知异常【注意：已知异常不要打印堆栈，否则会干扰日志】
		// 校验出错，参数非法
		if (e instanceof CheckException || e instanceof IllegalArgumentException) {
			result.setMsg(e.getLocalizedMessage());
			result.setCode(PageResultBean.CHECK_FAIL);
		}
		// 没有登陆
		else if (e instanceof UnloginException) {
			result.setMsg("Unlogin");
			result.setCode(PageResultBean.NO_LOGIN);
		}
		// 没有权限
		else if (e instanceof NoPermissionException) {
			result.setMsg("NO PERMISSION");
			result.setCode(PageResultBean.NO_PERMISSION);
		} else {
			logger.error(pjp.getSignature() + " error ", e);

			// TODO 未知的异常，应该格外注意，可以发送邮件通知等
			result.setMsg(e.toString());
			result.setCode(PageResultBean.UNKNOWN_EXCEPTION);
		}

		return result;
	}
}
