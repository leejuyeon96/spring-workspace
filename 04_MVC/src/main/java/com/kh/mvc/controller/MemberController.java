package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		System.out.println(keyword);
		
		//서비스 - 비즈니스 로직 처리!
		//--> list 값! 데이터 바인딩 -> Model!
	//	model.addAllAttribute("list", list);
		return "find_ok"; // 실패 - "find_fail"
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("signUp")
	public String signUp(Member member) {
		System.out.println(member);
		//비즈니스 로직
		return "redirect:/"; //바로 index.jsp로 넘어감
	}
	
	//login - 페이지 이동
	
	// signIn - 비즈니스 로직 포함 : 파라미터 값 -> HttpServletRequest request
	// -> return "login_result"
	//allMember - 비즈니스 로직 포함, 데이터바인딩 - Model
	//--> return "find_ok";
	
	//logout - 로그아웃 기능!
	
	//update - 페이지 이동

	//updateMember - 비즈니스 로직 포함 -> 파리미터 request 필요
}
