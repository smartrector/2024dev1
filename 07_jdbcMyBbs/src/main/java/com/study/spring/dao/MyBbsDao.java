package com.study.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.List;
import com.study.spring.dto.MyBbsDto;

@Repository
public class MyBbsDao implements IMyBbsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<MyBbsDto> listDao(){
		
		String query = "select * from mybbs1 order by id desc";
		List<MyBbsDto> dtos = jdbcTemplate.query(
				query, new BeanPropertyRowMapper<>(MyBbsDto.class)
				);
		return dtos;
	}
	
	
	@Override
	public MyBbsDto viewDao(String id) {
		String query = "select * from mybbs1 where id = " + id;
		MyBbsDto dto = jdbcTemplate.queryForObject(
				query, new BeanPropertyRowMapper<>(MyBbsDto.class));
		
		return dto;
	}


}
