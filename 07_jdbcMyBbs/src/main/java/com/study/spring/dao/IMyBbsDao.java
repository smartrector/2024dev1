package com.study.spring.dao;

import java.util.List;
import com.study.spring.dto.MyBbsDto;

public interface IMyBbsDao {
	public List<MyBbsDto> listDao();
	public MyBbsDto viewDao(String id);
//	public int writeDao(String writer,String title,String content);
//	public int deleteDao(String id);
}
