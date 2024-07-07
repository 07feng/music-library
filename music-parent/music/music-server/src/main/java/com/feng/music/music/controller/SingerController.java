/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: SingerController
 * Author:   Lynn
 * Date:     2024/6/29 18:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.controller;

import com.feng.music.dto.Response;
import com.feng.music.music.dto.singer.SingerResp;
import com.feng.music.music.service.SingerService;
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
@RequestMapping("singer")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @GetMapping("/list/all")
    public Response<List<SingerResp>> getAllSinger() {
        return Response.success(singerService.getAllSinger());
    }
}

