package com.example.demo.controller;

import com.example.demo.redis.RedisService;
import com.example.demo.vo.UserInDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class UserController {
    @Autowired
    RedisService redisService;

    @GetMapping("/test")
    public String status(){
        log.info("log체크");
        return "test Success";
    }

    @PostMapping("/save")
    public String save(@RequestBody UserInDto user){
        log.info("name 변수체크 {}",user.getName());
        redisService.setKey("name",user.getName());
        return "Success save"+user.getName();
    }

    @GetMapping("/check")
    public String check(){
        log.info("name 변수체크 {}" , redisService.getKey("name"));
        return redisService.getKey("name");
    }
}
