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
package com.feng.music.music.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

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
public class BasePo implements Serializable {

    @Serial
    private static final long serialVersionUID = -1735620185593787026L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
}

