package com.spring.core.chap01_1;

public class WesternRestaurant implements Restaurent {

    private Chef chef; // 가정 : 코스 요리가 바뀔 때마다 해당 코스요리를 잘하는 요리사로 바뀐다.
    private Course course;

    public WesternRestaurant(){
        this.chef = new JuanChef();
        this.course = new FrenchCourse();
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
