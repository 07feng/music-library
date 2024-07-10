/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: SingerServiceImpl
 * Author:   Lynn
 * Date:     2024/6/29 18:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.service.impl;

import com.feng.music.common.service.impl.BaseServiceImpl;
import com.feng.music.music.dto.singer.SingerResp;
import com.feng.music.music.mapper.SingerMapper;
import com.feng.music.music.po.Singer;
import com.feng.music.music.service.SingerService;
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
public class SingerServiceImpl extends BaseServiceImpl<Singer, Long, SingerMapper> implements SingerService {

    @Override
    public List<SingerResp> getAllSinger() {
        List<Singer> singerList = selectAll();
        return singerList.stream().map(Singer::convertToSingerResp).collect(Collectors.toList());
    }
}

