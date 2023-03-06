package com.example.webexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlController {
    @GetMapping("/hello")
    @ResponseBody // 잘 사용하지 않는다.
    public String hello() {
        return "<html><body><h1>Hello World!</h1></body></html>"; // 템플릿 이름을 보통 return. Ex) Thymeleaf
    }
}
