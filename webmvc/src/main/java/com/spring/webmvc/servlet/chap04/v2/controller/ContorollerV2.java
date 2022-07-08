package com.spring.webmvc.servlet.chap04.v2.controller;

import com.spring.webmvc.servlet.chap04.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ContorollerV2 {

    // 일을 시킬때는 process 라고 명령

    View process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    // 하위 컨트롤러들은 일을 나눠서 하기 때문에 request 정보가 필요하다.
    // 응답을 해야 하기 때문에 responese도 필요하다.


}
