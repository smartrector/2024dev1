package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.dao.IMyBbsDao;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MyController {
	
	@Autowired
	IMyBbsDao dao;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String listPage(Model model) {
		model.addAttribute("lists",dao.listDao());
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request,Model model) {
		String sId = request.getParameter("id");
		model.addAttribute("dto",dao.viewDao(sId));
		return "view";
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		dao.deleteDao(request.getParameter("id"));
		return "redirect:list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		dao.writeDao(
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





