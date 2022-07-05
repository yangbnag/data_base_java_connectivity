package com.spring.core.chap02.config;

import com.spring.core.chap02.*;
import com.spring.core.chap02.computer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration // 이 클래스는 설정 파일 입니다. 를 의미
public class ComputerConfig {

        // Computer -> keyboard, mouse, monitor 의존관계
        // keyboard -> course, restaurent 의존간계

        // 빈등록 방식 - 생성자 주입, 세터 주입
        @Bean
        public Mouse mouse() {
            return new LogitecMouse();
        }

        @Bean
        public Monitor monitor() {
            return new LgMonitor();
        }

       @Bean
       public Keyboard keyboard() {
            return new SamsungKeyboard();
       }

        @Bean
        public Computer computer() {
            return new Computer(keyboard(),mouse(),monitor());
        }


    }
