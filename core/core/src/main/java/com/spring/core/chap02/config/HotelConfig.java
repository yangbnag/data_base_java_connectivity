package com.spring.core.chap02.config;

import com.spring.core.chap02.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 스프링 빈으 등록하는 설정파일
@Configuration // 이 클래스는 설정 파일 입니다. 를 의미

public class HotelConfig {

    // Hotel -> chef, restaurent 의존관계
    // Restaurent -> course, restaurent 의존간계

    // 빈등록 방식 - 생성자 주입, 세터 주입
    @Bean
    public Chef chef() {
        return new KimuraChef();
    }

    @Bean (name = "sc")
    public Course sushiCourse() {
        return new SushiCourse();
    }

    @Bean
    public Restaurent res() {
        // 생성자 주입(constructor injection)
//        EasternRestaurant er = new EasternRestaurant(chef(),sushiCourse());

        // 수정자 주입(setter injection)
        EasternRestaurant er = new EasternRestaurant();
        er.setChef(chef());
        er.setCourse(sushiCourse());

        // 생성자와 수정자 중 뭐가 더 좋을까?
        // 생성자가 더 안정적이다.
        // 생성자 주입시 EasternRestaurant 클래스의 Chef와 course가 final일때 수정이 용이함.

        return er;
    }

    @Bean
    public Hotel hotel() {
        return new Hotel(res(), chef());
    }

    @Bean (name = "fc")
    public Course frenchCourse(){
        return new FrenchCourse();
    }

}
