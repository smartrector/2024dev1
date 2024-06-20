package com.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "params";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest httpServletRequest,Model model) {
		String name = httpServletRequest.getParameter("name");
		String id = httpServletRequest.getParameter("id");
		
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		return "index";
	}
}
