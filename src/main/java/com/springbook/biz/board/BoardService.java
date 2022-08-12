package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	//글 등록
	public void insertBoard(BoardVO vo); 
	//글 수정
	public void updateBoard(BoardVO vo); 
	//글 삭제
	public void deleteBoard(BoardVO vo); 
	//글 하나 상세조회
	public BoardVO getBoard(BoardVO vo); 
	//전체 조회
	public List<BoardVO> getBoardList();
		
}
