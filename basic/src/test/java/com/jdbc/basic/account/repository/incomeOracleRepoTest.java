package com.jdbc.basic.account.repository;

import com.jdbc.basic.account.domain.Income;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class incomeOracleRepoTest {

    IncomeRepository incomeRepository = new IncomeOracleRepo();

    @Test
    @DisplayName("수입내역 전체를 반환해야 한다.")
    void findAllTest(){

        Map<Integer, Income> incomeMap = incomeRepository.findAll();
        for (Integer serialNum : incomeMap.keySet()) {
            System.out.println(incomeMap.get(serialNum));
        }

        assertEquals(3, incomeMap.size());
    }


    @Test
    @DisplayName("월급 카테고리 내역을 출력한다.")
    void findCategoryTest(){

        Map<Integer, Income> incomeMap = incomeRepository.findCategory(1);
        for (Integer serialNum : incomeMap.keySet()) {
            System.out.println(incomeMap.get(serialNum));
        }

        assertEquals(1, incomeMap.size());
    }

}