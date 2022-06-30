package com.jdbc.basic.account.controller;

import com.jdbc.basic.account.domain.Income;
import com.jdbc.basic.account.repository.IncomeOracleRepo;
import com.jdbc.basic.account.repository.IncomeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 데이터들을 전처리 후처리하고 저장 관리하는 클래스
public class IncomeController {

    // 수입 정보가 저장될 맵
    private static Map<Integer, Income> incomeMap;

    //IncomeRepository에 의존성 관계를 가진다.
    private final IncomeRepository incomerepository;

    public IncomeController() { this.incomerepository = new IncomeOracleRepo();}

static {
        incomeMap = new HashMap<>();
        }

        //수입 내역 전체 조회
    public List<Income> findAllIncome(){
        Map<Integer, Income> incomes = incomerepository.findAll();
        incomeMap = incomes;

        List<Income> incomeList = new ArrayList<>();
        for (Integer serial : incomes.keySet()) {
            incomeList.add(incomeMap.get(serial));
        }
        return incomeList;
    }

    // 수입 항목별 조회
    public List<Income> findCategory(int whereNum) {
        Map<Integer, Income> incomes = incomerepository.findCategory(whereNum);
        incomeMap = incomes;

        List<Income> incomeList = new ArrayList<>();
        for (Integer serial : incomes.keySet()) {
            incomeList.add(incomeMap.get(serial));
        }
        return incomeList;
    }

    public int calClassSum(){
        return incomerepository.getClassSum();
    }
}
