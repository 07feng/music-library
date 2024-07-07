/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: BannerResp
 * Author:   Lynn
 * Date:     2024/6/29 15:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.dto.banner;

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
public class BannerResp implements Serializable {

    @Serial
    private static final long serialVersionUID = -4005836233064828543L;

    private Long id;
    /**
     * 图片
     */
    private String pic;
}

