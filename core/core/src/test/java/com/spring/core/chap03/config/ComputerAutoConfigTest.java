package com.spring.core.chap03.config;

import com.spring.core.chap03.computer.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ComputerAutoConfigTest {

    @Test
    @DisplayName("Component 애너테이션이 붙은 빈들이 등록되어야 한다.")
    void checkBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComputerAutoConfig.class);
        Computer computer = ac.getBean(Computer.class);

        computer.showSpec();
    }

}