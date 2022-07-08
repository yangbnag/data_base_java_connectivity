package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller // 스프링 컨테이너에 빈 등록
// 스프링의 HandlerMapping이 찾아서 DispatcherServlet에 연결함.
public class BasicController {

    // 클라이언트 요청 받기
    @RequestMapping("/spring/about") // 요청 URL을 적음
    public String about() {// 먼저 메서드를 만드는데 무조건 String 리턴, 이름은 마음대로

        System.out.println("about 요청이 들어옴!!");
        return "about";
        // jsp파일 포워딩, 리다이렉트
        // return "about"; 이라고 썼을 때 -> WEB-INF/views/about.jsp 포워딩
        // 초기 설정

    }

    @RequestMapping("/spring/hello")
    public String hello() {

        System.out.println("about 요청이 들어옴!!");

        //  /mvc/join 으로 재요청(redirect)
        return "redirect:/mvc/join"; // 이번에는 리다이렉트
    }

    // =============== 요청 파라미터 받기 (Query Parameter) ============//
    // == 1.HttpServletRequest 사용하기
    // == ex) /spring/person?name=kim&age=30

    @RequestMapping("/spring/person")
    public String person(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "";
    }
    // =============== 요청 파라미터 받기 (Query Parameter) ============//
    // == 2. @RequestParam 사용하기
    // == ex) /spring/major?stu=kim&major=business&grade=3

    @RequestMapping("/spring/major")
    public String major(
            @RequestParam("stu") String stu
            , @RequestParam("major") String major
            , @RequestParam("grade") int grade
    ) {
        System.out.println("학생명 :" + stu);
        System.out.println("전공 :" + major);
        System.out.println("학년 :" + grade);

        return "";
    }


    // == 2. @RequestParam 사용하기
    // 요청 파라미터 키값과 메서드 매개변수 이름이 같으면
    // @RequestParam 생략 가능

    @RequestMapping("/spring/major2")
    public String major2(String stu, String major, int grade) {

        System.out.println("학생명 :" + stu);
        System.out.println("전공 :" + major);
        System.out.println("학년 :" + grade);

        return "";
    }

    // =============== 요청 파라미터 받기 (Query Parameter) ============//
    // == 3. 커맨드 객체 이용하기
    // == ex) /spring/order?oNum=22&goods=구두&amount=3&price=10000&req=조심히다뤄주세요...
    // 주의사항 :
    //  -- 쿼리 파라미터 키값과 커맨드객체 필드명이 같아야 인식함.
    //  -- 반드시 setter / getter가 있어야 함.

    @RequestMapping("/spring/order")
    public String order(Order order){
        System.out.println(order);
        return "";

    }


}// end class

