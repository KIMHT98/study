package com.ssafy.blog.admin.model.mapper;

import com.ssafy.blog.admin.model.BoardList;
import com.ssafy.blog.admin.model.BoardMenus;
import com.ssafy.blog.admin.model.BoardType;
import com.ssafy.blog.admin.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardAdminMapper {

    List<Category> listCategory();
    void createCategory(String categoryName);
    List<BoardType> listBoardType();
    void createBoard(BoardList boardList);
    List<BoardMenus> listBoardMenus();

}
