package com.example.examplecore.cahp01_1;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Hotel {
    private Restaurant restaurant;
    private Chef headChef;


    public void infom() {

        System.out.printf("우리 호텔의 레스토랑은 %s 이며 , 헤드쉐프는 %s 입니다.",
                restaurant.getClass().getName(),headChef.getClass().getName());
    }
}
