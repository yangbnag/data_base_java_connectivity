package com.spring.core.chap01_2;

import com.spring.core.chap01_2.config.HotelManager;
import org.junit.jupiter.api.Test;

public class HotelTest {

    @Test
    void objectTest() {

       // Hotel hotel = new Hotel(new WesternRestaurant(new KimuraChef(), new SushiCourse()), new JuanChef());

        HotelManager hm = new HotelManager();
        Hotel hotel = hm.hotel(); // 호텔 매니저가 호텔 사항을 설정한다.
        hotel.inform();
    }
}