package com.jdbc.basic.account.repository;

import com.jdbc.basic.Connect;
import com.jdbc.basic.account.domain.Income;
import com.jdbc.basic.score.domain.Score;
import com.jdbc.basic.score.repository.ScoreRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Oracle DBMS에 성적 정보를 CRUD하는 클래스
public class incomeOracleRepo implements incomeRepository {

    @Override
    public Map<Integer, Income> findAll() {
        Map<Integer, Income> IncomeMap = new HashMap<>();

        String sql = "SELECT * FROM income ORDER BY inSerialNM";

        try(Connection conn = Connect.makeConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Income i = new Income(
                        rs.getInt("d")
                )
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}