package com.feng.music.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.music.basic.dto.user.UserQueryReq;
import com.feng.music.basic.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户列表
     *
     * @param queryReq
     * @return
     */
    List<User> selectUserList(@Param("queryReq") UserQueryReq queryReq);
}
