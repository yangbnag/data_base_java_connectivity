package com.jdbc.basic.account.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화 생성자
@Builder

public class ExpenseCategory {
    private String outCaSerialNum;
    private String outCaDetail;
    private String outCategoryNum;
}
