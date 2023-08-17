package edu.kh.project.member.model.service;

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


}
