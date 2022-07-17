package com.spring.webmvc.springmvc.chap03_02.repository;

import com.spring.webmvc.springmvc.chap03_02.domain.BoardV2;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// BoardRepository 구현체
@Repository // 빈 등록
@RequiredArgsConstructor // final 의존관계 객체 자동생성
public class BoardRepositorylmplV2 implements BoardRepositoryV2{

    private final JdbcTemplate template; // JdbcTemplet에 의존


    @Override
    public List<BoardV2> findAll() {
       StringBuilder sql = new StringBuilder("SELECT * FROM board");
//       return template.query(sql.toString(),new BoardV2RowMapper());

//       return template.query(sql.toString(), new RowMapper<BoardV2>() {
//           @Override
//           public BoardV2 mapRow(ResultSet rs, int rowNum) throws SQLException {
//               return new BoardV2(rs);
//           }
//       });

       return template.query(sql.toString(), (rs, rowNum) -> new BoardV2(rs));
    }

    @Override
    public BoardV2 findOne(int boardNo) {
       String sql = "SELECT * FROM board WHERE board_no = ?";
        return template.queryForObject(sql, (rs,rowNum) -> new BoardV2(rs), boardNo);
    }

    @Override
    public boolean save(BoardV2 boardV2) {
       String sql = "INSERT INTO board " +
                    "(board_no, writer, title, content) " +
                    "VALUES (seq_board.nextval, ?, ?, ?)";
        return
        template.update(sql, boardV2.getWriter(), boardV2.getTitle(), boardV2.getContent()) == 1;
    }

    @Override
    public boolean delete(int boardNo) {
       String sql = "DELETE FROM board WHERE board_no = ?";

        return template.update(sql,boardNo) == 1;
    }

    @Override
    public boolean viewCnt(int boardNo) {
        String sql = " UPDATE board SET view_cnt = view_cnt+1 WHERE board_no = ? ";

        return template.update(sql,boardNo) == 1;
    }


    @Override
    public boolean update(String writer, String title, String content, int boardNo) {
       String sql = "UPDATE board " +
               "SET writer = ?, " +
               "title = ?, content = ? " +
               "WHERE board_no = ?";

        return template.update(sql,writer,title,content, boardNo) == 1;
    }
}
