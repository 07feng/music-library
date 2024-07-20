CREATE TABLE IF NOT EXISTS `user`
(
    `id`           bigint       NOT NULL,
    `user_name`    varchar(64)  NOT NULL COMMENT '用户名',
    `password`     varchar(128) NOT NULL COMMENT '密码',
    `sex`          tinyint(1)   DEFAULT NULL COMMENT '性别',
    `phone_num`    varchar(11)  DEFAULT NULL COMMENT '手机号',
    `email`        varchar(32)  DEFAULT NULL COMMENT '邮箱',
    `birth`        datetime     DEFAULT NULL COMMENT '生日',
    `introduction` varchar(256) DEFAULT NULL COMMENT '简介',
    `location`     varchar(64)  DEFAULT NULL COMMENT '位置',
    `avatar`       varchar(256) DEFAULT NULL COMMENT '头像',
    `create_time`  datetime     NOT NULL COMMENT '创建时间',
    `update_time`  datetime     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_name` (`user_name`),
    UNIQUE KEY `uk_phoneNum` (`phone_num`),
    UNIQUE KEY `uk_email` (`email`)
) ENGINE = InnoDB;