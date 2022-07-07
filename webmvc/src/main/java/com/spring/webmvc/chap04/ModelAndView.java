package com.spring.webmvc.chap04;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

    private View view; // 뷰 기능 포함 [컴포지션]

    // jsp에게 데이터를 전송할 모델객체
    private Map<String, Object> model = new HashMap<>();

    //생성자
    public ModelAndView(String viewName) {
        this.view = new View(viewName);
    }

    //모델 객체에 데이터를 추가하는 메서드
    public void addAttribute(String key, Object o){
        model.put(key,o);
    }
}
