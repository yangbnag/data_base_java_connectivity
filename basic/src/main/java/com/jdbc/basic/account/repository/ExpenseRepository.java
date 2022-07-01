package com.jdbc.basic.account.repository;

import com.jdbc.basic.account.domain.Expense;
import com.jdbc.basic.account.domain.Income;

import java.util.Map;

public interface ExpenseRepository {

    Map<Integer, Expense> findAll();

    // 수입 전제 금액 조회
    int getClassSum();

    // 수입 항목별 조회
    Map<Integer, Expense> findCategory(int whereNum);

    // 수입 정보 삭제
    boolean remove(int whereNum);

    // 행 정보 추출
    Income findOne(int whereNum);

    // 수입 정보 저장
    boolean save(Expense expense, int categoryN);


    // 수입 정보 수정
    boolean modify(Expense expense);

}
