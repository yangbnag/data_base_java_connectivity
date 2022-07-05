package com.spring.core.chap02;

import com.spring.core.chap02.config.HotelConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    // 스프링 컨테이너에서 빈 가져오기
    AnnotationConfigApplicationContext ac = // AnnotationConfigApplicationContext : 컨테이너의 대리인 역할을 하는 클래스
    new AnnotationConfigApplicationContext(HotelConfig .class);


    @Test
    @DisplayName("스프링 컨테이너에 등록된 빈들의 의존관계가 잘 결합되어 있어야 한다.")
    void beanTest(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
    }

    @Test
    @DisplayName("등록된 빈의 타입으로 빈을 가져와야 한다.")
    void findBeanByType(){
    // 현재 등록된 빈은 코스, 레스토랑 , 쉐프, 호텔 총 4개 이다.
        Chef chef = ac.getBean(Chef.class);
        chef.cook();

        // 나는 chef의 실제 인스턴스가 KimuraChef일거라고 단언한다.
        assertInstanceOf(KimChef.class, chef);
    }

    // bean의 이름으로 가져오기
    @Test
    @DisplayName("등록된 빈의이름으로 빈을 가져와야 한다.")
    void findBeanByName(){
        // 빈의 이름은 따로 정해놓지 않으면 등록 메서드명이 이름이 된다.

        Restaurent restaurant =(Restaurent) ac.getBean("res");
    }

    // bean을 타입으로 가져오는게 좋긴 하지만 문제점이 있다. 동일한 여러개의 타입이 있을 경우
//    @Test
//    @DisplayName("등록된 빈의 타입이 중복이면 예외가 발생해야 한다.")
//    void findBeanByDuplicateType(){
//
////        Course course = ac. getBean(Course.class);
//
//        // 예외 발생 테스트
//        assertThrows(NoUniqueBeanDefinitionException.class)
//                , () -> ac.getBean(Course.class);
//    }

    @Test
    @DisplayName("등록된 빈의 타입이 중복이면 예외가 발생해야 한다.")
    void findBeanByDuplicateType() {

//        Course course = ac.getBean(Course.class);

        // 예외 발생 테스트
        assertThrows(NoUniqueBeanDefinitionException.class
                , () -> ac.getBean(Course.class));
    }


    @Test
    @DisplayName("등록된 빈의 타입이 중복이면 빈의 이름과 타입으로 조회하면 된다.")
    void findBeanByDuplicateType2(){

        Course course = ac. getBean("sc", Course.class);

        assertInstanceOf(SushiCourse.class, course);

    }

    @Test
    @DisplayName("스프링 컨테이너에 등록된 모든 빈들을 출력해야 한다.")
    void findAllBeans(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println("================");
        for (String beanDefinitionName : beanDefinitionNames) {

            // 등록된 빈의 메타데이터 가져오기
            BeanDefinition bd = ac.getBeanDefinition(beanDefinitionName);

            // ROLE_APPLICATION : 사용자가 직접 등록한 빈
            // ROLE_INFRASTRUCTURE : 스프링이 자체적으로 등록해서 사용하는 빈
            if(bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println(beanDefinitionName);
            }

        }

        System.out.println("=================");

    }

}
