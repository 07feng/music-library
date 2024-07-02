package com.feng.music.music.server.service;

import com.feng.music.music.server.dto.song.SongResp;
import com.feng.music.music.server.po.Song;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
public interface SongService extends BaseService<Song> {

    List<SongResp> getAllSong();
}
