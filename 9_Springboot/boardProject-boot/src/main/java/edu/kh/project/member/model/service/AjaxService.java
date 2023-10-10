package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface AjaxService {

	
	/** 이메일로 닉네임조회 service
	 * @param email
	 * @return nickname
	 */
	String selectNickname(String email);

	/** 닉네임으로 전화번호 조회 service
	 * @param inputNickname
	 * @return memberTel
	 */
	String selectMemberTel(String nickname);

	/** 이메일 중복검사 service
	 * @param email
	 * @return count
	 */
	int dupCheckEmail(String email);

	/** 닉네임 중복 검사 service
	 * @param nickname
	 * @return
	 */
	int dupCheckNickname(String nickname);

	/** 이메일로 회원 정보조회 service
	 * @param email
	 * @return
	 */
	Member selectMember(String email);

	/** 이메일이 일부라도 일치하는 모든 회원 조회
	 * @param input
	 * @return
	 */
	List<Member> selectMemberList(String input);


}
