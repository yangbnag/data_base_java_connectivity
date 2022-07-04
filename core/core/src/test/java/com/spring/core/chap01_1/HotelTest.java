package com.spring.core.chap01_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HotelTest {
    @Test
    @DisplayName("호텔 객체를 생성하여 inform을 정상 호출한다.")
    void objectTest(){

        Hotel hotel = new Hotel();
        hotel.inform();
    }
}
