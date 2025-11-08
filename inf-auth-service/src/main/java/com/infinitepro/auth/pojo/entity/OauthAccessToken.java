package com.infinitepro.auth.pojo.entity;

import com.infinitepro.common.base.BaseIdEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * OAuth Access Token 实体类
 * 主键 id 使用雪花算法生成
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("oauth_access_token")
public class OauthAccessToken extends BaseIdEntity {

    /**
     * token id
     */
    @TableField("token_id")
    private String tokenId;

    /**
     * token
     */
    @TableField("token")
    private String token;

    /**
     * 认证信息 id
     */
    @TableField("authentication_id")
    private String authenticationId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String username;

    /**
     * 客户端 id
     */
    @TableField("client_id")
    private String clientId;

    /**
     * 过期时间
     */
    @TableField("expiration")
    private LocalDateTime expiration;
}
