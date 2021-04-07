package com.jomkie.aop;

import com.jomkie.common.ResultObj;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * execution: For matching method execution join points. This is the primary pointcut designator to use when working with Spring AOP.
 *
 * within: Limits matching to join points within certain types (the execution of a method declared within a matching type when using Spring AOP).
 *
 * this: Limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type.
 *
 * target: Limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type.
 *
 * args: Limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types.
 *
 * @target: Limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type.
 *
 * @args: Limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given types.
 *
 * @within: Limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP).
 *
 * @annotation: Limits matching to join points where the subject of the join point (the method being run in Spring AOP) has the given annotation.
 */

/**
 * Before advice: Advice that runs before a join point but that does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).
 *
 * After returning advice: Advice to be run after a join point completes normally (for example, if a method returns without throwing an exception).
 *
 * After throwing advice: Advice to be run if a method exits by throwing an exception.
 *
 * After (finally) advice: Advice to be run regardless of the means by which a join point exits (normal or exceptional return).
 *
 * Around advice: Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception.
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class WebAroundAop {

    @Pointcut("execution(public * com.jomkie.web..*.*(..))")
    public void testPointCut() {}

    @Around("testPointCut()")
    public Object aroundAop(ProceedingJoinPoint pjp) {

        try {
            System.out.println("进入了 aroundAop Start");
            System.out.println("进入了 aroundAop End");
            return pjp.proceed();
        } catch (Throwable throwable) {
            log.error("服务器异常", throwable);
            return ResultObj.fail();
        }

    }

}
