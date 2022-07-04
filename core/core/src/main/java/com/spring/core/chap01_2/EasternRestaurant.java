package com.spring.core.chap01_2;

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
