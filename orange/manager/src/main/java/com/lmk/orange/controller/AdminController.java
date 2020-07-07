package com.lmk.orange.controller;

import com.lmk.orange.entity.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ConcurrentMap;

@Api("登陆相关接口")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @ApiOperation("后台登陆")
    @PostMapping("/manage/login")
    public String manageLogin(@RequestBody String loginVo)
    {
        return "hello world";
    }
}
