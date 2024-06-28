package com.study.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.dao.IMyBbsDao;
import com.study.spring.dto.MyBbsDto;


@Service
public class MyBbsSrevice implements IMyBbsService {

	@Autowired
	IMyBbsDao dao;
	
	@Override
	public List<MyBbsDto> list(){
		return dao.listDao();
	}
	
	@Override
	public MyBbsDto view(String id) {
		return dao.viewDao(id);
	};
	
	@Override
	public int write(String writer,String title,String content) {
		return dao.writeDao(writer, title, content);
	};
	
	@Override
	public int delete(@Param("_id") String id) {
		return dao.deleteDao(id);
	};
}
