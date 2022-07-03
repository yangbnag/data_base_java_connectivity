package com.jdbc.basic.account.repository;

import com.jdbc.basic.account.domain.Expense;
import com.jdbc.basic.account.domain.Income;

import java.util.Map;

public interface ExpenseRepository {

    Map<Integer, Expense> findAll();

    // 지출 전제 금액 조회
    String getClassSum();

    // 지출 항목별 조회
    Map<Integer, Expense> findCategory(int whereNum);

    // 지출 정보 삭제
    boolean remove(int whereNum);

    // 행 정보 추출
    Expense findOne(int whereNum);

    // 지출 정보 저장
    boolean save(Expense expense, int categoryN);


    // 지출 정보 수정
    boolean modify(Expense expense);

}
