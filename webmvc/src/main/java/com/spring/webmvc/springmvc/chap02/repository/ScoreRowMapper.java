package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreRowMapper implements RowMapper<Score> {
    @Override
    public Score mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Score(rs);

//        Score s = new Score(rs);
//        s.setStuNum(rs.getInt("stu_num"));
//        s.setName(rs.getString("stu_name"));
// 입력할게 많으니 간편하게 처리해보자
        // 생성자에 rs를 넘긴다.
        // 컬럼을 읽어서 스코어 필드 어디에 맵핑할 것인지를 알려줘야 함.

    }
}
