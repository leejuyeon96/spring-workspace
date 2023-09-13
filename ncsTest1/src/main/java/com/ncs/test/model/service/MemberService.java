package com.ncs.test.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.test.model.dao.MemberDAO;
import com.ncs.test.model.vo.Member;

@Service
public class MemberService implements MemberServiceImpl{
	
	@Autowired
	private MemberDAO dao;

	@Override
	public Member login(Member vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}	

	

}
