package com.spring.core.chap01_1;

public class Hotel {

    private Restaurent restaurant;
    private Chef headChef; // 인터페이스에 의존하도록 설계 변경
    // 인터페이스 선언 완료

    // restaurant 구체화 하기 생성자 만들기
    public Hotel(){
        this.restaurant = new EasternRestaurant();
        this.headChef = new KimuraChef();
    }

    // inform 메서드 선언
    public void inform(){
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());

        restaurant.reserve();
    }

}
