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

        //assertEquals(3, incomeMap.size());
    }


    @Test
    @DisplayName("월급 카테고리 내역을 출력한다.")
    void findCategoryTest(){

        Map<Integer, Income> incomeMap = incomeRepository.findCategory(2);
        for (Integer serialNum : incomeMap.keySet()) {
            System.out.println(incomeMap.get(serialNum));
        }

        assertEquals(1, incomeMap.size());
    }

    @Test
    @DisplayName("수입내역 입력이 되어야 한다.")
    void insertTest(){
        int categoryN = 1;
        Income income = new Income();
        income.setInDate("22-07-01");
        income.setInDetail("보너스");
        income.setInAmount(500000);


        incomeRepository.save(income, categoryN);

        Income one = incomeRepository.findOne(11);
    }

    @Test
    @DisplayName("수입 내역의 정보가 수정 되어야 한다.")
        void modifiyTest(){

        Income income = incomeRepository.findOne(3);
        income.setInDate("22-08-01");
        income.setInDetail("테스트 입력");
        income.setInAmount(10000000);

        boolean result = incomeRepository.modify(income);

        Income newIncome = incomeRepository.findOne(3);
        assertEquals(10000000, newIncome.getInAmount());

        }

        @Test
        @DisplayName("총합을 구하고 그 표현이 원화로 되어야 한다.")
        void calGetTest(){

            IncomeOracleRepo ico = new IncomeOracleRepo();

            String classSum = ico.getClassSum();
            System.out.println(classSum);

        }

}