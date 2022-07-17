package com.spring.webmvc.springmvc.chap03_02.repository;


import com.spring.webmvc.springmvc.chap03_02.domain.BoardV2;

import java.util.List;

// 레파지토리 인터페이스
public interface BoardRepositoryV2 {

    // 조회수 표시
    boolean viewCnt(int boardNo);

    //게시물 전체 조회 기능
    List<BoardV2> findAll();
    //# Board 타입의 리스트에
    // 데이터 베이스에 있는 게시물 정보를 반환해 주는 메서드


    //게시물 상세 조회 기능
    BoardV2 findOne(int boardNo);
    // #회원번호를 입력 받으면 특정 게시물 객체에
    // 데이터 베이스 정보를 받아와 리턴 하는 메서드


    // 게시글 등록 요청
    boolean save(BoardV2 boardV2);
    // #게시물 객체를 입력 받으면 데이터베이스에 게시물을
    // 등록하는 메서드
    // 등록 결과를 boolean 타입으로 리턴


    // 게시글 삭제 요청
    boolean delete(int boardNo);
    // #게시물 번호를 입력 받으면 해당 게시물을
    // 데이터베이스에서 삭제 후
    // 결과를 boolean 타입으로 리턴


    // 게시글 수정 요청
    boolean update(String writer, String title, String content, int boardNo);
    // # 게시물 번호를 입력 받으면 해당 게시물의
    // 내용을 데이터베스에서 수정 한 후
    // 결과 값을 boolean 타입으로 리턴}
}
