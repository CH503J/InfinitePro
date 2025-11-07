package com.infinitepro.auth.module.demo.controller;

import com.infinitepro.common.base.ApiResult;
import com.infinitepro.common.enums.CodeEnum;
import com.infinitepro.common.enums.StatusEnum;
import com.infinitepro.common.exception.GlobalException;
import com.infinitepro.common.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired(required = false)
    private GlobalExceptionHandler globalExceptionHandler;

    /**
     * 普通返回样例
     *
     * @return ApiResult
     */
    @GetMapping("/hello")
    public ApiResult<String> hello() {
        String hello = "hello world";
        log.info("该节点返回字符串 {}", hello);
        return ApiResult.<String>success()
                .code(CodeEnum.SUCCESS.getCode())
                .status(StatusEnum.OK.getStatus())
                .msg("测试接口调用成功，返回调用结果 {}", hello)
                .data(hello);
    }

    @GetMapping("/hello1")
    public ApiResult<String> hello(@RequestParam("code") Integer code) {

        if (code == 1) {
            String hello = "hello world";
            log.info("该节点返回字符串 {}", hello);
            return ApiResult.<String>success()
                    .code(CodeEnum.SUCCESS.getCode())
                    .status(StatusEnum.OK.getStatus())
                    .msg("测试接口调用成功，返回调用结果 {}", hello)
                    .data(hello);
        } else {
            throw new GlobalException(CodeEnum.SYSTEM_ERROR);
        }

    }
}
