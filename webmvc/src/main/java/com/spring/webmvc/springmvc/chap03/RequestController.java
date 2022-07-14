package com.spring.webmvc.springmvc.chap03;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class RequestController {

    @RequestMapping(value = "req/hello", method = RequestMethod.POST )
    @ResponseBody
    public String hello() {
        log.info("req/hello 요청!!");
        return "hello!!";
    }

//    @RequestMapping(value = "req/bye", method = RequestMethod.GET )
    @GetMapping("/req/bye")
    @ResponseBody
    public String bye() {
        log.info("req/bye 요청!!");
        return "bye!!";
    }

    // URL에서 파라미터 얻기
    @GetMapping("/member/{un}/{nickName}")// 식별자 이름은 개발자 마음대로
    @ResponseBody
    public String member(@PathVariable("un") String userName){ // 경로에서 값 읽기
                                     // 경로 이름이 userName 일 경우 PathVariable의
                                     // ("un") 생략 가능
        return "I am " + userName;
    }

}
