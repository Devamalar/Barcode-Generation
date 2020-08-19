package com.barcode.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("within(com.barcode.controller.BarcodeController)")
    public void logMethodCalls(JoinPoint joinPoint) {
        LOGGER.info("Invoked: {}", joinPoint.getSignature().toShortString());
    }
}
