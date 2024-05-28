package com.ssafy.blog.admin.controller;

import com.ssafy.blog.admin.model.BoardList;
import com.ssafy.blog.admin.model.BoardMenus;
import com.ssafy.blog.admin.model.BoardType;
import com.ssafy.blog.admin.model.Category;
import com.ssafy.blog.admin.model.service.BoardAdminService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/board")
@Slf4j
public class BoardAdminController {

    private final BoardAdminService boardAdminService;

    public BoardAdminController(BoardAdminService boardAdminService) {
        this.boardAdminService = boardAdminService;
    }

    @GetMapping("/category/list")
    public ResponseEntity<?> listCategory() {
        log.info("=================================== listCategory");
        try {
            List<Category> categories = boardAdminService.listCategory();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            return ResponseEntity.ok().headers(headers).body(categories);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @PostMapping("/category/create")
    public ResponseEntity<?> createCategory(@RequestBody Map<String, String> category) {
        log.info("=================================== createCategory categoryName : {}", category.get("cname"));
        try {
            boardAdminService.createCategory(category.get("cname"));
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/board/type")
    public ResponseEntity<?> listBoardType() {
        log.info("=================================== listBoardType");
        try {
            List<BoardType> categories = boardAdminService.listBoardType();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            return ResponseEntity.ok().headers(headers).body(categories);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @PostMapping("/board/create")
    public ResponseEntity<?> createBoard(@RequestBody BoardList boardList) {
        log.info("=================================== createBoard boardList : {}", boardList);
        try {
            boardAdminService.createBoard(boardList);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/board/menu")
    public ResponseEntity<?> listBoardMenus() {
        log.info("=================================== listBoardMenus");
        try {
            List<BoardMenus> menus = boardAdminService.listBoardMenus();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            return ResponseEntity.ok().headers(headers).body(menus);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<?> exceptionHandling(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body("[Error] : " + e.getMessage());
    }
}
