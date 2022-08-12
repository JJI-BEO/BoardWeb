<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

		<table>
			<tr>
			<td>아이디 :</td>
			<td>${id }</td>
			</tr>
			<tr>
			<td>비밀번호 :</td>
			<td>${password }</td>
			</tr>
			<tr>
			<td>이름 :</td>
			<td> ${name }</td>
			</tr>
			<tr>
			<td>레벨 :</td>
			<td>${role }</td>
			</tr>
		</table>
			
</body>
</html>
