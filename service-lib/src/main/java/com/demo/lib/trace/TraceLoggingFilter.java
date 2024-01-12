//package com.demo.trace;
//
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.MDC;
//import org.springframework.cloud.sleuth.Span;
//import org.springframework.cloud.sleuth.Tracer;
//import org.springframework.core.annotation.Order;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Order(1)
//public class TraceLoggingFilter implements Filter {
//    private final Tracer tracer;
//
//    public static final String TRACE_ID = "traceId";
//    public static final String SPAN_ID = "spanId";
//
//    public TraceLoggingFilter(Tracer tracer) {
//        this.tracer = tracer;
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.debug("Initializing TraceLoggingFilter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        Span currentSpan = tracer.currentSpan();
//
//        //add traceId & spanId to MDC
//        if (currentSpan != null) {
//            String spanId = currentSpan.context().spanId();
//            String traceId = currentSpan.context().traceId();
//            MDC.put(TRACE_ID, traceId);
//            MDC.put(SPAN_ID, spanId);
//
//            //add traceId in response header
//            HttpServletResponse resp = (HttpServletResponse) servletRequest;
//            resp.addHeader(TRACE_ID, traceId);
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//
//        //remove traceId & spanId from MDC
//        if (currentSpan != null) {
//            MDC.remove(TRACE_ID);
//            MDC.remove(SPAN_ID);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        log.debug("Destroying TraceLoggingFilter");
//    }
//}
