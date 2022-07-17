package com.spring.webmvc.springmvc.chap03_02.service;

import com.spring.webmvc.springmvc.chap03_02.domain.BoardV2;
import com.spring.webmvc.springmvc.chap03_02.repository.BoardRepositoryV2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardV2ServiceTest {

    @Autowired
    BoardV2Service service;

    @Test
    @DisplayName("게시물 정보 조회 하기 V2")
    void findAllTest(){
        List<BoardV2> boardV2List = service.findAll();

        for (BoardV2 b : boardV2List) {
            System.out.println(b);
        }
    }

    @Test
    @DisplayName("게시물 상세 조회 하기 V2")
    void findOneTest(){
        int boardNo = 1;

        BoardV2 one = service.findOne(boardNo);

        System.out.println(one);
    }

    @Test
    @DisplayName("게시물을 저장한다.")
    void save(){

        BoardV2 b = new BoardV2();
        b.setWriter("서비스작성자");
        b.setTitle("서비스 저장 테스트 제목");
        b.setContent("서비스 저장 테스트 내용");

        System.out.println(b);

        boolean result = service.save(b);

        assertTrue(result);


    }

    @Test
    @DisplayName("게시물을 삭제한다")
    @Transactional
    @Rollback
    void deleteTest(){

        boolean result = service.delete(9);

        assertTrue(result);
    }

    @Test
    @DisplayName("게시물을 수정한다")
    @Transactional
    @Rollback
    void updateTest(){

        boolean result = service.update
                ("수정테스트","아침바람",
                        "아침바람 찬바람에 울고가는 저기러기",1);

        assertTrue(result);
    }

}