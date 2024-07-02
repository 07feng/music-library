package com.feng.music.music.server.service;

import com.feng.music.music.server.dto.singer.SingerResp;
import com.feng.music.music.server.po.Singer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
@Service
public interface SingerService extends BaseService<Singer> {

    /**
     * 获取所有歌手列表
     *
     * @return
     */
    List<SingerResp> getAllSinger();
}
