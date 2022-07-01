package com.jdbc.basic.account.repository;

import com.jdbc.basic.account.domain.Expense;
import com.jdbc.basic.account.domain.Income;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseOracleRepoTest {

    ExpenseRepository expenseRepository = new ExpenseOracleRepo();
    @Test
    void findAll() {
        Map<Integer, Expense> expenseMap = expenseRepository.findAll();
        for (Integer serialNum : expenseMap.keySet()) {
            System.out.println(expenseMap.get(serialNum));
        }

    }

    @Test
    void getClassSum() {
    }

    @Test
    void findCategoryTest() {

        Map<Integer, Expense> expenseMap = expenseRepository.findCategory(1);
        for (Integer integer : expenseMap.keySet()) {
            System.out.println(expenseMap.get(integer));
        }

        assertEquals(5, expenseMap.size());

    }

    @Test
    void remove() {
    }

    @Test
    void findOne() {
    }

    @Test
    void save() {
    }

    @Test
    void modify() {
    }
}
