package com.jdbc.basic.account.controller;

import com.jdbc.basic.account.domain.Expense;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseControllerTest {

    public static void main(String[] args) {
        ExpenseController eps = new ExpenseController();
//        List<Expense> category = eps.findCategory(3);
//        System.out.println(category.size());
//
//        for (Expense expense : category) {
//            System.out.println(expense);
//        }


        System.out.println(eps.hasExpense(4));




    }


}