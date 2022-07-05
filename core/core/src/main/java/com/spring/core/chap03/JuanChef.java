package com.spring.core.chap03;

import org.springframework.stereotype.Component;

//자동 빈등록
@Component ("jc") // 자동 등록될 빈의 이름을 변경
public class JuanChef implements Chef {
    @Override
    public void cook() {
        System.out.println("양식의 대가 후안 입니다.");
    }
}
