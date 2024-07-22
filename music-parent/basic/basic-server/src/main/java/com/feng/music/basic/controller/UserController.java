package com.feng.music.basic.controller;

import com.feng.music.basic.dto.user.UserQueryReq;
import com.feng.music.basic.dto.user.UserResp;
import com.feng.music.basic.service.UserService;
import com.feng.music.common.dto.Response;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/page")
    public Response<PageInfo<UserResp>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "20") Integer pageSize,
                                             @RequestBody UserQueryReq userQueryReq) {
        return Response.success(userService.page(pageNum, pageSize, userQueryReq));
    }

    @DeleteMapping("/delete/{id}")
    public Response<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return Response.success();
    }

    @DeleteMapping("/delete/batch")
    public Response<Void> batchDelete(@RequestBody List<Long> idList) {
        userService.deleteByIds(idList);
        return Response.success();
    }
}
