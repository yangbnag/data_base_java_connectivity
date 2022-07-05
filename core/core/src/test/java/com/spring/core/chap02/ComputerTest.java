package com.spring.core.chap02;

import com.spring.core.chap02.computer.Computer;
import com.spring.core.chap02.computer.Monitor;
import com.spring.core.chap02.config.ComputerConfig;
import com.spring.core.chap02.config.HotelConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(ComputerConfig.class);
    @Test
    @DisplayName("설정파일에 등록한 Computer 빈을 가져와야 한다.")
    void findBeanTest(){
        Computer computer = ac.getBean(Computer.class);
        computer.showSpec();
    }

    @Test
    @DisplayName("컨테이너에서 조회한 빈은 단 하나의 객체여야 한다.")
    void singleton(){
        Monitor m1 = ac.getBean(Monitor.class);
        Monitor m2 = ac.getBean(Monitor.class);

        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);

        assertEquals(m1,m2);

    }
}
