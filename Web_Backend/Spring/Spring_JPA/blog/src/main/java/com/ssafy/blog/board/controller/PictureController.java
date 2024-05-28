package com.ssafy.blog.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/picture")
//@Api("게시판 컨트롤러  API V1")
@Slf4j
public class PictureController {

    @GetMapping
    public ResponseEntity<?> listArticle(
            @RequestParam Map<String, String> map) {
        log.info("listArticle map - {}", map);
        return null;
    }
}
