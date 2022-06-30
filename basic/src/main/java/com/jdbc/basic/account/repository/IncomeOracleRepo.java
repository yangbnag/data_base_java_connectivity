package com.jdbc.basic.account.repository;

import com.jdbc.basic.Connect;
import com.jdbc.basic.account.domain.Income;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

 // Oracle DBMS에 가계부의 수입 정보를 CRUD하는 클래스
public class IncomeOracleRepo implements IncomeRepository {

    // 카테고리 출력



    //수입내역 전체 조회
    @Override
    public Map<Integer, Income> findAll() {

        Map<Integer, Income> incomeMap = new HashMap<>();

        String sql = "SELECT * FROM income";

        try(Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Income i = new Income(
                        rs.getInt("in_serial_nm")
                        ,rs.getString("in_date")
                        ,rs.getString("in_detail")
                        ,rs.getInt("in_amt")
                );
                incomeMap.put(i.getInSerial(), i);
            }
            return incomeMap;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

     //수입 항목별 조회
     @Override
     public Map<Integer, Income> findCategory(int whereNum) {

         Map<Integer, Income> incomeMap = new HashMap<>();

         String sql = " SELECT * \n" +
                 " FROM income A\n" +
                 " WHERE A.category_num = ?";

         try(Connection conn = Connect.makeConnection()) {

             PreparedStatement pstmt = conn.prepareStatement(sql);

             pstmt.setInt(1,whereNum);

             ResultSet rs = pstmt.executeQuery();
             while(rs.next()) {
                 Income i = new Income(
                         rs.getInt("in_serial_nm")
                         ,rs.getString("in_date")
                         ,rs.getString("in_detail")
                         ,rs.getInt("in_amt")
                 );
                 incomeMap.put(i.getInSerial(), i);
             }
             return incomeMap;

         } catch (Exception e) {
             e.printStackTrace();
             return Collections.emptyMap();
         }
     }



     // 수입 금액 전체 구하기
     @Override
     public int getClassSum() {
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT SUM(in_amt) AS amt_cls\n")
                     .append("FROM income");

             try (Connection conn = Connect.makeConnection()){
                 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                 ResultSet rs = pstmt.executeQuery();

                 if(rs.next()) {
                     return rs.getInt("amt_cls");
                 }

             } catch (SQLException e) {
                 e.printStackTrace();
             }
             return 0;
         }

     } // end class

