package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/hw/s-login-form")
    public String loginForm() {
        System.out.println("로그인 폼 접속 요청");

        return "chap01/s-form";
    }

    @RequestMapping("/hw/s-login-check")
    public String check(String id, String password, Model model) {

//        model.addAttribute("id", id);
//        model.addAttribute("password", password);

        String msg = "";

        if (id.equals("grape111")) {
            if (password.equals("ggg9999")) {
                msg = "success";
            } else {
                msg = "f-pw";
            }
        } else {
            msg = "f-id";
        }

        model.addAttribute("msg", msg);
        return "chap01/s-result";


    }

  /*
        1번요청: 로그인 폼 화면 열어주기
        - 요청 URL : /hw/s-login-form
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap01/s-form.jsp
        - html form: 아이디랑 비번을 입력받으세요.

        2번요청: 로그인 검증하기
        - 로그인 검증: 아이디를 grape111 이라고 쓰고 비번을 ggg9999 라고 쓰면 성공
        - 요청 URL : /hw/s-login-check
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap01/s-result.jsp
        - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는경우, 비번 틀린경우

     */


}
