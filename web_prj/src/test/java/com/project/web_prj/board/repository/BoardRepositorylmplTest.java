package com.project.web_prj.board.repository;

import com.project.web_prj.board.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositorylmplTest {

    @Autowired
    BoardRepository repository;

    @Test
    @DisplayName("300개의 게시물을 삽입해야 한다.")
    void bulkInsert() {

        Board board;
        for (int i = 0; i < 300; i++) {
            board = new Board();
            board.setTitle("제목" + i);
            board.setWriter("길동이" + i);
            board.setContent("안녕하세요!! ㅎㅇ! ㅎㅇ!" + i);
            repository.save(board);
        }
    }

    @Test
    @DisplayName("전체 게시물을 조회 해야 한다.")
    void findAllTest() {
        List<Board> boardList = repository.findAll();

        for (Board board : boardList) {
            System.out.println(board);
        }

        assertEquals(300, boardList.size());
    }

    @Test
    @DisplayName("특정 게시물을 조회하고")
    void findOneTest() {

        Board board = repository.findOne(600L);
        assertEquals("제목299",board.getTitle());

    }

    @Test
    @DisplayName("특정 게시물을 삭제하고 해당 글이 조회되지 않아야 한다.")
    @Transactional
    @Rollback
    void removetest(){
        boolean remove = repository.remove(300L);

        assertTrue(remove);

        assertThrows(DataAccessException.class , () -> repository.findOne(300L));

    }

    @Test
    @DisplayName("특정 게시물을 수정하고 해당 글이 조회했을 때 수정된 제목이 일치 해야 한다..")
    @Transactional
    @Rollback
    void modifyTest(){
        // give
        Board newboard = new Board();
        newboard.setBoardNo(600L);
        newboard.setTitle("수정된 제목");
        newboard.setWriter("수정된 작성자");
        newboard.setContent("수정된 내용 메롱미롱");

        //when
        boolean modify = repository.modify(newboard);
        Board board = repository.findOne(newboard.getBoardNo());

        //then
        assertTrue(modify);
        assertEquals("수정된 제목", board.getTitle());
        assertEquals("수정된 작성자", board.getWriter());
    }

    @Test
    @DisplayName("전체 게시물의 수를 반환한다.")
    void getTotalCalTest(){
        int cnt = repository.getTotalCount();

        assertTrue(300 == cnt);
    }

}