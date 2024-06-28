package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.spring.jdbc.IDao;

@Controller
public class MyController {
	
	@Autowired
	private IDao userDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "join";
	}
	
	@RequestMapping("/order")
	public String userlist(Model model) {
		model.addAttribute("order1",userDao.getOrder());
		return "order";
	}
}
