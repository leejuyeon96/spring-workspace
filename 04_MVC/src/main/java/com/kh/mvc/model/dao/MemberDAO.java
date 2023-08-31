package com.kh.mvc.model.dao;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kh.mvc.model.vo.Member;
@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	public int registerMember(Member vo) {
		return sqlsession.insert("memberMapper.registerMember", vo);
	}
	
	public Member login(Member vo) {
		return sqlsession.selectOne("memberMapper.login", vo);
	}
	
	public List<Member> showAllMember() {
		return sqlsession.selectList("memberMapper.showAllMember");
	}
	public List<Member> findMember(String keyword) {
		return sqlsession.selectList("memberMapper.findMember", keyword);
	}
	public int updateMember(Member vo) {
		return sqlsession.update("memberMapper.updateMember", vo);
	}
	
	/*
	 *
	 * showAllMember
	 * findMember -> 파라미터 : String keyword, return List<Member>
	 * login -> 파라미터 : Member vo
	 * updateMember -> 파라미터 : Member vo
	 *
	 */
}