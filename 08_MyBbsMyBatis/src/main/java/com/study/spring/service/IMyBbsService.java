package com.study.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.study.spring.dto.MyBbsDto;


public interface IMyBbsService {
	public List<MyBbsDto> list();
	public MyBbsDto view(String id);
	public int write(String writer,String title,String content);
	public int delete(@Param("_id") String id);
}
