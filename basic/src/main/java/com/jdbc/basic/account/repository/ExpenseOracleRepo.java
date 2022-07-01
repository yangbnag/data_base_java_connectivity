package com.jdbc.basic.account.repository;

import com.jdbc.basic.Connect;
import com.jdbc.basic.account.domain.Expense;
import com.jdbc.basic.account.domain.Income;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Oracle DBMS에 가계부의 수입 정보를 CRUD하는 클래스
public class ExpenseOracleRepo implements ExpenseRepository {


    //수입내역 전체 조회
    @Override
    public Map<Integer, Expense> findAll() {

        Map<Integer, Expense> expenseMap = new HashMap<>();

        String sql = "SELECT out_serial_nm, TO_CHAR(out_date,'yy-mm-dd') out_date, out_detail, out_amt FROM expense ORDER BY out_date";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Expense e = new Expense(
                        rs.getInt("out_serial_nm")
                        , rs.getString("out_date")
                        , rs.getString("out_detail")
                        , rs.getInt("out_amt")
                );
                expenseMap.put(e.getOutSerial(), e);
            }
            return expenseMap;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    @Override
    public int getClassSum() {
        return 0;
    }

    @Override
    public Map<Integer, Expense> findCategory(int whereNum) {

        Map<Integer, Expense> expenseMap = new HashMap<>();

        String sql = "SELECT " +
                " A.out_serial_nm, TO_CHAR(A.out_date, 'yy-mm-dd') out_date, A.out_detail, A.out_amt " +
                " FROM expense A, expense_category B" +
                " WHERE a.category_num = b.out_ca_serial_nm" +
                " AND b.out_category_num = ? ";

        try(Connection conn = Connect.makeConnection()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,whereNum);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Expense e = new Expense(
                        rs.getInt("out_serial_nm")
                        ,rs.getString("out_date")
                        ,rs.getString("out_detail")
                        ,rs.getInt("out_amt")
                );

                expenseMap.put(e.getOutSerial(),e);
            }
            return expenseMap;


        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    @Override
    public boolean remove(int whereNum) {
        return false;
    }

    @Override
    public Income findOne(int whereNum) {
        return null;
    }

    @Override
    public boolean save(Expense expense, int categoryN) {
        return false;
    }

    @Override
    public boolean modify(Expense expense) {
        return false;
    }
} // end class

