package com.spring.webmvc.chap04.v1.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormController implements ContorollerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // chap03 에 있던 join 서블릿 코드 그대로 가지고 왔음.

        // 물리적 경로
        String viewName = "/WEB-INF/views/reg_form.jsp";

        RequestDispatcher dp
                = request.getRequestDispatcher(viewName);
        dp.forward(request,response);

    }
}
