/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: Singer
 * Author:   Lynn
 * Date:     2024/6/29 15:17
 * Description: 歌手
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.feng.music.music.dto.singer.SingerResp;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br>
 * 〈歌手〉
 *
 * @author Lynn
 * @create 2024/6/29
 * @since 1.0.0
 */
@Getter
@Setter
@TableName("singer")
public class Singer extends BasePo {

    @Serial
    private static final long serialVersionUID = 912126307923132462L;

    /**
     * 歌手名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 照片
     */
    private String pic;
    /**
     * 出生年月
     */
    private LocalDateTime birth;
    /**
     * 籍贯
     */
    private String location;
    /**
     * 介绍
     */
    private String introduction;

    public static SingerResp convertToSingerResp(Singer singer) {
        SingerResp singerResp = new SingerResp();
        singerResp.setId(singer.getId());
        singerResp.setName(singer.getName());
        singerResp.setPic(singer.getPic());
        return singerResp;
    }
}

