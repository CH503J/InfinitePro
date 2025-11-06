package com.infinitepro.common.exception;

import com.infinitepro.common.base.ApiResult;
import com.infinitepro.common.enums.CodeEnum;
import com.infinitepro.common.enums.StatusEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice(basePackages = "com.infinitepro")
public class GlobalExceptionHandler {

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(GlobalException.class)
    public ApiResult<?> handleGlobalException(GlobalException e) {
        return ApiResult.fail(
                e.getCode(),
                e.getStatus(),
                e.getMessage()
        );
    }

    /**
     * 处理所有未捕获的异常（兜底）
     */
    @ExceptionHandler(Exception.class)
    public ApiResult<?> handleException(Exception e) {
        e.printStackTrace(); // 调试阶段打印堆栈
        return ApiResult.fail(
                CodeEnum.FAIL.getCode(),
                StatusEnum.INTERNAL_ERROR.getStatus(),
                "服务器内部错误：" + e.getMessage()
        );
    }
}
