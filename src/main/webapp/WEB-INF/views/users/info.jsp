<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 정보</h3>
<table>
	<tr>
		<th>아이디</th>
		<td>${myDto.id }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${myDto.password }</td>
	</tr>
	<tr>
		<th>핸드폰 번호</th>
		<td>${myDto.phone_no }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${myDto.email }</td>
	</tr>
	<tr>
		<th>가입날짜</th>
		<td>${myDto.regdate }</td>
	</tr>
</table>
</body>
</html>