package com.example.demogit.service;

import com.example.demogit.dto.HelloDto;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HelloService {

    public int getRandomNumber() {
        return new Random().nextInt();
    }

    public int multTwo(int num) {
        return num * 2;
    }

    public void parseDto(HelloDto dto) {
        System.out.println(dto.getName());
        System.out.println(dto.getAge());
    }
}
