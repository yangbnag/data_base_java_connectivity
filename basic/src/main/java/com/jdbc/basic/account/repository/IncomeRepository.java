package com.jdbc.basic.account.repository;

import com.jdbc.basic.account.domain.Income;

import java.util.Map;

public interface IncomeRepository {

    // 수입내역 전체 조회
  Map<Integer, Income> findAll();

  // 수입 전제 금액 조회
    int getClassSum();

    // 수입 항목별 조회
   Map<Integer, Income> findCategory(int whereNum);


   /* // 수입 정보 저장
    boolean save(Score score);


    // 수입 정보 삭제
    boolean remove(int stuNum);


    // 수입 정보 수정
    boolean modify(Score score);


    // 수입 금액 전체조회
    double getClassAverage();*/

}
