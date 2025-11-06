package com.infinitepro.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "cors")
public class GatewayCorsConfig {

    /**
     * 允许跨域访问的域名列表
     */
    private List<String> allowedOrigins = new ArrayList<>();

    /**
     * 允许的HTTP方法
     */
    private List<String> allowedMethods = new ArrayList<>();

    /**
     * 允许的请求头
     */
    private List<String> allowedHeaders = new ArrayList<>();

    /**
     * 是否允许携带 Cookie
     */
    private boolean allowedCredentials = true;

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // 动态添加前端允许的域名
        allowedOrigins.forEach(config::addAllowedOrigin);

        // 动态添加允许的请求方法
        allowedMethods.forEach(config::addAllowedMethod);

        // 动态添加允许的请求头
        allowedHeaders.forEach(config::addAllowedHeader);

        config.setAllowCredentials(allowedCredentials);

        // 对所有路径生效
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
