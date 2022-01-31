package com.example.demo.controller;

import com.example.demo.dto.PutRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController
{
    /*
    @PutMapping("/put")
    public PutRequestDTO put(@RequestBody PutRequestDTO RequestData)
    {
        System.out.println(RequestData);

        return RequestData;
    }
     */

    //http://localhost:9090/api/put/100  -> userid = 100
    @PutMapping("/put/{userid}")
    public PutRequestDTO put(@RequestBody PutRequestDTO RequestData, @PathVariable(name = "userid") Long id)
    {
        System.out.println(id);

        return RequestData;
    }
}
