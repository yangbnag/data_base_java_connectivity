package com.spring.webmvc.springmvc.chap03_02.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
@Log4j2

public class BoardV2 {

    // 필드
    private int boardNo; // DB에서 시퀀스로 생성

    private String writer; // 클라이언트 작성
    private String title; // 클라이언트 작성
    private String content; // 클라이언트 작성

    private int viewCnt; // DB 에서 처리
    private String date; // DB 에서 처리

    // 기본 생성자
    public BoardV2(){}

    // 클라이언트가 작성하는 필드값을 만드는 생성자 만들기

    public BoardV2(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

  public BoardV2(ResultSet rs) throws SQLException {

        this.boardNo = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.viewCnt = rs.getInt("view_cnt");
        this.date = rs.getString("reg_date");

    }


}
