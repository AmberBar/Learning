package com.amber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Amber
 */
@RestController
@RequestMapping("/redis")
public class MessageController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/{channel}")
    public void sendMessage(@PathVariable String channel , @RequestParam String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
