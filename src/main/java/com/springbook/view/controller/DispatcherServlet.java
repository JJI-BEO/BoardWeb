package com.springbook.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // http://localhost:9999/BoardWeb3/getBoard.do
		String path = uri.substring(uri.lastIndexOf("/")); //getBoard.do
		
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
		}else if (path.equals("/logout.do")) {
			
		}else if (path.equals("/insertBoard.do")) {
			
		}else if (path.equals("/updateBoard.do")) {
			
		}else if (path.equals("/deleteBoard.do")) {
			
		}else if (path.equals("/getBoard.do")) {
			
		}else if (path.equals("/getBoardList.do")) {
			
		}
			
		
		
				
	}
}
