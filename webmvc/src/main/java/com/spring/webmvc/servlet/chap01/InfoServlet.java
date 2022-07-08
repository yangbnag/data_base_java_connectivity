package com.spring.webmvc.servlet.chap01;
/*
 # 서블리 : http 요청과 응답 데이터를 쉽게 처리할 수 있도록 도와주는 자바의 API 이다.
 내가 지금 원하는게 뭔지 서버에 알려줘야 한다.
 ex) 네이버 로그인 페이지로 가기를 원한다
  - 요청 url에 https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com
    이렇게 써야 한다.
*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info") // 우리 사이트에서 정보를 얻고 싶다면 /info 라고 이야기를 해라.
public class InfoServlet extends HttpServlet { //HttpServlet 상속 받아야 한다.

    public InfoServlet(){
        System.out.println("Info constructor call!");
    }

    // 서블릿 하기 위해서는 메서드 오버라이드 필요함.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("info 요청이 들어옴!!");

        // 요청 정보를 받은 후 응답을 해주려고 한다.
        Double height = Double.parseDouble(req.getParameter("height"));
        Double weight = Double.parseDouble(req.getParameter("weight"));

        // 응답 정보 생성하기 [원래는 양식에 맞게 다 써줘야 하는데 서블릿이 다 처리해준다.]
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        // 고전 방식
        w.write("<html>");
        w.write("<body>");
        double bmi = calcBMI(height,weight);
        w.write("<h1> 당신의 체질량 지수는" + bmi + "입니다.!?</h1>");

        if(bmi>25.0) {
            w.write("<h2>과체중 입니다.</h2>");
        } else if (bmi < 18.5) {
            w.write("<h2>저체중 입니다.</h2>");
        } else {
            w.write("<h2>정상 체중중입니다.</h2>");
       }

        w.write("</body>");
        w.write("</html>");
    }

    private double calcBMI(double cm, double kg){
        double m = cm / 100;
        double bmi = kg / (m * m);
        return bmi;
    }
}
