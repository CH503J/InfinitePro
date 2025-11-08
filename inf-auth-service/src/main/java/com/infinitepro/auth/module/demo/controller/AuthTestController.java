package com.infinitepro.auth.module.demo.controller;

import com.infinitepro.common.base.ApiResult;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthTestController {

    private final AuthenticationManager authenticationManager;

    public AuthTestController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login-test")
    public ApiResult<String> loginTest(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            return ApiResult.success("认证成功");
        } catch (Exception e) {
            return ApiResult.fail("认证失败" + e.getMessage());
        }
    }
}
