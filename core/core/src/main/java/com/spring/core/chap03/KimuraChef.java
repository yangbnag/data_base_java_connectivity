package com.spring.core.chap03;

import org.springframework.stereotype.Component;

//자동 빈등록
@Component ("kc") // 자동 등록될 빈의 이름 변경하기
public class KimuraChef implements Chef {
    @Override
    public void cook() {
        System.out.println("일식의 대가 키무라 입니다.");
    }
}
