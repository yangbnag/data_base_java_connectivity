package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;

import java.util.Map;
// ctrl + alt + o : 안쓰는 import 일괄 삭제

public interface ControllerV3 {

    /**
     *
     * @param paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌
     * @return
     */
    View process(Map<String, String> paramMap);

}
