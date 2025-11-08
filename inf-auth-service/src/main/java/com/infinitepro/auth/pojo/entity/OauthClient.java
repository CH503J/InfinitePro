package com.infinitepro.auth.entity;

import com.infinitepro.common.base.BaseIdEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * OAuth 客户端实体类
 * 主键 id 使用雪花算法生成
 */
@Data
@TableName("oauth_client")
public class OauthClient extends BaseIdEntity {

    /**
     * 客户端 id
     */
    @TableField("client_id")
    private String clientId; // 原来的业务主键字段

    /**
     * 客户端密码
     */
    @TableField("client_secret")
    private String clientSecret;

    /**
     * 重定向 URI
     */
    @TableField("redirect_uri")
    private String redirectUri;

    /**
     * 授权范围
     */
    @TableField("scopes")
    private String scopes;

    /**
     * 授权类型
     */
    @TableField("grant_types")
    private String grantTypes;

    /**
     * 访问令牌有效期
     */
    @TableField("access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效期
     */
    @TableField("refresh_token_validity")
    private Integer refreshTokenValidity;
}
