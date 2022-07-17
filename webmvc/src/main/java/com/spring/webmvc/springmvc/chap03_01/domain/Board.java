/*
package com.spring.webmvc.springmvc.chap03_01.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
@Log4j2
public class Board {
    private int boardNo;
    private String writer;
    private String title;
    private String content;
    private int viewCnt;
    private String date;

    public Board(){
        log.info("Board 기본 생성자 호출!!");
    }

    public Board(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Board(ResultSet rs) throws SQLException {

        this.boardNo = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.viewCnt = rs.getInt("view_cnt");
        this.date = rs.getString("reg_date");

    }
}
*/
