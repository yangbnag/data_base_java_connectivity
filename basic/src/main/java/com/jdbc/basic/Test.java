package com.jdbc.basic;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {

        Connection conn = Connect.makeConnection();
        if(conn != null) {
            System.out.println("연결 성공!");
        } else {
            System.out.println("연결 실패!");
        }

    }
}
