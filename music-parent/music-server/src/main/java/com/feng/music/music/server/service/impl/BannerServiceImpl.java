/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: BannerServiceImpl
 * Author:   Lynn
 * Date:     2024/6/29 15:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.feng.music.music.server.dto.banner.BannerResp;
import com.feng.music.music.server.mapper.BannerMapper;
import com.feng.music.music.server.po.Banner;
import com.feng.music.music.server.service.BannerService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
@Service
public class BannerServiceImpl extends BaseServiceImpl<Banner, Long, BannerMapper> implements BannerService {

    @Override
    public List<BannerResp> getAllBanner() {
        List<Banner> bannerList = selectList(new LambdaQueryWrapper<>());
        return bannerList.stream().map(Banner::convertToBannerResp).collect(Collectors.toList());
    }
}

