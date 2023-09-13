package com.ncs.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.test.model.service.MemberService;
import com.ncs.test.model.vo.Member;

@Controller
public class MemberController {
	 
	@Autowired
	private MemberService service;
	
	@RequestMapping("/login")
	public String memberLogin(String memberId, String memberPwd, Model model) {
		Member vo = new Member();
		System.out.println(memberPwd);
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		
		Member member = service.login(vo);
		
		model.addAttribute("loginMember",member);
		if(member != null)
		{
			return "index";
		}
		
		return "errorPage";
	}
	
	
}
