package com.feng.music.common.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

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
public class BaseIdPo implements Serializable {

    @Serial
    private static final long serialVersionUID = -743942579543835869L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
}
