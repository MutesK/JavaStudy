package com.example.aop.controller;

import com.example.aop.anotation.Decode;
import com.example.aop.anotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController
{

    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id, @RequestParam String name)
    {
        System.out.println("get method : " + id + ", " + name);
    }

    @PostMapping("/post")
    public User post(@RequestBody User user)
    {
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException
    {
        Thread.sleep(1000);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user)
    {
        return user;
    }
}
