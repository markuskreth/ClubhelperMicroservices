package de.kreth.clubhelper.messungen.aspects;

import static de.kreth.clubhelper.messungen.aspects.AbstractLoggerAspect.LogLevel.INFO;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RestLoggerAspect extends AbstractLoggerAspect {

    @Pointcut("execution (public * org.springframework.web.client.RestTemplate..*(..))")
    private void invocation() {
    }

    @Before("invocation()")
    public void logRestCall(JoinPoint joinPoint) {
	log(INFO, joinPoint);
    }

}
