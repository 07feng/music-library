package com.feng.music.operating.service.impl;

import com.feng.music.common.service.impl.BaseServiceImpl;
import com.feng.music.operating.mapper.AccountMapper;
import com.feng.music.operating.po.Account;
import com.feng.music.operating.service.AccountService;
import org.springframework.stereotype.Service;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-10
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Long, AccountMapper> implements AccountService {
}
