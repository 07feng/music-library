package com.feng.music.basic.service;

import com.feng.music.basic.dto.user.UserQueryReq;
import com.feng.music.basic.dto.user.UserResp;
import com.feng.music.basic.po.User;
import com.feng.music.common.service.BaseService;
import com.github.pagehelper.PageInfo;

/**
 * @author linqf
 * @description
 * @date 2024-07-19
 */
public interface UserService extends BaseService<User> {

    /**
     * 分页查询用户列表
     *
     * @param pageNum
     * @param pageSize
     * @param queryReq 分页查询入参
     * @return
     */
    PageInfo<UserResp> page(Integer pageNum, Integer pageSize, UserQueryReq queryReq);
}
