package com.study.spring.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/")
	public String root() {
		return "menu";
	}

	@RequestMapping("/insert") // insert?username=han&content=con
	public String insert(@RequestParam("username") String username, Model model) {

//		Member user = new Member();
//		user.setUsername(username);
//		user.setCreateDate(LocalDate.now());

		Member user = Member.builder()
				.username(username)
				.createDate(LocalDate.now())
				.build();

		Member result = memberService.insert(user);

		model.addAttribute("member", result);

		return "insert";

	}

	@RequestMapping("/selectAll")
	public String selectall(Model model) {
		List<Member> result = memberService.selectAll();
		model.addAttribute("members", result);
		return "selectAll";
	}

	@RequestMapping("/select") // select?id=1
	public String select(@RequestParam("id") Long id, Model model) {
		Optional<Member> result = memberService.select(id);

		if (result.isPresent()) {
			model.addAttribute("member", result.get());
		} else {
			model.addAttribute("member", null);
		}

		return "select";
	}

	@RequestMapping("/delete") // delete?id=1
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		return "delete";
	}

	@RequestMapping("/update")
	public String update(
			@RequestParam("id") Long id, 
			@RequestParam("username") String username, 
			Model model) {

		Member user = Member.builder()
				.id(id)
				.username(username)
				.createDate(LocalDate.now())
				.build();
		Member result = memberService.update(user);

		System.out.println(result);
		model.addAttribute("member", result);

		return "update";
	}

}
