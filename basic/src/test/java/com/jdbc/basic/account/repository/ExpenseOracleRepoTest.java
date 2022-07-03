package com.jdbc.basic.account.repository;

import com.jdbc.basic.account.domain.Expense;
import com.jdbc.basic.account.domain.Income;
import org.junit.jupiter.api.DisplayName;
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
        System.out.println(expenseRepository.getClassSum());
    }

    @Test
    void findCategoryTest() {

        Map<Integer, Expense> expenseMap = expenseRepository.findCategory(5);

        for (Integer serialNum : expenseMap.keySet()) {
            System.out.println(expenseMap.get(serialNum));
        }

        assertEquals(1, expenseMap.size());

    }

    @Test
    void remove() {
     boolean flag =  expenseRepository.remove(1);

     if (flag) {
         System.out.println("삭제성공");
     }
    }

    @Test
    void findOne() {

       Expense e = expenseRepository.findOne(46);
        System.out.println(e);


    }

    @Test
    @DisplayName("지출내역 입력이 되어야 한다.")
    void insertTest() {
        int catergoryN = 1;
        Expense expense = new Expense();
        expense.setOutDate("22-07-03");
        expense.setOutDetail("테스트");
        expense.setOutAmount(5000);

        expenseRepository.save(expense, catergoryN);


    }

    @Test
    void modify() {

        Expense expense = expenseRepository.findOne(28);
        expense.setOutDate("22-08-01");
        expense.setOutDetail("테스트 입력");
        expense.setOutAmount(100000);

        expenseRepository.modify(expense);

        Expense newExpense = expenseRepository.findOne(28);
        assertEquals("테스트 입력", newExpense.getOutDetail());
    }

}
