/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: SongController
 * Author:   Lynn
 * Date:     2024/6/29 19:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.controller;

import com.feng.music.common.dto.Response;
import com.feng.music.music.dto.song.SongResp;
import com.feng.music.music.service.SongService;
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
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/list/all")
    public Response<List<SongResp>> getAllSong() {
        return Response.success(songService.getAllSong());
    }
}

