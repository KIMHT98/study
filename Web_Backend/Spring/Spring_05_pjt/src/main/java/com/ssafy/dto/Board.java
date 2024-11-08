package com.ssafy.dto;

import java.util.Date;

public class Board {
	private static int no = 1;//클래스 변수
	private int id;
	private String videoId;
	private String title,writer,content,regDate;
	private int viewCnt;
	
	public Board() {
		
	}

	public Board(String title, String writer, String content) {
		this.id = no++;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = new Date().toString();
	}

	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Board.no = no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
	
	
	
}
