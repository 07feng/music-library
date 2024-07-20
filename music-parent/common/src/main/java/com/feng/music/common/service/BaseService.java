package com.feng.music.common.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.music.common.po.BaseIdPo;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
public interface BaseService<T extends BaseIdPo> extends BaseMapper<T> {

    /**
     * 查询单个
     *
     * @param entity
     * @return
     */
    T selectOne(T entity) ;

    /**
     * 查询全部
     *
     * @return
     */
    List<T> selectAll();
}
