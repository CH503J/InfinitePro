package com.infinitepro.common.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    OK(200, "请求成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未认证"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_ERROR(500, "服务器异常");

    private final int status;
    private final String message;

    StatusEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
