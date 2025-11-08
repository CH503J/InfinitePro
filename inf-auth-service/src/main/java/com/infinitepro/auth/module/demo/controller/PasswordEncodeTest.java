package com.infinitepro.auth.module.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 获取明文密码密文信息
 */
public class PasswordEncodeTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
