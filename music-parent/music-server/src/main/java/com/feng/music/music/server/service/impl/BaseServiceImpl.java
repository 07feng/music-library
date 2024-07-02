/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: BaseServiceImpl
 * Author:   Lynn
 * Date:     2024/6/29 15:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feng.music.builder.QueryWrapperBuilder;
import com.feng.music.music.server.po.BasePo;
import com.feng.music.music.server.service.BaseService;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
public class BaseServiceImpl<T extends BasePo, ID extends Serializable, M extends BaseMapper<T>> implements BaseService<T> {

    @Autowired
    private M mapper;

    @Override
    public T selectOne(T entity) throws IllegalAccessException {
        QueryWrapperBuilder<T> queryWrapperBuilder = new QueryWrapperBuilder<>();
        QueryWrapper<T> queryWrapper = queryWrapperBuilder.build(entity);
        return mapper.selectOne(queryWrapper, true);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectList(new QueryWrapper<>());
    }

    @Override
    public int insert(T entity) {
        return mapper.insert(entity);
    }

    @Override
    public int deleteById(T entity) {
        return mapper.deleteById(entity);
    }

    @Override
    public int delete(Wrapper<T> queryWrapper) {
        return mapper.delete(queryWrapper);
    }

    @Override
    public int updateById(T entity) {
        return mapper.updateById(entity);
    }

    @Override
    public int update(T entity, Wrapper<T> updateWrapper) {
        return mapper.update(entity, updateWrapper);
    }

    @Override
    public T selectById(Serializable id) {
        return mapper.selectById(id);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return mapper.selectBatchIds(idList);
    }

    @Override
    public void selectBatchIds(Collection<? extends Serializable> idList, ResultHandler<T> resultHandler) {
        mapper.selectBatchIds(idList, resultHandler);
    }

    @Override
    public Long selectCount(Wrapper<T> queryWrapper) {
        return mapper.selectCount(queryWrapper);
    }

    @Override
    public List<T> selectList(Wrapper<T> queryWrapper) {
        return mapper.selectList(queryWrapper);
    }

    @Override
    public void selectList(Wrapper<T> queryWrapper, ResultHandler<T> resultHandler) {
        mapper.selectList(queryWrapper, resultHandler);
    }

    @Override
    public List<T> selectList(IPage<T> page, Wrapper<T> queryWrapper) {
        return mapper.selectList(page, queryWrapper);
    }

    @Override
    public void selectList(IPage<T> page, Wrapper<T> queryWrapper, ResultHandler<T> resultHandler) {
        mapper.selectList(queryWrapper, resultHandler);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<T> queryWrapper) {
        return mapper.selectMaps(queryWrapper);
    }

    @Override
    public void selectMaps(Wrapper<T> queryWrapper, ResultHandler<Map<String, Object>> resultHandler) {
        mapper.selectMaps(queryWrapper, resultHandler);
    }

    @Override
    public List<Map<String, Object>> selectMaps(IPage<? extends Map<String, Object>> page, Wrapper<T> queryWrapper) {
        return mapper.selectMaps(page, queryWrapper);
    }

    @Override
    public void selectMaps(IPage<? extends Map<String, Object>> page, Wrapper<T> queryWrapper, ResultHandler<Map<String, Object>> resultHandler) {
        mapper.selectMaps(page, queryWrapper, resultHandler);
    }

    @Override
    public <E> List<E> selectObjs(Wrapper<T> queryWrapper) {
        return mapper.selectObjs(queryWrapper);
    }

    @Override
    public <E> void selectObjs(Wrapper<T> queryWrapper, ResultHandler<E> resultHandler) {
        mapper.selectObjs(queryWrapper, resultHandler);
    }
}

