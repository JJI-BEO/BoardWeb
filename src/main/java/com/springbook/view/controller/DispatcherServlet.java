package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public DispatcherServlet() {
		super();
	}
	
	
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String uri = request.getRequestURI(); // 현재 주소값 가져오기.http://localhost:9999/BoardWeb3/getBoard.do
		String path = uri.substring(uri.lastIndexOf("/")); // getBoard.do를 가져옴
		System.out.println("디스패처 -----> path : " + path);
		
		
		Controller ctrl = handlerMapping.getController(path);
		
			System.out.println("ctrl : " + ctrl);
		
		String viewName = ctrl.handleRequest(request, response);
		System.out.println("디스패처 -----> viewName : " + viewName);
		
		
		String view = null;
		
		//contains 문자열에 포함되어있는지 확인
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
			
			response.sendRedirect(view);
		}else {
			view = viewName;
			response.sendRedirect(view);
		}
		
		
//		String p = request.getContextPath();
//		System.out.println(p + "=====================");
		
//		if (path.equals("/login.do")) {
//			System.out.println("로그인 처리");
//			// 1. 사용자 입력 정보 추출
//			String id = request.getParameter("id");
//			String password = request.getParameter("password");
//
//			// 2. DB 연동 처리
//
//			UserVO vo = new UserVO();
//			vo.setId(id);
//			vo.setPassword(password);
//
//			UserDAO userDAO = new UserDAO();
//			UserVO user = userDAO.getUser(vo);
//
//			// 3. 화면 네비게이션
//
//			if (user != null) {
//				response.sendRedirect("getBoardList.do");
//			} else {
//				response.sendRedirect("login.jsp");
//			}
//		} else if (path.equals("/logout.do")) {
//			System.out.println("로그아웃 처리");
//			
//			HttpSession session = request.getSession();
//			
//			session.invalidate();
//			
//			response.sendRedirect("login.jsp");
//			
//		} else if (path.equals("/insertBoard.do")) {
//			System.out.println("글 등록 처리");
//
//			request.setCharacterEncoding("UTF-8");
//			String title = request.getParameter("title");
//			String writer = request.getParameter("writer");
//			String content = request.getParameter("content");
//
//			BoardVO vo = new BoardVO();
//			vo.setTitle(title);
//			vo.setWriter(writer);
//			vo.setContent(content);
//
//			BoardDAO boardDAO = new BoardDAO();
//			boardDAO.insertBoard(vo);
//
//			response.sendRedirect("getBoardList.do");
//
//		} else if (path.equals("/UpdateBoard.do")) {
//			System.out.println("글 수정 처리");
//
//			request.setCharacterEncoding("UTF-8");
//			String title = request.getParameter("title");
//			String writer = request.getParameter("writer");
//			String content = request.getParameter("content");
//			String seq = request.getParameter("seq");
//
//			BoardVO vo = new BoardVO();
//			vo.setTitle(title);
//			vo.setWriter(writer);
//			vo.setContent(content);
//			vo.setSeq(Integer.parseInt(seq));
//
//			BoardDAO boardDAO = new BoardDAO();
//			boardDAO.updateBoard(vo);
//
//			response.sendRedirect("getBoardList.do");
//
//		} else if (path.equals("/deleteBoard.do")) {
//			System.out.println("글 삭제 처리");
//
//			String seq = request.getParameter("seq");
//
//			BoardVO vo = new BoardVO();
//			vo.setSeq(Integer.parseInt(seq));
//
//			BoardDAO boardDAO = new BoardDAO();
//			boardDAO.deleteBoard(vo);
//
//			response.sendRedirect("getBoardList.do");
//		} else if (path.equals("/getBoard.do")) {
//			System.out.println("글 상세 조회 처리");
//
//			String seq = request.getParameter("seq");
//			BoardVO vo = new BoardVO();
//			vo.setSeq(Integer.parseInt(seq));
//			BoardDAO boardDAO = new BoardDAO();
//			BoardVO board = boardDAO.getBoard(vo);
//
//			HttpSession session = request.getSession();
//			session.setAttribute("board", board);
//
//			response.sendRedirect("getBoard.jsp");
//
//		} else if (path.equals("/getBoardList.do")) {
//			System.out.println("글 목록 검색 처리");
//
//			BoardDAO boardDAO = new BoardDAO();
//			List<BoardVO> boardList = boardDAO.getBoardList();
//			HttpSession session = request.getSession();
//			session.setAttribute("board", boardList);
//			response.sendRedirect("getBoardList.jsp");
//		}
	}

}
