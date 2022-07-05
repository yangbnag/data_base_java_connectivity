package com.spring.core.chap02;

import com.spring.core.chap02.computer.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ComputerXmlTest {

    // 스프링 컨테이너 객체 생성 (xml 설정파일 읽기)
    GenericXmlApplicationContext ac =
    new GenericXmlApplicationContext("ComputerConfig.xml"); // 경로를 적어야 함.

    @Test
    @DisplayName("xml 설정파일에 등록된 빈들을 조회해야 한다.")
    void findBeanTest(){
        Computer computer = ac.getBean(Computer.class);
        computer.showSpec();
    }
}
