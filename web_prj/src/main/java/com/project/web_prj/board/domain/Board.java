package com.project.web_prj.board.domain;

import lombok.*;

import java.util.Date;

@Setter @Getter @ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class Board {

    // DB 칼럼에 매칭시켜 필드를 만든다.
    private Long boardNo;
    private String writer;
    private String title;
    private String content;
    private Long viewCnt;
    private Date regDate;

}
