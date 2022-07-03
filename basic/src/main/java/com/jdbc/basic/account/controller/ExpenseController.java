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
        for (Integer integer : expenses.keySet()) {
            expenseList.add(expenseMap.get(integer));
        }
        return expenseList;
    }

    public String calClassSum(){
        return expenseRepository.getClassSum();
    }

    public boolean deleteExpense (int whereNum){
        return expenseRepository.remove(whereNum);
    }

    // 특정 행을 추츨
    public Expense findOne(int whereNum) {
        return expenseRepository.findOne(whereNum);
    }
    public boolean hasExpense(int whereNum) {
        return  expenseRepository.findOne(whereNum) != null;
    }

    public void insertExpense(Expense expense, int categoryN) {

        expenseMap.put(expense.getOutSerial(), expense);

        expenseRepository.save(expense, categoryN);

    }

    public boolean updateExpense (int whereNum, String date, String detail, int amt) {
        Expense target =findOne(whereNum);

        if (target != null) {
            target.setOutDate(date);
            target.setOutDetail(detail);
            target.setOutAmount(amt);

        }
        return expenseRepository.modify(target);
    }



}
