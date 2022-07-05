package com.spring.core.chap03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@NoArgsConstructor // lombok 으로 기본생성자 만들어줌
@Getter // lombok 으로 세터, 게터 만들어줌
// 자동 빈 등록
@Component
public class EasternRestaurant implements Restaurent {

    private Chef chef;
    private Course course; // 매일 변경되는 코스요리가 존재하는데 매일 변경되기
    // 때문에 코스를 인터페이스로 선언한다.

  //생성자 자동 주입 명시
    public EasternRestaurant(@Qualifier("kc") Chef chef, Course course) {
        System.out.println("EasternRestaurant 생성자 호출");
        this.chef = chef;
        this.course = course;
    }


    // setter 자동주입

    // 수정자 주입
    @Autowired
    @Qualifier("kc")
    public void setChef(Chef chef) {
        System.out.println("Eastern setChef 호출!");
        this.chef = chef;
    }

    @Autowired
    public void setCourse(Course course) {
        System.out.println("Eastern setCourse 호출!");
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
