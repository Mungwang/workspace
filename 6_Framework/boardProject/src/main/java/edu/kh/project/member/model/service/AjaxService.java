package edu.kh.project.member.model.service;

public interface AjaxService {

	
	/** 이메일로 닉네임조회 service
	 * @param email
	 * @return nickname
	 */
	String selectNickname(String email);

}
