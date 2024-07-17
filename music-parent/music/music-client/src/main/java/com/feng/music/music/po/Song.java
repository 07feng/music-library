/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: Song
 * Author:   Lynn
 * Date:     2024/6/29 15:24
 * Description: 歌曲
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.feng.music.common.po.BasePo;
import com.feng.music.music.dto.song.SongResp;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈歌曲〉
 *
 * @author Lynn
 * @create 2024/6/29
 * @since 1.0.0
 */
@Getter
@Setter
@TableName("song")
public class Song extends BasePo {

    @Serial
    private static final long serialVersionUID = 5489863641968104970L;

    /**
     * 歌手ID
     */
    private String singerId;
    /**
     * 名称
     */
    private String name;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 发行时间
     */
    private LocalDateTime issueTime;
    /**
     * 照片
     */
    private String pic;
    /**
     * 歌词
     */
    private String lyric;
    /**
     * 歌曲源文件路径
     */
    private String url;

    public static SongResp convertToSongResp(Song song) {
        SongResp songResp = new SongResp();
        songResp.setId(song.getId());
        songResp.setName(song.getName());
        songResp.setPic(song.getPic());
        return songResp;
    }
}

