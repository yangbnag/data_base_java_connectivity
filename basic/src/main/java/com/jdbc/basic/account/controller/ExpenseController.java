package com.jdbc.basic.account.controller;

import com.jdbc.basic.account.domain.Expense;
import com.jdbc.basic.account.domain.Income;
import com.jdbc.basic.account.repository.ExpenseOracleRepo;
import com.jdbc.basic.account.repository.ExpenseRepository;
import com.jdbc.basic.account.repository.IncomeOracleRepo;
import com.jdbc.basic.account.repository.IncomeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseController {
    // 수입 정보가 저장될 맵
    private static Map<Integer, Expense> expenseMap;

    //IncomeRepository에 의존성 관계를 가진다.
    private final ExpenseRepository expenseRepository;

    public ExpenseController() { this.expenseRepository = new ExpenseOracleRepo();}

    static {
        expenseMap = new HashMap<>();
    }

    //지출 내역 전체 조회
    public List<Expense> findAllExpense(){
        Map<Integer, Expense> expenses = expenseRepository.findAll();
        expenseMap = expenses;

        List<Expense> expenseList = new ArrayList<>();
        for (Integer serial : expenses.keySet()) {
            expenseList.add(expenseMap.get(serial));
        }
        return expenseList;
    }

    // 지출 항목별 조회
    public List<Expense> findCategory(int where) {
        Map<Integer, Expense> expenses = expenseRepository.findCategory(where);
        expenseMap = expenses;

        List<Expense> expenseList = new ArrayList<>();
        for (Expense e : expenseList) {
            expenseList.add(expenseMap.get(e));
        }
        return expenseList;
    }

}
