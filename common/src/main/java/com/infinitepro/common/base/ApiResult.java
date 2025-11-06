package com.infinitepro.common.base;

import com.infinitepro.common.enums.CodeEnum;
import com.infinitepro.common.enums.StatusEnum;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 全局统一返回类
 *
 * @param <T> 返回的数据类型
 */
@Data
public class ApiResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /** 业务状态码 */
    private int code;

    /** HTTP状态码 */
    private int status;

    /** 返回信息 */
    private String msg;

    /** 返回数据 */
    private T data;

    // ==================== 构造方法 ====================
    public ApiResult() {}

    public ApiResult(int code, int status, String msg, T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // ==================== 静态快捷方法 ====================

    /** 成功返回，带数据 */
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(CodeEnum.SUCCESS.getCode(), StatusEnum.OK.getStatus(), StatusEnum.OK.getMessage(), data);
    }

    /** 成功返回，不带数据 */
    public static <T> ApiResult<T> success() {
        return new ApiResult<>(CodeEnum.SUCCESS.getCode(), StatusEnum.OK.getStatus(), StatusEnum.OK.getMessage(), null);
    }

    /** 失败返回，带自定义消息 */
    public static <T> ApiResult<T> fail(String msg) {
        return new ApiResult<>(CodeEnum.FAIL.getCode(), StatusEnum.INTERNAL_ERROR.getStatus(), msg, null);
    }

    /** 失败返回，带自定义业务码和HTTP状态码 */
    public static <T> ApiResult<T> fail(int code, int status, String msg) {
        return new ApiResult<>(code, status, msg, null);
    }

    // ==================== 链式调用方法 ====================
    public ApiResult<T> code(int code) {
        this.code = code;
        return this;
    }

    public ApiResult<T> status(int status) {
        this.status = status;
        return this;
    }

    /** 普通字符串返回 */
    public ApiResult<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    /** 支持占位符 {} 替换 */
    public ApiResult<T> msg(String msg, Object... args) {
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                msg = msg.replaceFirst("\\{\\}", arg == null ? "null" : arg.toString());
            }
        }
        this.msg = msg;
        return this;
    }

    public ApiResult<T> data(T data) {
        this.data = data;
        return this;
    }
}
