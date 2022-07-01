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

    // 특정 행을 추츨
    public Income findOne(int whereNum) {
        return incomerepository.findOne(whereNum);
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

    public String calClassSum(){
        return incomerepository.getClassSum();
    }

    public boolean deleteIncome(int whereNume) {return incomerepository.remove(whereNume);}

    // 일련번호를 조회했을때 내역 존재 유무 리턴
    public boolean hasIncome(int whereNum){
        return incomerepository.findOne(whereNum) != null;
    }

    public void insertIncome(Income income, int categoryN) {

        incomeMap.put(income.getInSerial(), income);

        incomerepository.save(income, categoryN);

    }

    public boolean updateIncome (int whereNum, String date, String detail, int amt) {
        Income target = findOne(whereNum);

        if (target != null) {
            target.setInDate(date);
            target.setInDetail(detail);
            target.setInAmount(amt);

        }
            return incomerepository.modify(target);
    }



}//end class
