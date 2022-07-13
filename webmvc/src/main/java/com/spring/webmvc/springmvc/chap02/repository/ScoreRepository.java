package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;

import java.util.List;

// 학생의 성적정보를 저장, 조회, 수정 삭제하는 저장소 역할
public interface ScoreRepository {

    // 점수 저장
    boolean save(Score score);

    // 전체 점수 정보 조회
    List<Score> findAll();

    // 개별 점수 조회
    Score findOne(int stuNum);

    // 점수 정보 삭제
    boolean remove(int stuNum);

    // 평균 1등 정보 구하기
    List<Score> findFirst();

    // 평균 꼴등 정보 구하기
    List<Score> findlast();





}
