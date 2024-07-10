package com.feng.music.music.service;

import com.feng.music.common.service.BaseService;
import com.feng.music.music.dto.song.SongResp;
import com.feng.music.music.po.Song;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
public interface SongService extends BaseService<Song> {

    /**
     * 获取所有歌曲
     *
     * @return
     */
    List<SongResp> getAllSong();
}
