package com.jdbc.basic.account.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화 생성자
@Builder

public class Expense {

    private int outSerial;
    private String outDate;
    private String outDetail;
    private int outAmount;
    private String outCategory;
    private int total;

    public Expense(int outSerial, String outDate, String outDetail, int outAmount) {
        this.outSerial = outSerial;
        this.outDate = outDate;
        this.outDetail = outDetail;
        this.outAmount = outAmount;
    }
    @Override
    public String toString() {
        return  "일련번호 :" + outSerial + " " +"일자 : " + outDate + " " + "내역 :" + outDetail + " " +  "금액 : " + outAmount ;
    }
}
