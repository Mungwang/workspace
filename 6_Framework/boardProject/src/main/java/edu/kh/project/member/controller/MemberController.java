package edu.kh.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 요청/응답 클래스 + bean 등록 (bean : Spring이 관리하는 객체)
@RequestMapping("/member") // 공통된 주소 앞부분 작성
						   // member로 시작하는 요청은 해당 컨트롤러에서 처리
public class MemberController {
	
	// 로그인 	: /member/login
	// 로그아웃 	: /member/logout 
	
	

}
