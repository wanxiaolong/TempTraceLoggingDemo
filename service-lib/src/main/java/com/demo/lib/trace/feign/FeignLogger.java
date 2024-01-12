package com.demo.lib.trace.feign;

import feign.Request;
import feign.Response;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class FeignLogger extends Slf4jLogger {
    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        String subsystem = request.requestTemplate().feignTarget().name();
        String method = request.httpMethod().name();
        log.info("ApiCall started. subsystem={}, URL:{} {}", subsystem, method, request.url());
        super.logRequest(configKey, logLevel, request);
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        Request request = response.request();
        String subsystem = request.requestTemplate().feignTarget().name();
        String method = request.httpMethod().name();
        log.info("ApiCall completed. subsystem:{}, URL:{} {}, status:{}, time:{}ms",
                subsystem, method, request.url(), response.status(), elapsedTime);

        return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
    }
}
