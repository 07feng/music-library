package com.feng.music.operating.rpc;

import com.feng.music.basic.dto.user.UserQueryReq;
import com.feng.music.basic.dto.user.UserResp;
import com.feng.music.common.dto.Response;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linqf
 * @description
 * @date 2024-07-19
 */
@FeignClient(name = "basic-server")
public interface UserFeignService {

    @PostMapping("/basic/user/page")
    Response<PageInfo<UserResp>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "20") Integer pageSize,
                                      @RequestBody UserQueryReq queryReq);

    @DeleteMapping("/basic/user/delete/{id}")
    Response<Void> deleteById(@PathVariable Long id);

    @DeleteMapping("/basic/user/delete/batch")
    Response<Void> batchDelete(@RequestBody List<Long> idList);
}
