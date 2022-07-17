package com.spring.webmvc.springmvc.chap03_02.repository;

import com.spring.webmvc.springmvc.chap03_02.domain.BoardV2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositorylmplV2Test {

    @Autowired
    BoardRepositoryV2 repository;

    @Test
    @DisplayName("게시물 정보 조회 하기 V2")
    void findAllTest(){
        List<BoardV2> boardV2List = repository.findAll();

        for (BoardV2 b : boardV2List) {
            System.out.println(b);
        }
    }

    @Test
    @DisplayName("게시물 상세 조회 하기 V2")
    void findOneTest(){
       int boardNo = 1;

        BoardV2 one = repository.findOne(boardNo);

        System.out.println(one);
        }

    @Test
    @DisplayName("게시물을 저장한다.")
    void save(){

        BoardV2 b = new BoardV2();
        b.setWriter("저장테작성자");
        b.setTitle("저장 테스트 제목");
        b.setContent("저장 테스트 내용");

        System.out.println(b);

        boolean result = repository.save(b);

        assertTrue(result);


    }

    @Test
    @DisplayName("게시물을 삭제한다")
    void deleteTest(){

        boolean result = repository.delete(8);

        assertTrue(result);
    }

    @Test
    @DisplayName("게시물을 수정한다")
    void updateTest(){

        boolean result = repository.update
       ("참새","아침바람",
               "아침바람 찬바람에 울고가는 저기러기",1);

        assertTrue(result);
    }

    @Test
    @DisplayName("조회수를 늘린다.")
    void updateViewCnt(){
        boolean result = repository.viewCnt(1);
        assertTrue(result);
    }







    }

