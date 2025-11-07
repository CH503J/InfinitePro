package com.infinitepro.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 全局 Jackson 配置
 */
@Configuration
public class JacksonConfig {

    // 全局时间格式
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final LocalDateTimeSerializer LOCAL_DATE_TIME_SERIALIZER =
            new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    public static final LocalDateTimeDeserializer LOCAL_DATE_TIME_DESERIALIZER =
            new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // 注册 JavaTimeModule，用于支持 java.time.* API
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, LOCAL_DATE_TIME_SERIALIZER);
        javaTimeModule.addDeserializer(LocalDateTime.class, LOCAL_DATE_TIME_DESERIALIZER);

        objectMapper.registerModule(javaTimeModule);

        // 避免序列化为时间戳
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }
}
