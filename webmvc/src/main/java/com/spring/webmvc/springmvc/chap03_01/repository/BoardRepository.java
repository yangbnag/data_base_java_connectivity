package com.spring.webmvc.springmvc.chap03_01.repository;

import com.spring.webmvc.springmvc.chap03_01.domain.Board;

import java.util.List;

public interface BoardRepository {

    // 게시물 전체 조회
    List<Board> findAll();

    // 게시물 상세조회 요청
    Board findOne(int boardNo);

    // 게시글 등록요청
    boolean save(Board board);

    // 게시글 삭제요청
    boolean remove(int boardNo);

    // 게시글 수정요청
    boolean update(String writer, String title, String content, int boardNo);

}
