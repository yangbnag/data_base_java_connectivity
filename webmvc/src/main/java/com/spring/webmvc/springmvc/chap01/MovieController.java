package com.spring.webmvc.springmvc.chap01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class MovieController {

    // 영화 폼 요청
    @RequestMapping("/movie/form")
    public String form(){
        log.info("movie/form GET Request");
        return "chap01/movie-form";
    }

    // 영화 선택 요청
    @RequestMapping("/movie/result")
    public String result(String menu, int price, Model model) {
        log.info("/movie/result/ POST [" + menu + ","+ price +"]");

        if(menu.equals("captinamerica")) {
            menu = "캡틴아메리카";
        } else if (menu.equals("ring")) {
            menu = "미국확장판 링";
        } else if (menu.equals("ironman")) {
            menu = "돌아온 아이언맨";
        }

        model.addAttribute("menu",menu);
        model.addAttribute("price",price);

        return "chap01/movie-result";
    }

}
