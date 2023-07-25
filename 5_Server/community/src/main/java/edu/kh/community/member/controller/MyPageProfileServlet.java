package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.community.common.MyRenamePolicy;
import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/myPage/profile")
public class MyPageProfileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 메인 페이지 -> 프로필 이미지 클릭
		// 마이 페이지 -> 프로필 클릭
		
		String path = "/WEB-INF/views/member/myPage-profile.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			// 포로필 이미지 업로드 -> 변경
			
			// System.out.println( req.getParameter("profileImage")); // null
			
			// 파라미터가 얻어와지지 않는 이유
			// 1. enctype = "multipart/form-data" -> 인코딩 안되어있어 파라미터가 인지되지 않음
			// 2. input type="file" -> 파일 형태 데이터
			
			// --> multipart/form-data 형식의 요청을 처리할 수 있는 전용 request 객체가 필요
			
			// --> MultipartRequest  (cos.jar 라이브러리 이용 -  http://www.servlets.com/)
			// 파일 업로드 라이브러리
			
			// *****************  MultipartRequest 사용을 위한 준비 단계 *****************
			
			// 1. 업로드되는 파일크기의 전체 합을 지정(byte지정)
			int maxSize = 1024 * 1024 * 20; 
			// 1KB  1MB   20MB
			
			// 2. 업로드 되는 파일이 어디에 저장될지 경로 지정
			//		-> 서버 컴퓨터 내부 폴더(★★절대경로★★)
			
			// 2-1. server option 확인
			// servers -> 서버 설정 선택 -> Overview -> server options
			// -> Serve Modules Without Publishing 체크
			//	  (업로드 되는 파일이 webapp 폴더 내부에 저장될수 있음)
			
			// 2-2. memberProfile 폴더까지의 절대 경로 얻어오기
			
			HttpSession session = req.getSession(); // session 얻어오는 것은 지장없음(사용 가능)
			
			// 최상위 경로("/" == webapp 폴더)의 컴퓨터상의 실제 절대 경로를 얻어옴.
			String root = session.getServletContext().getRealPath("/");
			// C:\workspace\5_Server\community\src\main\webapp
			
			// 실제 파일이 저장되는 폴더의 경로
			String folderPath = "/resources/images/memberProfile/";
			
			// memberProfile 폴더 까지의 절대 경로
			String filePath = root + folderPath;
			
			// 3. 저장되는 파일의 파일명 중복 방지를 위한 파일명 변경 규칙
			// -> cos.jar에서 제공하는 FileRenamePolicy 인터페이스 상속 클래스 생성
			// --> myRenamePolicy 클래스 생성
			
			// 4. 파일 이외의 파라미터들의 문자 인코딩 지정
			String encoding = "UTF-8";
			
			// 5. MultipartRequest 생성
			// ***** (중요) *****
			// MultipartRequest 객체가 생성됨과 동시에 지정된 경로에
			// 지정된 파일명 변경 정책에 맞게 이름이 바뀐 파일이 저장(서버 업로드)된다.
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
			// 프로필 이미지 변경 Service 호출 시 필요한 값
			// 1) 로그인한 회원의 회원 번호
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			
			// 2) 업로드된 프로필 이미지의 웹 접근 경로(folderPath + 변경된 파일명)
			
			// getOriginalFileName("input type='file'의 name 속성 값")
			// -> 원본 파일명
			// System.out.println(mpReq.getOriginalFileName("profileImage"));
			
			// getFilestystemName("inptu type='file'의 name 속성 값")
			// -> 변경된 파일명
			System.out.println(mpReq.getFilesystemName("profileImage"));
			
			String profileImage = folderPath + mpReq.getFilesystemName("profileImage"); 
			
			// 프로필 이미지 변경 Service 호출 후 결과 반환 받기
			MemberService service = new MemberService();
			
			int result = service.updateProfileImage(memberNo, profileImage);
		
			
			if(result > 0) { // 성공
				session.setAttribute("message", "이미지 변경 완료!");
				
				// DB의 프로필 이미지 정보는 변경되었으나
				// Session에 저장된 로그인 정보 중 프로필 이미지는 변경되지않음
				// -> 동기화 작업 진행 (내 정보 수정 참고)
				
				loginMember.setProfileImage(profileImage); // 세션의 값이 변경된다
				
			} else { // 실패
				session.setAttribute("message", "이미지 변경 실패!");
				
			}
			
			// 성공/실패 관계 없이 프로필 화면 재요청(redirect)
			// /member/myPage/profile (POST)
			
			resp.sendRedirect("profile"); // 상대경로 (GET)
			
			//resp.sendRedirect(req.getContextPath()+"/member/myPage/profile");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
