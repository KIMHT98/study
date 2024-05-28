package com.ssafy.blog.admin.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class BoardList extends Category {

    private int bcode;
    private String bname;
    private int btype;
    private String control;

}
