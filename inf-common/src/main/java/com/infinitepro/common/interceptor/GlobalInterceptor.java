package com.infinitepro.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 全局拦截器示例
 * - 记录请求信息
 * - 可扩展权限校验、token 校验等
 */
@Slf4j
@Component
public class GlobalInterceptor implements HandlerInterceptor {

    /**
     * 请求处理前拦截
     *
     * @return true: 继续处理请求, false: 中断请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String clientIp = request.getRemoteAddr();

        log.info("请求开始 - 方法: {}, URI: {}, 参数: {}, 客户端IP: {}", method, uri, queryString, clientIp);

        // TODO: 权限校验、Token校验等逻辑
        // if (!validToken(request)) {
        //     response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //     return false;
        // }

        return true;
    }

    /**
     * 请求处理完成后拦截
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        int status = response.getStatus();
        log.info("请求结束 - URI: {}, 状态码: {}", request.getRequestURI(), status);
        if (ex != null) {
            log.error("请求处理异常", ex);
        }
    }
}
