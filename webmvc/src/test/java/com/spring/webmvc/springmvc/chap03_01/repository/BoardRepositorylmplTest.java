/*
package com.spring.webmvc.springmvc.chap03_01.repository;

import com.spring.webmvc.springmvc.chap03_01.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositorylmplTest {
    @Autowired
    BoardRepository repository;

    @Test
    @DisplayName("게시물이 저장되어야 한다.")
    void saveTest(){
        Board b = new Board("짹짹이", "아침바람찬바람", "울고가는 저기러기 블라블라");

        boolean result = repository.save(b);

        assertTrue(result);
    }

    @Test
    @DisplayName("모든 게시물 정보를 조회해야 한다.")
    void findAllTest(){
        List<Board> boardList = repository.findAll();

        boardList.forEach(b -> System.out.println(b));

    }

    @Test
    @DisplayName("특정 게시물의 정보를 조회해야 한다.")
    void findOneTest(){
        Board board = repository.findOne(1);
        System.out.println(board);
        assertEquals("꿀꿀이", board.getWriter());
    }

    @Test
    @DisplayName("특정 게시물을 삭제해야한다.")
//    @Transactional
//    @Rollback
    void removeTest(){
        int boardNo = 3;

        boolean result = repository.remove(boardNo);

        assertTrue(result);

    }

    @Test
    @DisplayName("특정 게시물의 데이터를 수정해야 한다.")
    void updateTest(){
        boolean result = repository.update("kkk", "zzz", "abcdefg", 2);

        assertTrue(result);

    }

}*/
