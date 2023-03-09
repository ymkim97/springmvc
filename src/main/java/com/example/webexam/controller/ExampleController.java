package com.example.webexam.controller;

import com.example.webexam.controller.request.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

// http://localhost:9090/example
@RestController // json, xml 데이터를 반환하는 컨트롤러 사용
@RequestMapping("/example")
public class ExampleController {

    // GET 방식으로 http://localhost:9090/example/1
    // 컨트롤러 핸들러
    @GetMapping("/1")
    public String example1() {
        return "example1";
    }

    @GetMapping("/2")
    public String example2(HttpServletRequest request) {
        System.out.println(request);
        return "example1";
    }

    @PostMapping("/3")
    public String example3(@RequestParam(name = "name") String name,
                           @RequestParam(name = "email") String email) {
        System.out.println(name);
        System.out.println(email);
        return "example3";
    }

    // RestController는 브라우저에서 동작하는 JavaScript가 보통 호출한다.
    // JavaScript가 호출할때는 Json 데이터를 Post방식으로 body에 담아서 보낸다.

    // RestController에서 객체를 반환하면 Json으로 변환된다. -> 요청에 따라 xml로 변환될 수도 있다.
    @PostMapping("/4")
    public User example4(@RequestBody User user) {
        System.out.println(user);
        user.setRandom(new Random().nextInt(100));
        return user;
    }

    //  http://localhost:9090/example/pathexam/어떤특정값
    @GetMapping("/pathexam/{id}")
    public String pathExam(@PathVariable(name = "id") String id) {
        System.out.println(id);
        return "pathexam";
    }

    @GetMapping("/headerexam")
    public String headerExam(@RequestHeader(name = "User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "headerexam";
    }
}
