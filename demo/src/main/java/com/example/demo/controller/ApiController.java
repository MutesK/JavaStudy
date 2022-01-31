package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스는 REST API를 처리하는 컨트롤러
@RequestMapping("/api")  // RequestMapping URI 를 지정해주는 Annotation
public class ApiController
{
    @GetMapping("/hello")       // http://localhost:9090/api/hello -> http method GET
    public String hello()
    {
        return "hello spring boot!";
    }
}
