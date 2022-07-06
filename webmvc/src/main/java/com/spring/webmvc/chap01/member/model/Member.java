package com.spring.webmvc.chap01.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Member {

    private static int sequence; // 일련번호
    private int userNum; // 일련번호 자동생성
    private String account;
    private String password;
    private String userName;

    public Member(){
        this.userNum = ++sequence; // sequence 초기값 0
                                  // static으로 객체 생성될때마다 초기화 되는 것을 방지
    }

    public Member(String account, String password, String userName) {
        this(); // 기본 생성자 호출하여 userNum 초기화.
        this.account = account;
        this.password = password;
        this.userName = userName;
    }
}
