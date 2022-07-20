package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap04.mybatis.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("학생 정보를 등록해야 한다.")
    void saveTest() {
        Score s = new Score("마이바",100,100,100);
        mapper.save(s);

    }

    @Test
    @DisplayName("학생 정보를 삭제 해야 한다.")
    void removeTest(){
        mapper.remove(21);

    }

    @Test
    @DisplayName("학생 전체 정보를 조회 해야 한다.")
    void findAllTest(){
        List<Score> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    @DisplayName("학생 개별 정보를 조회 해야 한다.")
    void findOneTest(){
        Score one = mapper.findOne(22);
        System.out.println(one);
    }

}
