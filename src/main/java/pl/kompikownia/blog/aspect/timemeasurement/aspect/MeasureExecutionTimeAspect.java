package pl.kompikownia.blog.aspect.timemeasurement.aspect;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Slf4j
@Component
public class MeasureExecutionTimeAspect {

    @Pointcut("execution (public * pl.kompikownia.blog.aspect.timemeasurement.service..*(..))")
    public void executeOnAnyPublicMethodForServices() {}

    @Pointcut("execution (public * pl.kompikownia.blog.aspect.timemeasurement.service..*(Object+,..))")
    public void executeOnAnyPublicMethodForServicesWithOneOrMoreArg() {}

    @Around("executeOnAnyPublicMethodForServices()")
    public Object runMeasure(ProceedingJoinPoint pjp) throws Throwable {
        val startTime = System.currentTimeMillis();
        log.info("Executing method {} started", pjp.getSignature().getName());
        val result = pjp.proceed();
        val endTime = System.currentTimeMillis() - startTime;
        log.info("Processing of method {} ended in time {} ms", pjp.getSignature().getName(), endTime);
        return result;
    }

    @Around("executeOnAnyPublicMethodForServicesWithOneOrMoreArg()")
    public Object runArgumentLogging(ProceedingJoinPoint pjp) throws Throwable {
        StringBuilder stringBuilder = new StringBuilder();
        for(val methodArg: pjp.getArgs()) {
            stringBuilder.append(methodArg.toString());
            stringBuilder.append(" ");
        }
        log.info("Method {} started with arguments {}", pjp.getSignature().getName(), stringBuilder.toString());
        val result = pjp.proceed();
        log.info("Method {} returned with result {}", pjp.getSignature().getName(), Optional.ofNullable(result).orElse("void").toString());
        return result;
    }
}
