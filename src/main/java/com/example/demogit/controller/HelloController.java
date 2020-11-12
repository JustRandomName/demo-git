package com.example.demogit.controller;

import com.example.demogit.dto.HelloDto;
import com.example.demogit.repo.UserRepository;
import com.example.demogit.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HelloController {

    private HelloService service;
    private UserRepository userRepository;

    @Autowired
    public HelloController(HelloService service,
                           UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public void hello() {
//        System.out.println(service.getRandomNumber());
//    }

    //http://localhost:8089/?num=5
    @RequestMapping(path = "/foo/", method = RequestMethod.GET)
    public void getNumber(@RequestParam("num") int num) {
        System.out.println(service.multTwo(num));
    }

    @RequestMapping(path = "/hello", method = RequestMethod.POST)
    public void getHelloDto(@RequestBody HelloDto dto) {
        service.parseDto(dto);
    }


    @RequestMapping(path = "/getUser", method = RequestMethod.GET)
    public void getUser() {
        userRepository.findAll();
    }

    @RequestMapping(value = "/", method = GET)
    public ModelAndView showMainForm(ModelAndView view) {
        view.setViewName("main");
        return view;
    }
}
