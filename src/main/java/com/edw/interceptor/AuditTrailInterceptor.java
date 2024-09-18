package com.edw.interceptor;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *  com.edw.interceptor.AuditTrailInterceptor
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 18 Sep 2024 9:08
 */
@AuditTrail
@Priority(10)
@Interceptor
public class AuditTrailInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @AroundInvoke
    public Object printLog (InvocationContext ctx) throws Exception {
        logger.debug("intercepting {} ", ctx.getMethod().getName());
        return ctx.proceed();
    }

}