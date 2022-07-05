package com.spring.core.chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 자동 빈 등록
@Component
public class Hotel {

    private Restaurent restaurant;
    private Chef headChef; // 인터페이스에 의존하도록 설계 변경
    // 인터페이스 선언 완료

    // restaurant 구체화 하기 생성자 만들기

    // 생성자 주임 사용시 생성자가 딱 한개면 @Autowired 없이도 자동으로 생성자 주입을 수행
    @Autowired //자동 의존성 주입
    public Hotel(@Qualifier("westernRestaurant") Restaurent restaurant,@Qualifier("jc") Chef chef){
        // 자동 의존성 주입시 헤드쉐프를 누구로 할지 정해줘야함.
        // 빈의 이름

        System.out.println("Hotel 생성자 호출!");
        this.restaurant = restaurant;
        this.headChef = chef;
    }

    // inform 메서드 선언
    public void inform(){
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());

        restaurant.reserve();
    }

}
