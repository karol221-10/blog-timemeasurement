package pl.kompikownia.blog.aspect.timemeasurement.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pl.kompikownia.blog.aspect.timemeasurement.annotation.CheckPermission;
import pl.kompikownia.blog.aspect.timemeasurement.businesslogic.PermissionChecker;
import pl.kompikownia.blog.aspect.timemeasurement.exception.InsufficientPermissionException;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class CheckPermissionAspect {

    private final PermissionChecker permissionChecker;

    @Pointcut("execution(* *(..))")
    public void shouldRunOnAnyPublicMethod() { }

    @Pointcut("@annotation(pl.kompikownia.blog.aspect.timemeasurement.annotation.CheckPermission)")
    public void shouldRunForMethodAnnotatedWithRequestPermissionAnnotation() { }

    @Before("shouldRunOnAnyPublicMethod() && shouldRunForMethodAnnotatedWithRequestPermissionAnnotation()")
    public void checkPermissionAspect(JoinPoint joinPoint) {
        val signature = (MethodSignature)joinPoint.getSignature();
        val method = signature.getMethod();
        val annotation = method.getAnnotation(CheckPermission.class);
        log.debug("Required permissions: {}", annotation.value());
        if (!permissionChecker.checkPermission(annotation.value())) {
            throw new InsufficientPermissionException();
        }
    }
}
