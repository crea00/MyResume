<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/users/login_result.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${isValid }">
		<p><strong>${id }</strong>님 로그인중...</p>
		<a href="${url}">확인</a>
	</c:when>
	<c:otherwise>
		<p>아이디 혹은 비밀번호 확인해 주세요</p>
		<a href="loginform.do?url=${url }">로그인</a>
	</c:otherwise>
</c:choose>
</body>
</html>