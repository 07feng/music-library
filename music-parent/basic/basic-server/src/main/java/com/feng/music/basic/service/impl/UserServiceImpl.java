package com.feng.music.basic.service.impl;

import com.feng.music.basic.dto.user.UserQueryReq;
import com.feng.music.basic.dto.user.UserResp;
import com.feng.music.basic.mapper.UserMapper;
import com.feng.music.basic.po.User;
import com.feng.music.basic.service.UserService;
import com.feng.music.common.service.impl.AbstractBaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@Service
public class UserServiceImpl extends AbstractBaseService<User, Long, UserMapper> implements UserService {
    @Override
    public PageInfo<UserResp> page(Integer pageNum, Integer pageSize, UserQueryReq queryReq) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = this.getMapper().selectUserList(queryReq);
        List<UserResp> userRespList = userList.stream().map(this::convertToUserResp).collect(Collectors.toList());
        return new PageInfo<>(userRespList);
    }

    private UserResp convertToUserResp(User user) {
        return new UserResp()
                .setAvatar(user.getAvatar())
                .setBirth(user.getBirth())
                .setEmail(user.getEmail())
                .setId(user.getId())
                .setIntroduction(user.getIntroduction())
                .setLocation(user.getLocation())
                .setPhoneNum(user.getPhoneNum())
                .setSex(user.getSex())
                .setUserName(user.getUserName());
    }
}
