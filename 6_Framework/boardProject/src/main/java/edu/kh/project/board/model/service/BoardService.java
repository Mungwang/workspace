package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	/** 게시판 종류 목록 조회
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);
	
	/** 게시글 상제 조회
	 * @param map
	 * @return
	 */
	Board selectBoard(Map<String, Object> map);

	/** 좋아요 확인 조회
	 * @param map
	 * @return
	 */
	int boardLikeCheck(Map<String, Object> map);

	/** 좋아요 처리 서비스
	 * @param paramMap
	 * @return
	 */
	int like(Map<String, Integer> paramMap);

	/** 조회수 증가 서비스
	 * @param boardNo
	 * @return
	 */
	int updateReadCount(int boardNo);

}
