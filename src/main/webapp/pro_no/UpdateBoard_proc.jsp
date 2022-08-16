<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.springbook.biz.board.impl.*" %>
<%@page import="com.springbook.biz.board.*" %>
<%
request.setCharacterEncoding("UTF-8");
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
String seq = request.getParameter("seq");


System.out.println(writer + "업데이트jsp");

BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setWriter(writer);
vo.setContent(content);
vo.setSeq(Integer.parseInt(seq));

BoardDAO boardDAO = new BoardDAO();
boardDAO.updateBoard(vo);

response.sendRedirect("getBoardList.jsp");
%>