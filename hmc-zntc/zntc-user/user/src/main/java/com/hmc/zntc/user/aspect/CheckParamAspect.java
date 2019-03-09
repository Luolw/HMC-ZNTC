
package com.hmc.zntc.user.aspect;


import com.hmc.zntc.user.exception.RRException;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * 参数校验切面类
 */
@Aspect
@Component
public class CheckParamAspect {

    /**
     * 在控制层切入代码
     */
    @Pointcut("execution(public * com.hmc.zntc.user.controller.*.*(..))")
    public void check() {
    }

    /**
     * 前置通知，拦截控制层的请求参数
     *
     * @param joinPoint
     */
    @Before("check()")
    public void checkParam(JoinPoint joinPoint) {
        // 获取所有的参数
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取所有的参数名称
        String[] parameterNames = signature.getParameterNames();
        // 是否包含'result'名称的参数，包含则返回当前在数组的索引，不在返回-1
        int resultIdex = ArrayUtils.indexOf(parameterNames, "result");

        if (resultIdex != -1) {
            BindingResult bindingResult;
            try {
                bindingResult = (BindingResult) args[resultIdex];
            } catch (Exception e) {
                throw new RRException("系统异常");
            }
            if (bindingResult.hasErrors()) {
                String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
                throw new RRException(message);
            }
        }
    }

}


