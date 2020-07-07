package com.lmk.seckill.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "秒杀")
@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @ApiOperation(value="秒杀一(最low实现)",nickname="科帮网")
    @PostMapping("/start")
    public String start(long seckillId){
        return "hi";
    }
}
