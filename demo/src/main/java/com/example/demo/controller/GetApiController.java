package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController
{
    @GetMapping("/hello")
    public String getHello()
    {
        return "Called GetHello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)  // GetMapping과 같음
    public String hi()
    {
        return "hi";
    }

    @GetMapping("/path-variable/{path}")      // http://localhost:9090/api/get/path-variable/gggggg -> output : gggggg
    public String pathVariable(@PathVariable(name = "path") String pathName)  // gggggg -> {name} @PathVariable(name = "name")는 지정
    {
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> QueryParam)
    {
        StringBuilder builder =  new StringBuilder();

        QueryParam.entrySet().forEach(
                entry -> {
//                    System.out.println(entry.getKey());
//                    System.out.println(entry.getValue());
//                    System.out.println("");

                    builder.append(entry.getKey() + "=" + entry.getValue() + "\n");
                }
        );

        return builder.toString();
    }

    @GetMapping(path = "/query-param02")
    public String queryParam2(
            @RequestParam String name,    // HTTP Methoc와 변수명까지 맞춰야됨
            @RequestParam String email,
            @RequestParam int age
    )
    {
        return "name = " + name + "\nemail = " + email + "\nage" + age;
    }

    @GetMapping(path = "/query-param03")
    public String queryParam3(UserRequest request)  // Argument가 커스텀 모델 클래스라면 @RequestParam이 없어도 되네?
    {
        return "name = " + request.getName() + "\nemail = " + request.getEmail() + "\nage" + request.getAge();
    }
}
