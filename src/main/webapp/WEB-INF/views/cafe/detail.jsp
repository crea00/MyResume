<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>채용공고보기 입니다.</title>
<jsp:include page="/resources/resource.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/SmartEditor/js/HuskyEZCreator.js"></script>
<style>
	textarea{resize:none;}
	#content{display:none;width:100%;height:300px;}
	.comments{
		border: 1px dotted #cecece;
	}
	.comment textarea{
		width:80%;
		background-color: #fff;
	}
	.comment form{
		display: none;
	}
	.comment{
		position: relative;
	}
	.comment .reply_icon{
		position: absolute;
		width: 20px;
		height: 20px;
		top:0;
		left:-20px;
		border-left: 2px solid green;
		border-bottom: 2px solid green;
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
							<a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/cafe/list.do">리스트로 가기</a>
							<h3>${dto.title }</h3>
							<p>${dto.regdate} <em>By</em> <strong>관리자</strong></p>
						</div><!-- /header -->
						
						<div class="body table-responsive">
							<div class="content">${dto.content }</div>
						    <hr/>
						    <%-- 관리자라면  수정,삭제 링크를 출력한다. --%>
						   	<c:if test="${id eq 'admin' }">
							    <a class="btn btn-default btn-xs" href="updateform.do?num=${dto.num }">수정</a>
							    <a class="btn btn-default btn-xs" href="javascript:delCheck()">삭제</a><br/>
							</c:if>
							
							<div class="moveBtn" style="margin-top: 10px;">
								<c:if test="${dto.prevNum ne 0 }">
							   		<a class="btn btn-default btn-sm" href="detail.do?num=${dto.prevNum}&condition=${condition}&keyword=${keyword}">이전글 보기</a>
							   	</c:if>
							   	<c:if test="${dto.nextNum ne 0 }">
							   		<a class="btn btn-default btn-sm" href="detail.do?num=${dto.nextNum}&condition=${condition}&keyword=${keyword}">다음글 보기</a>
							   	</c:if>
							</div>						   	
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

<script>

	function delCheck(){
		var isDelete = confirm("삭제하시겠습니까?");
		if(isDelete){
			location.href = "delete.do?num=${dto.num}";
		}
	}

</script>
</body>
</html>
