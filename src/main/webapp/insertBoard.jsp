<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 등록</h1>
		<jsp:include page="logout.jsp"/>
		<hr>
		<form action="insertBoard.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><input type="text" name="writer" size="10"></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
						<td align="left">
						<textarea rows="10" cols="40" name="content">
						</textarea>
						</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="새글등록">
					</td>
				</tr>
			</table>
			<hr>
			<a href="getBoardList.do">글목록</a>&nbsp;&nbsp;&nbsp;
		</form>
	</center>
</body>
</html>