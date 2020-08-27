package com.liuqi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAop {
    private static Logger logger= LoggerFactory.getLogger(ServiceLogAop.class);
    /**
     * aop几种通知类型    ：
     *     前置通知：在方法调用在前通知
     *     后置通知：在方法正常调用之后进行通知
     *     环绕通知：在方法执行之前发之都通知
     *     异常通知：出现异常通知
     *     最终通知：方法执行后通知     */


    /**
     * 切面表达式：execution(1 2345)
     * execution 代表所要执行的表达式主体
     * 第一处 * 代表方法返回类型 *代表所有类型
     * 第二处 包名代表aop监控的类所在的包
     * 第三处 .. 代表该包以及其子包下的所有类方法
     * 第四处 * 代表类名，*代表所有类
     * 第五处 *(..) *代表类中的方法名，(..)表示方法中的任何参数
     *
     * @param joinPoint
     * @return
     */
    @Around("execution(* com.liuqi.service.Impl..*.*(..))")
    public Object recodTimeLog(ProceedingJoinPoint  joinPoint){
        logger.info("*******开始执行{}.{}*******",
                joinPoint.getTarget().getClass(),joinPoint.getSignature().getName());
        Object proceed=null;
        try {
            long begin=System.currentTimeMillis();
             proceed = joinPoint.proceed();
            long end =System.currentTimeMillis();
            long task=end-begin;
            if(task>3000){
                logger.error("=======执行结束，耗时{} 毫秒",task);
            }else if (task>2000){
                logger.warn("=======执行结束，耗时{} 毫秒",task);

            }
            logger.info("=======执行结束，耗时{} 毫秒",task);

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
