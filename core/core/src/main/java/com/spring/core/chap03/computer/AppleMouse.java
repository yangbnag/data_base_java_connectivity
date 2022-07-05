package com.spring.core.chap03.computer;

import org.springframework.stereotype.Component;

@Component
public class AppleMouse implements Mouse {
    @Override
    public void info() {
        System.out.println("애플 마우스입니다.");
    }
}
