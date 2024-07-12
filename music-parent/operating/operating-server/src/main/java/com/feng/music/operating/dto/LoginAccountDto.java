package com.feng.music.operating.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 版权：深圳航天信息有限公司
 *
 * @author linqf
 * @description
 * @date 2024-07-11
 */
@Getter
@Setter
public class LoginAccountDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -1922474418073200657L;

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空")
    private String userName;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
