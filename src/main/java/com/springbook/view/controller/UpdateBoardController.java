package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 수정 처리");
		
					String title = request.getParameter("title");
					String writer = request.getParameter("writer");
					String content = request.getParameter("content");
					String seq = request.getParameter("seq");
		
					BoardVO vo = new BoardVO();
					vo.setTitle(title);
					vo.setWriter(writer);
					vo.setContent(content);
					vo.setSeq(Integer.parseInt(seq));
		
					BoardDAO boardDAO = new BoardDAO();
					boardDAO.updateBoard(vo);
		
		
		return "getBoardList.do";
	}

}
