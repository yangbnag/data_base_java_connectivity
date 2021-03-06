package com.jdbc.basic.account.repository;

import com.jdbc.basic.account.domain.Income;
import com.jdbc.basic.score.domain.Score;

import java.util.Map;

public interface IncomeRepository {

    // 수입내역 전체 조회
  Map<Integer, Income> findAll();

    // 수입 전제 금액 조회
    String getClassSum();

    // 수입 항목별 조회
    Map<Integer, Income> findCategory(int whereNum);

    // 수입 정보 삭제
    boolean remove(int whereNum);

    // 행 정보 추출
    Income findOne(int whereNum);

    // 수입 정보 저장
    boolean save(Income income, int categoryN);


    // 수입 정보 수정
    boolean modify(Income income);



}
