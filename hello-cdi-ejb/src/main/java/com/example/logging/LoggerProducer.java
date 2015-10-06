package com.example.logging;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class LoggerProducer {

    @Produces
    @Log("")
    public Logger produceLog(InjectionPoint injectionPoint) {
        final Logger logger;
        final String loggerName = injectionPoint.getAnnotated().getAnnotation(Log.class).value();
        if (loggerName.length() == 0) {
            logger = LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        } else {
            logger = LoggerFactory.getLogger(loggerName);
        }
        return logger;
    }
}
