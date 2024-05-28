package com.ssafy.blog.admin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardMenus {

    private int ccode;
    private String cname;
    private List<BoardList> boardLists;

}
