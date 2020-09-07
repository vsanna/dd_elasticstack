package dev.ishikawa.demo.elasticstack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    final static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @GetMapping("/hello")
    public String hello() {
        logger.info("GET /hello");
        return "hello";
    }

    @PostMapping("/hello")
    public String helloPost() {
        logger.info("POST /hello");
        return "hello_post";
    }

    @GetMapping("/world")
    public String world() {
        logger.info("GET /world");
        return "world";
    }

    @PostMapping("/world")
    public String worldPost() {
        logger.info("POST /world");
        return "world_post";
    }
}
