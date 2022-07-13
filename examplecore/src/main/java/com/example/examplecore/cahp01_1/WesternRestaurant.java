package com.example.examplecore.cahp01_1;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class WesternRestaurant implements Restaurant{

    private Chef chef;
    private Course course;


    @Override
    public void reserve() {

    }

    @Override
    public void order() {

        chef.cook();

    }
}
