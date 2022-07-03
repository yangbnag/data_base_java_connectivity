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


    //지출내역 전체 조회
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
    public String getClassSum() {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT TO_CHAR(SUM(out_amt),'L999,999,999') AS amt_cls\n")
                .append("FROM expense");

        try (Connection conn = Connect.makeConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("amt_cls").trim();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Expense> findCategory(int whereNum) {

        Map<Integer, Expense> expenseMap = new HashMap<>();

        String sql = "SELECT " +
                " A.out_serial_nm, TO_CHAR(A.out_date, 'yy-mm-dd') out_date, A.out_detail, A.out_amt " +
                " FROM expense A, expense_category B" +
                " WHERE a.category_num = b.out_ca_serial_nm" +
                " AND b.out_ca_serial_nm = ? ";

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
        String sql = "DELETE FROM expense WHERE out_serial_nm = ?";

        try (Connection conn = Connect.makeConnection()) {

            conn.setAutoCommit(false); // 자동 커밋 설정 끄기

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, whereNum);

            int result = pstmt.executeUpdate();

            if (result != 0) {
                conn.commit(); // 커밋 완료
                return true;
            } else {
                conn.rollback(); // 수정 실패 롤백
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Expense findOne(int whereNum) {
        String sql = "SELECT * FROM expense A WHERE out_serial_nm = ?";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, whereNum);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                Expense e = new Expense(

                        rs.getInt("out_serial_nm")
                        , rs.getString("out_date")
                        , rs.getString("out_detail")
                        , rs.getInt("out_amt")
                );
                return e;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean save(Expense expense, int categoryN) {
        String sql = "INSERT INTO expense (out_serial_nm, out_date, out_detail, out_amt, category_num) \n" +
                "VALUES (seq_expense.nextval, ?, ?, ?, ?)";

        try (Connection conn = Connect.makeConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, expense.getOutDate());
            pstmt.setString(2, expense.getOutDetail());
            pstmt.setInt(3, expense.getOutAmount());
            pstmt.setInt(4, categoryN);

            int result = pstmt.executeUpdate();

            if (result != 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modify(Expense expense) {
        String sql = "UPDATE expense SET " +
                "out_date = ?, " +
                "out_detail = ?," +
                "out_amt = ? " +
                "WHERE out_serial_nm = ?";

        try (Connection conn = Connect.makeConnection()) {

            conn.setAutoCommit(false); // 자동커밋 설정 끄기

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, expense.getOutDate());
            pstmt.setString(2, expense.getOutDetail());
            pstmt.setInt(3, expense.getOutAmount());
            pstmt.setInt(4,expense.getOutSerial());

            int result = pstmt.executeUpdate();

            if(result != 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
} // end class

