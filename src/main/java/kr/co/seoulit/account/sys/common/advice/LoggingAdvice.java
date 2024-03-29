package kr.co.seoulit.account.sys.common.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggingAdvice  implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String className = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		if(log.isDebugEnabled()) {
			log.debug(className + " : " + methodName + "( ) 시작");
			Object[] args = invocation.getArguments();
			if((args !=null) && (args.length >0)) {
				for(int i =0 ; i< args.length; i++) {
					log.debug("매개값 : [" + i + "]" + args[i]);
				}
			}
			
		}
		Object returnValue = invocation.proceed();
		
		
		if(log.isDebugEnabled()) {
			log.debug(className + " : " + methodName + "( ) 종료");}
		return returnValue;
	}

}