package com.spring.core.chap01_2.config;

import com.spring.core.chap01_2.*;

// 호텔에 필요한 객체들을 생성하고 조립하여 의존관계를 설정해주는 역할

// 호텔 매니저 같은 클래스를 Bean Factory 라고 한다.
// 스프링에서는 Spring Container 라고 한다.
public class HotelManager {

    // 쉐프 객체를 생성하여 리턴하는 메서드
    public Chef chef() {
        return new JuanChef();
    }

    // 코스 객체를 생성하여 리턴하는 메서드
    public Course course(){
        return new FrenchCourse();
    }

    // 레스트랑 객체를 생성하여 리턴하는 메서드
    public Restaurent restaurent(){
        return new WesternRestaurant(chef(),course());
    }

    // 호텔 객체를 생성하여 리턴하는 메서드
    public Hotel hotel(){
        return new Hotel(restaurent(), chef());
    }

}
