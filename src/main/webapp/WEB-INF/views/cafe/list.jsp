<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafe/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>

<div class="container">
		
	<a class="btn btn-primary btn-xs" href="insertform.do"><i class="glyphicon glyphicon-pencil"></i>새글 작성</a>
	<h3>카페 글 목록입니다.</h3>
	<table class="table table-bordered table-condensed">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list}">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.writer }</td>
					<td><a href="detail.do?num=${tmp.num }">${tmp.title }</a></td>
					<td>${tmp.viewCount }</td>
					<td>${tmp.regdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div><!-- /.container -->

<script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
<script>

set("${condition}");

	function set(condition){
		if(condition=="titlecontent" || condition==""){
			condition="titlecontent";
			$("#conditionBtn").text("제목+파일명");
		}else if(condition=="title"){
			$("#conditionBtn").text("제목");
		}else if(condition=="writer"){
			$("#conditionBtn").text("작성자");
		}
		$("#condition").val(condition);
	}

	function deleteConfirm(num){
		var isDelete = confirm(num + "번 글을 삭제하시겠습니까?");
		if(isDelete){
			// javascript로 이동
			location.href = "delete.do?num=" + num;
		}
	}
</script>
</body>
</html>











