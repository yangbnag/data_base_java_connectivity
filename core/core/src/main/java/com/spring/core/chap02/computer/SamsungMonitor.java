package com.spring.core.chap02.computer;

public class SamsungMonitor implements Monitor {
    @Override
    public void info() {
        System.out.println("삼성 모니터입니다.");
    }
}
