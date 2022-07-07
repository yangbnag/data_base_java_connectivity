package com.spring.webmvc.chap01.controller;

import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 실질적으로 회원가입 데이터를 받아서 처리하는 서블릿
@WebServlet("/reg-process")
public class RegProcessServlet extends HttpServlet {

    private MemberRepository repository = MemoryMemberRepo.getInstance(); // RegProcessServlet 와 MemberRepository 는 의존 관계이다.

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = req.getParameter("account");// input에서의 key값을 입력한다.
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");

        //2.회원 정보를 적절한 저장소에 저장
        // 적절한 저장소? DB? 메모리? 해쉬맵?  => 프로그래밍 할때 변경 가능성을 열어놔야 한다.
        // valueobject = Member 클래스를 만들어서 위의 정보를 담겠습니다.

        Member member = new Member(account, password, userName);
        repository.save(member);

        //3. 홈 화면으로 이동(리다이렉션)
        resp.sendRedirect("/"); // "/" 를 입력하면 홈으로 이동


    }
}
