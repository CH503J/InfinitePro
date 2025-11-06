package com.infinitepro.common.enums;

import lombok.Getter;

@Getter
public enum CodeEnum {

    SUCCESS(0, "操作成功"),
    FAIL(-1, "操作失败"),
    USER_NOT_FOUND(10001, "用户不存在"),
    PASSWORD_ERROR(10002, "密码错误"),
    SYSTEM_ERROR(50001, "系统异常");

    private final int code;
    private final String message;

    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
