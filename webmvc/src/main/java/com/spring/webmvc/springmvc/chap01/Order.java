package com.spring.webmvc.springmvc.chap01;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    // =============== 요청 파라미터 받기 (Query Parameter) ============//
    // == 3. 커맨드 객체 이용하기

    private int oNum;
    private String goods;
    private int amout;
    private int price;
    private String req;
}
