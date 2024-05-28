package com.ssafy.blog.board.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@ApiModel(value = "BoardDto : 게시글정보", description = "게시글의 상세 정보를 나타낸다.")
public class Board {

    //    @ApiModelProperty(value = "글번호")
    private int articleNo;
    //    @ApiModelProperty(value = "작성자 아이디")
    private String userId;
    //    @ApiModelProperty(value = "작성자 이름")
    private String userName;
    //    @ApiModelProperty(value = "글제목")
    private String subject;
    //    @ApiModelProperty(value = "글내용")
    private String content;
    //    @ApiModelProperty(value = "조회수")
    private int hit;
    //    @ApiModelProperty(value = "작성일")
    private String registerTime;
    //    @ApiModelProperty(value = "게시판번호")
    private String bcode;

}

