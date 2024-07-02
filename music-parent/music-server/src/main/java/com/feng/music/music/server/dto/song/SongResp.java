/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: SongResp
 * Author:   Lynn
 * Date:     2024/6/29 18:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.server.dto.song;

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
public class SongResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1231713968231860665L;

    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String pic;
}

