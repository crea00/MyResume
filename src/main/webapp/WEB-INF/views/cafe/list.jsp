<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Jquery DataTable | Bootstrap Based Admin Template - Material Design</title>
<jsp:include page="/resources/resource.jsp"></jsp:include>

<title>cafe/list.jsp</title>
	<style>
		th{
			text-align:center;
		}
		td{
			text-align:center;
		}
		.container ul {
			margin : 0 auto;
		}
	</style>
</head>

<body class="theme-red">

<!-- nav -->
<jsp:include page="/resources/nav.jsp"></jsp:include>  
<!-- nav./ -->

	<section class="content">
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h3>게시판 목록입니다.</h3>
								<c:if test="${id eq 'admin'}">
									<a class="btn btn-primary btn-xs" href="insertform.do"><i class="glyphicon glyphicon-pencil"></i>새글 작성</a>
								</c:if>
								<br />
						</div><!-- /header -->
						
						<div class="body table-responsive" style="height:470px;">
							<table class="table table-hover">
								<colgroup>
									<col width="10%" />
									<col width="10%" />
									<col width="50%" />
									<col width="10%" />
									<col width="20%" />	
								</colgroup>
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
												<c:if test="${tmp.writer eq 'admin' }">
													<td>관리자</td>
												</c:if>
											<td><a href="detail.do?num=${tmp.num }">${tmp.title }</a></td>
											<td>${tmp.viewCount }</td>
											<td>${tmp.regdate }</td>
										</tr>
									</c:forEach>
								</tbody>								
							</table><!-- /table -->
							
							<!-- pagianation 처리 -->
							<div class="container" style="text-align: center;">
								<ul class="pagination">
									<c:choose>
										<c:when test="${startPageNum ne 1 }">
											<li>
												<a href="list.do?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${keyword}">&laquo;</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="disabled">
												<a href="javascript:">&laquo;</a>
											</li>
										</c:otherwise>
									</c:choose>
									<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
										<c:choose>
											<c:when test="${i eq pageNum }">
												<li class="active"><a href="list.do?pageNum=${i }&condition=${condition}&keyword=${keyword}">${i }</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="list.do?pageNum=${i }&condition=${condition}&keyword=${keyword}">${i }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:choose>
										<c:when test="${endPageNum lt totalPageCount }">
											<li>
												<a href="list.do?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${keyword}">&raquo;</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="disabled">
												<a href="javascript:">&raquo;</a>
											</li>
										</c:otherwise>
									</c:choose>
								</ul>
							</div>
							
							
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-4 col-xs-offset-3 col-md-offset-3 col-sm-offset-3 col-lg-offset-4">
									<form action="list.do" method="post">
										<input type="hidden" id="condition" value="${condition }" name="condition"/>
										<div class="input-group">
											<div class="input-group-btn">
												<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
													<span id="conditionBtn">제목 + 내용</span>
													<span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a href="javascript:set('titlecontent')">제목 + 내용</a></li>
													<li><a href="javascript:set('title')">제목</a></li>
													<li><a href="javascript:set('content')">내용</a></li>
												</ul>
											</div>
											<!-- /btn-group -->
										
											<input type="text" id="keyword" name="keyword" value="${keyword }" class="form-control" placeholder="검색조건을 입력해주세요" />
											<span class="input-group-btn">
											<button class="btn btn-default" type="submit">
												<span class="sr-only">검색</span>
												<span class="glyphicon glyphicon-search"></span>
											</button>
											</span>
											
											
	
											
										</div>
									</form>
								</div>
							</div><!-- /row -->
							
						</div><!-- /div.body -->
					</div>
				</div>
			</div>
		</div>
	</section>

<script>

set("${condition}");

	function set(condition){
		if(condition == "titlecontent" || condition == ""){
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











