package com.demo.lib.trace.feign;

import feign.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    //tell feign that we need to log BASIC info for a request
    @Bean
    @ConditionalOnMissingBean(Logger.Level.class)
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    //we provide a customized logger for logging.
    @Bean
    @ConditionalOnMissingBean(feign.Logger.class)
    public Logger feignLogger() {
        return new FeignLogger();
    }
}
