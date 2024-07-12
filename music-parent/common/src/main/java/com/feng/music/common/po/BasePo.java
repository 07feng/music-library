/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: BasePo
 * Author:   Lynn
 * Date:     2024/6/29 15:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.common.po;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 * @since 1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
public class BasePo extends BaseIdPo {

    @Serial
    private static final long serialVersionUID = -1735620185593787026L;

    /**
     * 创建人
     */
    private Long creator;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新人
     */
    private Long updater;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}

