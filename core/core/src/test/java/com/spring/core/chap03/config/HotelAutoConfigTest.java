package com.spring.core.chap03.config;

import com.spring.core.chap03.Chef;
import com.spring.core.chap03.Hotel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class HotelAutoConfigTest {

    @Test
    @DisplayName("Component 애너테이션이 붙은 빈들이 등록되어야 한다.")
    void checkBeans(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HotelAutoConfig.class);

//        Chef chef = ac.getBean(Chef.class);
//        chef.cook();

        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();

        // 생성자에 쉐프와 레스토랑은 설정한 적이 없는데
        // 키무라와 이스턴레스토랑이 호텔에 적용됐다.
    }
    @Test
    @DisplayName("중복 빈이 등록되면 자동주입에 실패해야 한다.")
    void checkDuplicateBeans(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HotelAutoConfig.class);

//        Chef chef = ac.getBean(Chef.class);
//        chef.cook();

        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();

        // 생성자에 쉐프와 레스토랑은 설정한 적이 없는데
        // 키무라와 이스턴레스토랑이 호텔에 적용됐다.
    }
}


