package com.jdbc.basic.account.repository;

import com.jdbc.basic.score.domain.Score;

import java.util.Map;

public interface expenseRepository {


    // 지출내역 전체 조회
    Map<Integer, Score> findAll();

    // 수입내역 전체 조회






    // 수입 정보 저장
    boolean save(Score score);

    // 지출 정보 저장
//    boolean save(Score score);

    // 수입 정보 삭제
    boolean remove(int stuNum);

    // 지출 정보 삭제
//    boolean remove(int stuNum);

    // 성적 정보 수정
    boolean modify(Score score);



    // 개별 성적 조회
    Score findOne(int stuNum);

    // 반 전체 평균 조회
    double getClassAverage();

}
