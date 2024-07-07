/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: SongServiceImpl
 * Author:   Lynn
 * Date:     2024/6/29 18:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.music.music.dto.song.SongResp;
import com.feng.music.music.mapper.SongMapper;
import com.feng.music.music.po.Song;
import com.feng.music.music.service.SongService;
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
public class SongServiceImpl extends BaseServiceImpl<Song, Long, SongMapper> implements SongService {

    @Override
    public List<SongResp> getAllSong() {
        List<Song> songList = selectList(new QueryWrapper<>());
        return songList.stream().map(Song::convertToSongResp).collect(Collectors.toList());
    }
}

