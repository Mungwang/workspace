package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/selectOne")
public class SelectOneServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기
		
		String memberEmail = req.getParameter("memberEmail");
		
		
		try {
			MemberService service = new MemberService();
			
			// 회원 정보 조회 Service 호출 후 결과 반환받기
			
		Member member = service.selectOne(memberEmail);
			
		// resp.getWriter().print(member);
		
		// print 매개변수로 참조형 변수가 작성되면
		// 해당 참조형 변수의 toString() 메소드를 자동 호출해서 출력
		
		// **** Java 객체를 Javascript 객체로 변환하여 응답(출력) ****
		
		// Java 객체 -> Javascript 객체 형태의 문자열(JSON) -> Javascript 객체
			
		String str = "{\"memberNickname\" :\""+ member.getMemberNickname()+"\"}";
		
		resp.getWriter().print(str);
		
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
