-- ==================================用户表==================================
CREATE TABLE `user`
(
    `id`          VARCHAR(50) PRIMARY KEY COMMENT '唯一ID（雪花算法生成）',
    `user_id`     VARCHAR(50)  NOT NULL UNIQUE COMMENT '用户ID（业务主键）',
    `username`    VARCHAR(50)  NOT NULL UNIQUE COMMENT '用户名',
    `password`    VARCHAR(255) NOT NULL COMMENT '密码',
    `email`       VARCHAR(100) NOT NULL UNIQUE COMMENT '邮箱',
    `phone`       VARCHAR(20) DEFAULT NULL UNIQUE COMMENT '手机号',
    `create_time` DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_by`   VARCHAR(50) COMMENT '创建人ID',
    `update_by`   VARCHAR(50) COMMENT '更新人ID',
    `is_delete`   TINYINT(1)  DEFAULT FALSE COMMENT '逻辑删除（1：已删除；0：未删除）'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='系统用户表';


INSERT INTO `user` (`id`,
                    `user_id`,
                    `username`,
                    `password`,
                    `email`,
                    `phone`,
                    `create_time`,
                    `update_time`,
                    `create_by`,
                    `update_by`,
                    `is_delete`)
VALUES ('1',
        'U0001',
        'admin',
        '$2a$10$T1a9GAsLZs/ZTl5LHDBKR.QW9877jq9hZ2zndktA62FWreb6jvZNa', -- 密码：123456 的 BCrypt 加密值
        'admin@example.com',
        '13800000000',
        NOW(),
        NOW(),
        'system',
        'system',
        0);


-- ==================================OAuth客户端表==================================
CREATE TABLE `oauth_client`
(
    `id`                     VARCHAR(50) PRIMARY KEY COMMENT '唯一ID（雪花算法生成）',
    `client_id`              VARCHAR(50)  NOT NULL UNIQUE COMMENT '客户端ID（业务主键）',
    `client_secret`          VARCHAR(255) NOT NULL COMMENT '客户端密钥',
    `redirect_uri`           VARCHAR(255) NOT NULL COMMENT '回调地址',
    `scopes`                 VARCHAR(255) NOT NULL COMMENT '授权范围',
    `grant_types`            VARCHAR(255) NOT NULL COMMENT '授权类型',
    `access_token_validity`  INT        DEFAULT 3600 COMMENT 'Access Token 有效期（秒）',
    `refresh_token_validity` INT        DEFAULT 604800 COMMENT 'Refresh Token 有效期（秒）',
    `create_time`            DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`            DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_by`              VARCHAR(50) COMMENT '创建人ID',
    `update_by`              VARCHAR(50) COMMENT '更新人ID',
    `is_delete`              TINYINT(1) DEFAULT FALSE COMMENT '逻辑删除（1：已删除；0：未删除）'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='OAuth客户端表';

-- ==================================OAuth Access Token 表==================================
CREATE TABLE `oauth_access_token`
(
    `id`                VARCHAR(50) PRIMARY KEY COMMENT '唯一ID（雪花算法生成）',
    `token_id`          VARCHAR(255) NOT NULL UNIQUE COMMENT 'Token ID（业务主键）',
    `token`             TEXT         NOT NULL COMMENT 'Access Token',
    `authentication_id` VARCHAR(255) COMMENT '认证ID',
    `user_name`         VARCHAR(50) COMMENT '用户名',
    `client_id`         VARCHAR(50) COMMENT '客户端ID',
    `expiration`        DATETIME COMMENT '过期时间',
    `create_time`       DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`       DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_by`         VARCHAR(50) COMMENT '创建人ID',
    `update_by`         VARCHAR(50) COMMENT '更新人ID',
    `is_delete`         TINYINT(1) DEFAULT FALSE COMMENT '逻辑删除（1：已删除；0：未删除）'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='OAuth Token 表';
