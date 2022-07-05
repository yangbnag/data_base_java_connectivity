package com.spring.core.chap03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@NoArgsConstructor @Setter @Getter
@Component
public class WesternRestaurant implements Restaurent {

    private Chef chef; // 가정 : 코스 요리가 바뀔 때마다 해당 코스요리를 잘하는 요리사로 바뀐다.
    private Course course;

    @Autowired
    public WesternRestaurant(@Qualifier("jc") Chef chef, @Qualifier("fc") Course course){
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
