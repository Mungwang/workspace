package edu.kh.project.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.service.BoardService;

@SessionAttributes({"loginMember"})
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	/* 목록 조회 : /board/1?cp=1 (cp : current page(현재페이지))
	 * 상세 조회 : /board/1/1500?cp=1
	 * 
	 * ** 컨트롤러 따로 생성 예정 ** 
	 * 삽입 : /board2/insert?code=1 ( code== BOARD_CODE, 게시판종류 )
	 * 수정 : /board2/update?code=1&no=1500 ( no == BOARD_NO, 게시글번호 )
	 * 삭제 : /board2/delete?code=1&no=1500
	 * 
	 */
	
	
	// @PathVariable
	// URL 경로에 있는 값을 매개변수로 이용할 수있게 하는 어노테이션
	
	// 게시글 목록 조회
	@GetMapping("/{boardCode}")
	public String selectBoardList(@PathVariable("boardCode") int boardCode) {
		
		// boardCode 확인
		System.out.println("boardCode : " +boardCode);
		return "board/boardList";
		
	}

}
