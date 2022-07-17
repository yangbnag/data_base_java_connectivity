package com.spring.webmvc.springmvc.chap03_02.domain;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardV2RowMapper implements RowMapper<BoardV2> {

    @Override
    public BoardV2 mapRow(ResultSet rs, int rowNum) throws SQLException {
//        BoardV2 b = new BoardV2();
//        b.setBoardNo(rs.getInt("board_no"));
//        b.setWriter(rs.getString("writer"));
//        b.setTitle(rs.getString("title"));
//        b.setContent(rs.getString("content"));
//        b.setViewCnt(rs.getInt("view_cnt"));
//        b.setDate(rs.getString("reg_date"));

        return new BoardV2(rs);
    }
}
