package aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import space.jbpark.utility.MyUtil;

@Aspect
public class LoggingAspect {
	private Logger logger = MyUtil.getLogger(LoggingAspect.class.getName());

	@Around("execution (* services.*.*(..))")
	public Object logServiceCalls(ProceedingJoinPoint joinPoint)
			throws Throwable {
		logger.info("호출 차단 - 호출 전");
		Object result = joinPoint.proceed();
		logger.info("호출 차단 - 호출 전");
		return result;
	}
}
