package com.example.demogit.controller;

import com.example.demogit.dto.HelloDto;
import com.example.demogit.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private HelloService service;

    @Autowired
    public HelloController(HelloService service) {
        this.service = service;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public void hello() {
        System.out.println(service.getRandomNumber());
    }

    //http://localhost:8089/?num=5
    @RequestMapping(path = "/foo/", method = RequestMethod.GET)
    public void getNumber(@RequestParam("num") int num) {
        System.out.println(service.multTwo(num));
    }

    @RequestMapping(path = "/hello", method = RequestMethod.POST)
    public void getHelloDto(@RequestBody HelloDto dto) {
        service.parseDto(dto);
    }
}
