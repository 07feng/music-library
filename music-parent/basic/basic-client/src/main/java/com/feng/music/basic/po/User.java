package com.feng.music.basic.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.feng.music.common.po.BaseIdPo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user")
public class User extends BaseIdPo implements Serializable {
    @Serial
    private static final long serialVersionUID = 3032176208489710299L;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String phoneNum;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 出生年月
     */
    private LocalDateTime birth;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 个人简介
     */
    private String introduction;
    /**
     * 地址
     */
    private String location;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
