package com.spring.core.chap02;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // lombok 으로 기본생성자 만들어줌
@Setter @Getter // lombok 으로 세터, 게터 만들어줌
public class EasternRestaurant implements Restaurent {

    private Chef chef;
    private Course course; // 매일 변경되는 코스요리가 존재하는데 매일 변경되기
    // 때문에 코스를 인터페이스로 선언한다.

    public EasternRestaurant(Chef chef, Course course) {
        this.chef = chef;
        this.course = course;
    }

    @Override
    public void reserve() {
        course.combineMenu();
    }

    @Override
    public void order() {

        chef.cook();

    }
}
