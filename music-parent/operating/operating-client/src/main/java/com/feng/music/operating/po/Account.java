package com.feng.music.operating.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.feng.music.common.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("account")
public class Account extends BasePo {
    @Serial
    private static final long serialVersionUID = 5416532551712644085L;

    /**
     * 账户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 是否启用
     */
    private Boolean enabled;
}
