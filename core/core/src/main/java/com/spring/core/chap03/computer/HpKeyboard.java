package com.spring.core.chap03.computer;

import org.springframework.stereotype.Component;

@Component("hpKb")
public class HpKeyboard implements Keyboard {
    @Override
    public void info() {
        System.out.println("hp 키보드입니다.");
    }
}
