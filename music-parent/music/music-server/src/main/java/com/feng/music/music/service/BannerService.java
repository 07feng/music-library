/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: BannerService
 * Author:   Lynn
 * Date:     2024/6/29 15:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.service;

import com.feng.music.music.dto.banner.BannerResp;
import com.feng.music.music.po.Banner;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
public interface BannerService extends BaseService<Banner> {

    /**
     * 获取所有横幅
     *
     * @return
     */
    List<BannerResp> getAllBanner();
}

