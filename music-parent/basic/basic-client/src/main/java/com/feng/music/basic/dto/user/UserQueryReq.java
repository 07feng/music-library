package com.feng.music.basic.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserQueryReq implements Serializable {
    @Serial
    private static final long serialVersionUID = -6217468331256040528L;

    /**
     * 查询字段（模糊匹配）
     */
    private String searchKey;
}
