package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.study.spring.service.IMyBbsService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MyController {
	
//	@Autowired
//	IMyBbsDao dao;
	
	@Autowired
	IMyBbsService bbs;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String listPage(Model model) {
		model.addAttribute("lists",bbs.list());
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request,Model model) {
		String sId = request.getParameter("id");
		model.addAttribute("dto",bbs.view(sId));
		return "view";
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		bbs.delete(request.getParameter("id"));
		return "redirect:list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		bbs.write(
				request.getParameter("writer"),
				request.getParameter("title"),
				request.getParameter("content")
				);
		
		return "redirect:list";
		
	}
	
	@RequestMapping("/writerForm")
	public String writerForm() {
		return "writerForm";
	}
}





