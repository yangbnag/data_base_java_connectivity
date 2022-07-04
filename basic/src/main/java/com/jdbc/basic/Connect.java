package com.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;

// Oracle DB 연결
public class Connect {
    // 데이터 베이스 연결을 위한 정보 저장

    private final static String ACCOUNT = "sqld"; //  계정명 데이터 베이스 파일명
    private final static String PASSWORD = "1234"; // 비밀번호 [테스트를 위해 비밀번호를 틀리게 초기화]

    // 내가 사용할 데이터베이스가 어느 컴퓨터에 있는지 알려줘야 함.
    // 데이터 베이스의 위치정보(DB URL) - DB회사마다 패턴이 다름
    private final static String URL = "jdbc:oracle:thin:@192.168.25.18:1521:XE"; // 오라클에 DB URL 패턴을 확인 [찾아봐야함. 인터넷]
    // hr/hr : 계정명 / 계정 비밀번호 //localhost : 내 컴퓨터의 IP // 포트주소
    // localhost 데이터베이스가 클라우드에 있으면 클라우드 주소를 적어야 함.

    // 데이터베이스 접속에 쓸 드라이버 클래스 - DB회사마다 다름
    private final static String DRIVER = "oracle.jdbc.driver.OracleDriver"; // oracle.jdbc.driver. : 패키지명   OracleDriver : 클래스 이름

    // DB 연결 메서드
    public static Connection makeConnection() {

        try {
            // 1. 드라이버 클래스를 동적 로딩
            Class.forName(DRIVER);

            // 2. 연결정보를 담아 연결 객체를 생성
            Connection conn = DriverManager.getConnection(URL, ACCOUNT, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}