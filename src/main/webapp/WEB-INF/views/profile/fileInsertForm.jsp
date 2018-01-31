<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="theme-red">
	<!-- nav -->
	<jsp:include page="/resources/nav.jsp"></jsp:include>
	<!-- nav./ -->
	<!-- 
	 [ 파일 업로드 폼 작성법 ]
	 
	 1. method="post"
	 2. enctype="multipart/form-data"
	 3. <input type="file" />
 -->
	<jsp:include page="/resources/resource.jsp"></jsp:include>
	<section class="content">
		<div class="container-fluid">

			<!-- Advanced Validation -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2>EDUCATION</h2>
							<ul class="header-dropdown m-r--5">
								<li class="dropdown"><a href="javascript:void(0);"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false"> <i
										class="material-icons">more_vert</i>
								</a>
									<ul class="dropdown-menu pull-right">
										<li><a href="javascript:void(0);">Action</a></li>
										<li><a href="javascript:void(0);">Another action</a></li>
										<li><a href="javascript:void(0);">Something else here</a></li>
									</ul></li>
							</ul>
						</div>
						<div class="body">
							<form action="fileInsert.do" method="post"
								enctype="multipart/form-data">
								<table>
									<tr>
										<th><label for="myFile">프로필 사진 업로드</label></th>

										<th></th>
									</tr>
									<tr>
										<td><input type="file" name="myFile" id="myFile"
											class="form-control" /></td>
										<td><button type="submit" class="btn">확인</button></td>
									</tr>
								</table>
							</form>

						</div>
					</div>
				</div>
			</div>
			<!-- #END# Advanced Validation -->
		</div>
	</section>
</body>
</html>