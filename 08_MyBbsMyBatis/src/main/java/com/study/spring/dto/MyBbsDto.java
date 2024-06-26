package com.study.spring.dto;

import lombok.Data;

@Data
public class MyBbsDto {
	private int id;
	private String writer;
	private String title;
	private String content;
}
