package com.example.webexam.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 응답이 Data.
public class JsonController {
    @GetMapping("/hello.json") // Hello 클래스가 View의 역할, Hello 클래스를 json으로 변환해서 응답.
    public Hello hello(){
        Hello hello = new Hello();
        hello.setMessage("Hello World!!!");
        hello.setCount(10);
        return hello;
    }
}

@Data
class Hello{
    private String message;
    private int count;
}