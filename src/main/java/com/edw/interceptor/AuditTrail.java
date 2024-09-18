package com.edw.interceptor;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

/**
 * <pre>
 *  com.edw.interceptor.AuditTrail
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 18 Sep 2024 9:27
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@InterceptorBinding
public @interface AuditTrail {
}
