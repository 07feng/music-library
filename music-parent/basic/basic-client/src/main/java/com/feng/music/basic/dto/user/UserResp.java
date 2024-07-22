package com.feng.music.basic.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserResp implements Serializable {

    @Serial
    private static final long serialVersionUID = -5449668917695411651L;

    private Long id;

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户性别
     */
    private Integer sex;
    /**
     * 用户手机号
     */
    private String phoneNum;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 出生年月
     */
    private LocalDateTime birth;
    /**
     * 个人简介
     */
    private String introduction;
    /**
     * 地区
     */
    private String location;
}
