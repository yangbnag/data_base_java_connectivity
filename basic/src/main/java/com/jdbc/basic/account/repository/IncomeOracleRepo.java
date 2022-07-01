package com.jdbc.basic.account.repository;

import com.jdbc.basic.Connect;
import com.jdbc.basic.account.domain.Income;
import com.jdbc.basic.score.domain.Score;


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

        String sql = "SELECT in_serial_nm, TO_CHAR(in_date,'yy-mm-dd') in_date, in_detail, in_amt FROM income ORDER BY in_date";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Income i = new Income(
                        rs.getInt("in_serial_nm")
                        , rs.getString("in_date")
                        , rs.getString("in_detail")
                        , rs.getInt("in_amt")
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

        String sql = " SELECT in_serial_nm, TO_CHAR(in_date,'yy-mm-dd') in_date, in_detail, in_amt" +
                " FROM income A" +
                " WHERE A.category_num = ?";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, whereNum);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Income i = new Income(
                        rs.getInt("in_serial_nm")
                        , rs.getString("in_date")
                        , rs.getString("in_detail")
                        , rs.getInt("in_amt")
                );
                incomeMap.put(i.getInSerial(), i);
            }
            return incomeMap;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    // 내역을 삭제하는 메서드
    @Override
    public boolean remove(int whereNum) {
        String sql = "DELETE FROM income A WHERE a.in_serial_nm = ? ";

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

    // 수입 내역의 특정 행을 추출
    @Override
    public Income findOne(int whereNum) {
        String sql = "SELECT * FROM income A WHERE a.in_serial_nm = ?";

        try (Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, whereNum);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                Income i = new Income(

                        rs.getInt("in_serial_nm")
                        , rs.getString("in_date")
                        , rs.getString("in_detail")
                        , rs.getInt("in_amt")
                );
                return i;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 새로운 수입내역을 입력
    @Override
    public boolean save(Income income, int categoryN) {
        String sql = "INSERT INTO income (in_serial_nm, in_date, in_detail, in_amt, category_num) \n" +
                "VALUES (seq_income.nextval, ? , ? , ? , ?)";

        try (Connection conn = Connect.makeConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, income.getInDate());
            pstmt.setString(2, income.getInDetail());
            pstmt.setInt(3, income.getInAmount());
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
    public boolean modify(Income income) {
        String sql = "UPDATE income SET " +
                "in_date = ?, " +
                "in_detail = ?," +
                "in_amt = ? " +
                "WHERE in_serial_nm = ?";

        try (Connection conn = Connect.makeConnection()) {

            conn.setAutoCommit(false); // 자동커밋 설정 끄기

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, income.getInDate());
            pstmt.setString(2, income.getInDetail());
            pstmt.setInt(3, income.getInAmount());
            pstmt.setInt(4,income.getInSerial());

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


    // 수입 금액 전체 구하기
    @Override
    public String getClassSum() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT TO_CHAR(SUM(in_amt),'L999,999,999') AS amt_cls\n")
                .append("FROM income");

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

} // end class

