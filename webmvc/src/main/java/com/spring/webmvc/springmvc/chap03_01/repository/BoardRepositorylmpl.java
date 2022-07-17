/*
package com.spring.webmvc.springmvc.chap03_01.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap03_01.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositorylmpl implements BoardRepository {

    private final JdbcTemplate template;

    @Override
    public List<Board> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM board");

        return template.query(sql.toString(), (rs, rowNum) -> new Board(rs));
    }

    @Override
    public Board findOne(int boardNo) {
        String sql = "SELECT * FROM board WHERE board_no = ?";


        return template.queryForObject(sql, (rs, rowNum) -> new Board(rs), boardNo);
    }

    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO board " +
                "(board_no, writer, title, content) "+
                "VALUES (seq_board.nextval, ?, ?, ?)";

        // INSERT, UPDATE, DELETE는 템플릿의 update() 메서드 활용
        return template.update(sql, board.getWriter(), board.getTitle(), board.getTitle()
                ) == 1;
    }

    @Override
    public boolean remove(int boardNo) {
        String sql = "DELETE FROM board WHERE board_no = ?";
        return template.update(sql, boardNo) == 1;
    }

    @Override
    public boolean update(String writer, String title, String content, int boardNo) {
        String sql = "UPDATE board " +
                "SET writer = ?, title = ?, content = ? " +
                "WHERE board_no = ?";

        return template.update(sql,writer, title, content, boardNo) == 1;
    }
}
*/
