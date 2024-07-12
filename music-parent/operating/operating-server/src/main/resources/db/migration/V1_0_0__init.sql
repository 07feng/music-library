CREATE TABLE IF NOT EXISTS `account`
(
    `id`          bigint      NOT NULL,
    `user_name`   varchar(16) NOT NULL COMMENT '用户名',
    `password`    varchar(32) NOT NULL COMMENT '密码',
    `creator`     bigint COMMENT '创建人',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`     bigint COMMENT '更新人',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `enabled`     tinyint(1)  NOT NULL DEFAULT 1 COMMENT '是否启用',
    PRIMARY KEY (`id`),
    index `idx_user_name` (`user_name`)
) ENGINE = InnoDB;