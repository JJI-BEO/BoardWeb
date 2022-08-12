<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.springbook.biz.board.impl.*"%>
<%@page import="com.springbook.biz.board.*"%>

<%
	BoardVO board = (BoardVO) session.getAttribute("board");

	/* String seq = request.getParameter("seq");
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="Logout_proc.jsp">Log-out</a>
		<hr>
		<form action="UpdateBoard.do" method="post">
			<input type="hidden" name="seq" value="<%=board.getSeq()%>">
			<table border="1" cellpadding="0" cellspacing="0">

				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"
						value="<%=board.getTitle()%>"></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><input type="hidden"
						value="<%=board.getWriter()%>" name="writer"> <%=board.getWriter()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea rows="10" cols="40" name="content">
						<%=board.getContent()%>
						</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성일</td>
					<td align="left"><%=board.getRegDate()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left"><%=board.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글수정"></td>
				</tr>
			</table>
			<hr>
			<a href="insertBoard.do">글등록</a>&nbsp;&nbsp;&nbsp; <a
				href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
			<a href="getBoardList.do">글목록</a>&nbsp;&nbsp;&nbsp;


		</form>
	</center>
</body>
</html>