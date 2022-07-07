package com.spring.webmvc.chap04.v2;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.chap04.v2.controller.ContorollerV2;
import com.spring.webmvc.chap04.v2.controller.FormController;
import com.spring.webmvc.chap04.v2.controller.SaveController;
import com.spring.webmvc.chap04.v2.controller.ShowController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 모든 요청을 다 처리한다.
@WebServlet("/mvc/v2/*") // 처리할 url을 뭐라고 적어야 할까? 모든 요청을 다 처리할 /*
public class FrontControllerV2 extends HttpServlet {

    /*
     /mvc/v1/join - 회원가입 폼 요청 -> FormController 연결
     /mvc/v1/save - 회원가입 처리 요청 -> SaveController 연결
     /mvc/v1/show - 회원 목록 조회 요청 -> ShowController 연결
   */

    // 해시맵 사용: 하 컨트롤러들을 저장, 키값은 URL
    private final Map<String, ContorollerV2> contorollerMap
             = new HashMap<>();

    public FrontControllerV2() {
        contorollerMap.put("/mvc/v2/join", new FormController());
        contorollerMap.put("/mvc/v2/save", new SaveController());
        contorollerMap.put("/mvc/v2/show", new ShowController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //현재 들어온 요청 URI를 반환
        String uri  = req.getRequestURI();
        System.out.println("front-controller 요청이 들어옴~~~" + uri);

        // 컨트롤러맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ContorollerV2 controller = contorollerMap.get(uri);

        // 예외 처리를 해서 에러 방지

        if(controller == null) {
            resp.setStatus(404); // 404 : page not found
            return;
        }

        View view = controller.process(req, resp);
        if(view != null) view.render(req,resp);

        // 들어오는 요청에 맞게 컨트롤러를 만든 후 그 컨트롤러가 하는 일을 하도록 지시
        // 코드 작성 끝!



    }
}
