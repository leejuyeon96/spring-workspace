package com.kh.practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PracticeController {
	
	@Autowired
	private PracticeService service;
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		List<Member> list = service.findMember(keyword);
		
		if(list.size()>0) {
			model.addAttribute("list", list);
			return "find_ok"
		}
		return "find_fail";
	}
	
	@RequestMapping("signUp")
	public String signUp(Member member) {
		
		service.registerMember(member);
		
		return "redirect:/"; 
	}
	@RequestMapping("signIn")
	public String signIn(Member vo, HttpSession session) {
		
		Member member = service.login(vo);
		
		if(member!=null) {
			session.setAttribute("vo", member);
		}
		return "login_result";
	}
	@
	public String allMember(Model model) {
		List<Member> list = service.showAllMember();
		model.addAttribute("list", list);
		
		return "find_ok";
				
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("vo")!=
	}
}
