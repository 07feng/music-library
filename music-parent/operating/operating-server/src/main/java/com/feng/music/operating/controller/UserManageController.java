package com.feng.music.operating.controller;

import com.feng.music.basic.dto.user.UserQueryReq;
import com.feng.music.basic.dto.user.UserResp;
import com.feng.music.common.dto.Response;
import com.feng.music.operating.rpc.UserFeignService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@RestController
@RequestMapping("/user_manage")
public class UserManageController {

    @Autowired
    private UserFeignService userFeignService;

    @PostMapping("/page")
    public Response<PageInfo<UserResp>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "20") Integer pageSize,
                                             @RequestBody UserQueryReq queryReq) {
        return userFeignService.page(pageNum, pageSize, queryReq);
    }
}
