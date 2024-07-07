/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: SingerResp
 * Author:   Lynn
 * Date:     2024/6/29 18:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.dto.singer;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
@Getter
@Setter
public class SingerResp implements Serializable {

    @Serial
    private static final long serialVersionUID = -4550082875577046624L;

    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 照片
     */
    private String pic;
}

