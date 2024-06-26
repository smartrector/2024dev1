package com.study.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.spring.dto.MyBbsDto;



@Mapper
public interface IMyBbsDao {
	public List<MyBbsDto> listDao();
	public MyBbsDto viewDao(String id);
	public int writeDao(String writer,String title,String content);
	public int deleteDao(@Param("_id") String id);
}
