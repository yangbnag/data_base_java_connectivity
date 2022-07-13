package com.example.example.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

    @RequestMapping("/spring/about")
    public String about() {
        System.out.println("about 요청이 들어옴!!");
        return "about";
    }

    @RequestMapping("/spring/main")
    public String main() {
        System.out.println("main 요청이 들어옴!!");
        return "index.html";
    }

}
