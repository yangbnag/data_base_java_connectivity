package com.project.web_prj.board.repository;

import com.project.web_prj.board.domain.Board;
import com.project.web_prj.common.paging.Page;
import com.project.web_prj.common.search.Search;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper mapper;

    @Test
    @DisplayName("게시글을 등록 한다.")
    void saveTest() {
        Board board = new Board();
        board.setWriter("mapper작성");
        board.setTitle("mapper제목");
        board.setContent("mapper내용 작성");

        mapper.save(board);
    }

    @Test
    @DisplayName("게시글을 삭제한다.")
    void removeTest() {
        mapper.remove(613L);
    }

    @Test
    @DisplayName("게시글을 수정한다.")
    void modifyTest() {
        Board newboard = new Board();
        newboard.setBoardNo(614L);
        newboard.setTitle("수정된 제목");
        newboard.setWriter("수정된 작성자");
        newboard.setContent("수정된 내용 메롱미롱");

        //when
        boolean modify = mapper.modify(newboard);
        Board board = mapper.findOne(newboard.getBoardNo());

        //then
        assertTrue(modify);
        assertEquals("수정된 제목", board.getTitle());
        assertEquals("수정된 작성자", board.getWriter());
    }

    @Test
    @DisplayName("전체 게시물을 조회 해야 한다.")
    void findAllTest() {
        List<Board> boardList = mapper.findAll(new Page(1, 10));

        for (Board board : boardList) {
            System.out.println(board);
        }
    }

    @Test
    @DisplayName("특정 게시물을 조회")
    void findOneTest() {

        Board board = mapper.findOne(614L);
        System.out.println(board);
    }

    @Test
    @DisplayName("총 게시물의 수를 구한다.")
    void getTotalCountTest() {
        int totalCount = mapper.getTotalCount();
        System.out.println(totalCount);
    }

    @Test
    @DisplayName("특정 게시물의 조회수가 올라가야 한다.")
    void upViewCountTest() {
        mapper.upViewCount(301L);
        Board one = mapper.findOne(301L);
        System.out.println(one.getViewCnt());
    }

    @Test
    @DisplayName("제목으로 검색된 목록으로 조회해야 한다.")
    void searchByTitleTest() {
        Search search = new Search("tc", "장첸");

        mapper.findAll2(search).forEach(System.out::println);
    }

}
