package com.feng.music.operating.controller;

import com.feng.music.common.dto.Response;
import com.feng.music.common.exception.BusinessException;
import com.feng.music.operating.dto.LoginAccountDto;
import com.feng.music.operating.po.Account;
import com.feng.music.operating.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author linqf
 * @description
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public Response<String> login(@RequestBody @Valid LoginAccountDto loginAccountDto) {
        String userName = loginAccountDto.getUserName();
        Account account = accountService.selectOne(new Account().setUserName(userName));
        if (account == null) {
            throw BusinessException.of("用户不存在！");
        }
        if (!Objects.equals(account.getPassword(), loginAccountDto.getPassword())) {
            throw BusinessException.of("密码错误！");
        }
        return Response.success();
    }
}
