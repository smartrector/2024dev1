package com.study.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MyDTO> list() {
		String query = "select * from mybbs1 order by id desc";
		List<MyDTO> list = jdbcTemplate.query(
				query, new BeanPropertyRowMapper<>(MyDTO.class)
				);
		return list;
	}

}
