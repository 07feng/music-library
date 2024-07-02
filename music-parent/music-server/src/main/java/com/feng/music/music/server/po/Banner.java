/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: Banner
 * Author:   Lynn
 * Date:     2024/6/29 14:04
 * Description: 横幅
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.server.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.feng.music.music.server.dto.banner.BannerResp;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈横幅〉
 *
 * @author Lynn
 * @create 2024/6/29
 * @since 1.0.0
 */
@Getter
@Setter
@TableName("banner")
public class Banner extends BasePo {

    @Serial
    private static final long serialVersionUID = -8781404746414109754L;

    /**
     * 图片路径
     */
    private String pic;

    public static BannerResp convertToBannerResp(Banner banner) {
        BannerResp bannerResp = new BannerResp();
        bannerResp.setId(banner.getId());
        bannerResp.setPic(banner.getPic());
        return bannerResp;
    }
}

