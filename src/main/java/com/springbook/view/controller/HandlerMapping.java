package com.springbook.view.controller;

import java.util.*;

import com.springbook.view.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new BoardListController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/UpdateBoard.do", new UpdateBoardController());
		mappings.put("/logout.do", new LogoutController());
		
		
	}
	
	public Controller getController(String path) {
		System.out.println("핸들러 맵핑 ----->" + "path값  :" + path );
		return mappings.get(path);
	}
}
