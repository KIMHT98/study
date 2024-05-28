-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema season
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema season
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `season` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `season` ;

-- -----------------------------------------------------
-- Table `season`.`board_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`board_type` ;

CREATE TABLE IF NOT EXISTS `season`.`board_type` (
  `btype` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '게시판 형식 코드',
  `btype_name` VARCHAR(50) NULL COMMENT '게시판 형식 이름',
  PRIMARY KEY (`btype`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`category` ;

CREATE TABLE IF NOT EXISTS `season`.`category` (
  `ccode` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '카테고리 코드',
  `cname` VARCHAR(50) NOT NULL COMMENT '카테고리 이름',
  PRIMARY KEY (`ccode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`.`board_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`board_list` ;

CREATE TABLE IF NOT EXISTS `season`.`board_list` (
  `bcode` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '게시판 코드(번호)',
  `bname` VARCHAR(50) NOT NULL COMMENT '게시판 이름',
  `ccode` INT UNSIGNED NULL COMMENT '카테고리 코드',
  `btype` INT UNSIGNED NULL COMMENT '게시판 형식 코드',
  PRIMARY KEY (`bcode`),
  INDEX `board_list_to_type_fk_idx` (`btype` ASC) VISIBLE,
  INDEX `board_list_to_category_fk_idx` (`ccode` ASC) VISIBLE,
  CONSTRAINT `board_list_to_type_fk`
    FOREIGN KEY (`btype`)
    REFERENCES `season`.`board_type` (`btype`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `board_list_to_category_fk`
    FOREIGN KEY (`ccode`)
    REFERENCES `season`.`category` (`ccode`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`users` ;

CREATE TABLE IF NOT EXISTS `season`.`users` (
  `user_id` VARCHAR(16) NOT NULL,
  `user_name` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(255) NULL,
  `join_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `role` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0 : 일반사용자, 100 : 관리자',
  PRIMARY KEY (`user_id`));


-- -----------------------------------------------------
-- Table `season`.`board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`board` ;

CREATE TABLE IF NOT EXISTS `season`.`board` (
  `article_no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '글번호',
  `user_id` VARCHAR(16) NOT NULL COMMENT '작성자 아이디',
  `subject` VARCHAR(100) NOT NULL COMMENT '글제목',
  `content` TEXT NOT NULL COMMENT '글내용',
  `hit` INT NULL DEFAULT 0 COMMENT '조회수',
  `register_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성일(시각)',
  `bcode` INT UNSIGNED NOT NULL COMMENT '게시판 코드(번호)',
  PRIMARY KEY (`article_no`),
  INDEX `board_to_list_fk_idx` (`bcode` ASC) VISIBLE,
  INDEX `board_to_user_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `board_to_list_fk`
    FOREIGN KEY (`bcode`)
    REFERENCES `season`.`board_list` (`bcode`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `board_to_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `season`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`.`reboard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`reboard` ;

CREATE TABLE IF NOT EXISTS `season`.`reboard` (
  `reboard_no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '답변게시판 일련번호',
  `article_no` INT UNSIGNED NOT NULL COMMENT '글번호',
  `group_no` INT NULL COMMENT '그룹번호',
  `depth` INT NULL COMMENT '들여쓰기',
  `step` INT NULL COMMENT '답변글 정렬',
  `parent_no` INT NULL COMMENT '원글번호',
  `reply` INT NULL DEFAULT 0 COMMENT '답변갯수',
  PRIMARY KEY (`reboard_no`),
  INDEX `reboard_to_board_fk_idx` (`article_no` ASC) VISIBLE,
  CONSTRAINT `reboard_to_board_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `season`.`board` (`article_no`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`.`album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`album` ;

CREATE TABLE IF NOT EXISTS `season`.`album` (
  `album_no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '사진게시판 일련번호',
  `article_no` INT UNSIGNED NOT NULL COMMENT '글번호',
  `save_folder` VARCHAR(8) NULL COMMENT '저장 폴더',
  `original_picture` VARCHAR(50) NULL COMMENT '원본 사진 이름',
  `save_picture` VARCHAR(50) NULL COMMENT '실 저장 사진 이름',
  PRIMARY KEY (`album_no`),
  INDEX `album_to_board_fk_idx` (`article_no` ASC) VISIBLE,
  CONSTRAINT `album_to_board_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `season`.`board` (`article_no`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`.`bbs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`bbs` ;

CREATE TABLE IF NOT EXISTS `season`.`bbs` (
  `bbs_no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '자료실 일련번호',
  `article_no` INT UNSIGNED NOT NULL COMMENT '글번호',
  `save_folder` VARCHAR(8) NULL COMMENT '저장 폴더',
  `original_file` VARCHAR(50) NULL COMMENT '원본 파일 이름',
  `save_file` VARCHAR(50) NULL COMMENT '실 저장 파일 이름',
  `file_size` DOUBLE NULL COMMENT '파일 사이즈',
  PRIMARY KEY (`bbs_no`),
  INDEX `bbs_to_board_fk_idx` (`article_no` ASC) VISIBLE,
  CONSTRAINT `bbs_to_board_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `season`.`board` (`article_no`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `season`.`memo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `season`.`memo` ;

CREATE TABLE IF NOT EXISTS `season`.`memo` (
  `memo_no` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '댓글 일련번호',
  `article_no` INT UNSIGNED NOT NULL COMMENT '글번호',
  `user_id` VARCHAR(16) NOT NULL COMMENT '작성자 아이디',
  `mcontent` VARCHAR(200) NOT NULL COMMENT '댓글 내용',
  `memo_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '댓글 작성 시각',
  PRIMARY KEY (`memo_no`),
  INDEX `memo_to_board_fk_idx` (`article_no` ASC) VISIBLE,
  CONSTRAINT `memo_to_board_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `season`.`board` (`article_no`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
