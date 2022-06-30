package com.jdbc.basic.score.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    @Test
    void lombokTest(){
        Score s = new Score(1, "김철수", 99,88,11,80,80);
        s.setTotal(222);

        System.out.println(s.getStuName());
        assertEquals(s.getStuName(),"김철수");
    }

    @Test
    void lombokBuilderTest(){
        // new Score.ScoreBuilder(3,"김철수",100,90,190,95); // 국어 점수를 빼고 싶어도 생성자는
                                         // 생성자 설정시 넣도록한 매개변수를 다 넣어야 한다.
        // 빌더를 사용하면 이런 불편함을 해결 할 수있다.
        // 원하는 매개변수로 생성자를 사용 할수 있게 한다.

        Score.ScoreBuilder park = new Score.ScoreBuilder();
        park
                .stuNum(2)
                .stuName("박영희")
                .math(92) // 수학
                .eng(100) // 영어 만 있고 국어 점수를 빼놓았다.
                .total(192)
                .average(96).build();

        System.out.println(park);

    }

}