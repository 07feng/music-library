/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: BannerController
 * Author:   Lynn
 * Date:     2024/6/29 18:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.server.controller;

import com.feng.music.dto.Response;
import com.feng.music.music.server.dto.banner.BannerResp;
import com.feng.music.music.server.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/list/all")
    public Response<List<BannerResp>> getAllBanner() {
        return Response.success(bannerService.getAllBanner());
    }
}

