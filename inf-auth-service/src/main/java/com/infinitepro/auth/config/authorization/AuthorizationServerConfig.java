package com.infinitepro.auth.config.authorization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.UUID;

@Configuration
public class AuthorizationServerConfig {

    @Bean
    public RegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder) {

        // TODO 后续改为从数据库或配置中心动态读取客户端配置
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                // TODO 改为正式的客户端ID（当前为演示用）
                .clientId("infinitepro-client")

                // TODO 改为安全存储的clientSecret（当前为明文演示用）
                .clientSecret(passwordEncoder.encode("123456")) // raw password: 123456

                // 客户端认证方式：HTTP Basic认证
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)

                // 授权码模式 + 刷新token
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)

                // TODO 修改为前端项目的实际回调地址
                .redirectUri("http://localhost:29999/callback")

                // TODO 后续可以按不同业务模块拆分权限范围
                .scope("read")
                .scope("write")

                // 客户端设置
                .clientSettings(ClientSettings.builder()
                        // TODO 如果是内部应用，可设为 false 以跳过授权确认页
                        .requireAuthorizationConsent(true)
                        .build())

                // Token设置（有效期等）
                .tokenSettings(TokenSettings.builder()
                        // TODO 根据安全要求调整token有效期
                        .accessTokenTimeToLive(Duration.ofHours(1))
                        .refreshTokenTimeToLive(Duration.ofDays(30))
                        .build())
                .build();

        // TODO 若项目使用数据库持久化客户端信息，可替换为JdbcRegisteredClientRepository
        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        // TODO 修改issuer为线上部署地址，如 https://auth.infinitepro.com
        return AuthorizationServerSettings.builder()
                .issuer("http://localhost:21010")
                .build();
    }
}
