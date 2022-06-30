package com.jdbc.basic.account.domain;

import lombok.*;

@Setter @Getter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화 생성자
@Builder // 객체 생성시 생성자 역할을 대신

// 데이터베이스 income의 행 데이터를 저장할 객채
public class Income {

    private int inSerial ;
    private String inDate;
    private String inDetail;
    int inAmount;

    private String categoryNum;

    private int total;

    public Income(int inSerial, String inDate, String inDetail, int inAmount) {
        this.inSerial = inSerial;
        this.inDate = inDate;
        this.inDetail = inDetail;
        this.inAmount = inAmount;
    }

    @Override
    public String toString() {
        return  "일련번호 :" + inSerial + " " +"일자 : " + inDate + " " + "내역 :" + inDetail + " " +  "금액 : " + inAmount ;
    }
}
