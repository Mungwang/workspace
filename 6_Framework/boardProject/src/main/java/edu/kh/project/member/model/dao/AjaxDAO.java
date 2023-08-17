package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // DB연결 의미 + bean 등록
public class AjaxDAO {
	
	@Autowired // bean객체 중에서 타입이 같은 객체를 DI
	private SqlSessionTemplate sqlSession;

	
	public String selectNickname(String email) {
		
		return sqlSession.selectOne("ajaxMapper.selectNickname",email);
	}


	public String selectMemberTel(String nickname) {
		
		return sqlSession.selectOne("ajaxMapper.selectMemberTel",nickname);
	}


	public int dupCheckEmail(String email) {
		
		return sqlSession.selectOne("ajaxMapper.dupCheckEmail",email);
	}


	public int dupCheckNickname(String nickname) {
		
		return sqlSession.selectOne("ajaxMapper.dupCheckNickname",nickname);
	}
}
