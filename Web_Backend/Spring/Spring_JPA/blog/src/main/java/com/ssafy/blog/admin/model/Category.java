package com.ssafy.blog.admin.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {

    private int ccode;
    private String cname;

}
