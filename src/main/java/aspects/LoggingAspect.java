package aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import space.jbpark.utility.MyUtil;

@Aspect
public class LoggingAspect {
	private Logger logger = MyUtil.getLogger(LoggingAspect.class.getName());

	private String msgBfr(ProceedingJoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder("메소드 사양");
		sb.append(System.lineSeparator());
		sb.append("\t- 이름: ");
		var mName = joinPoint.getSignature().getName();
		var argus = Arrays.asList(joinPoint.getArgs());
		sb.append(mName);
		sb.append(System.lineSeparator());
		sb.append("\t- 인자: ");
		sb.append(argus);
		return sb.toString();
	}

	@Around("@annotation(ToLog)")
	public Object logServiceCalls(ProceedingJoinPoint joinPoint)
			throws Throwable {
		logger.info(msgBfr(joinPoint));
		logger.info("호출 차단 - 호출 전");
		Object result = joinPoint.proceed();
		logger.info("호출 차단 - 호출 후");
		return result;
	}
}
