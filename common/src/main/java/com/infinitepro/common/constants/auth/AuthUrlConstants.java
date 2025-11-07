package com.infinitepro.common.constants.auth;

import java.util.Set;
import java.util.HashSet;

public class AuthUrlConstants {
    // 不需要拦截的白名单 URL
    public static final Set<String> WHITE_LIST = new HashSet<>() {{
        add("/auth/login");
        add("/auth/register");
        add("/health");
    }};
}
