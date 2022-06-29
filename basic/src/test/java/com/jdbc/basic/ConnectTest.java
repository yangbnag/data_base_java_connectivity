package com.jdbc.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectTest {

    @Test
    // Assertion(단언하다)
    @DisplayName("데이터베이스 연결이 정상 수행되어야 한다.") // 테스트의 목적
    void connectTest() { // void 메서드 만들기. 이름은 마음대로
        Connection conn = Connect.makeConnection();

        if(conn != null) {
            System.out.println("연결 성공!");
        } else {
            System.out.println("연결 실패!");
        }

        assertNotNull(conn); // 나는 conn이 null 아닌것을 단언한다.
    }
}