package com.ssafy.blog.board.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class Reboard extends Board {

    private int reboardNo;
    private int groupNo;
    private int depth;
    private int step;
    private int parentNo;
    private int reply;

}
