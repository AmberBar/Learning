package com.amber.controller;

import com.amber.queue.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Amber
 */
@RestController
@RequestMapping("/message")
public class ProderController {
    @Autowired
    ProducerService producerService;

    @GetMapping("/send")
    public boolean send(@RequestParam String message,
                     @RequestParam Long delay) {
        producerService.sendMessage(message, delay);
        return true;
    }
}
