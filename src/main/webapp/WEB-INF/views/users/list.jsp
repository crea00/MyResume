<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- LISTs -->
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Jquery DataTable | Bootstrap Based Admin Template - Material Design</title>
    <!-- css/js -->
<jsp:include page="/resources/resource.jsp"></jsp:include>

</head>
<body class="theme-red">
<!-- nav -->
<jsp:include page="/resources/nav.jsp"></jsp:include>  
<!-- nav./ -->

    <section class="content">
        <div class="container-fluid">
            <div class="block-header">
                <!-- <h2>
                    JQUERY DATATABLES
                    <small>Taken from <a href="https://datatables.net/" target="_blank">datatables.net</a></small>
                </h2> -->
            </div>
            <!-- Exportable Table -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
            
                               My Resume TABLE
                           
                            </h2>
                            <ul class="header-dropdown m-r--5">
                                <li class="dropdown">
                                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                        <i class="material-icons">more_vert</i>
                                    </a>
                                    <ul class="dropdown-menu pull-right">
                                        <li><a href="javascript:void(0);">Action</a></li>
                                        <li><a href="javascript:void(0);">Another action</a></li>
                                        <li><a href="javascript:void(0);">Something else here</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                    <thead>
                                        <tr>
                                           	<th>아이디</th>
											<th>이름</th>
											<th>비밀번호</th>
											<th>이메일</th>
											<th>전화번호</th>
											<th>가입시간</th>
                                        </tr>
                                    </thead>
                             
                                    <tbody>
                               		<c:forEach var="tmp" items="${list }">
										<tr>
											<td>${tmp.id }</td>
											<td><a href="${pageContext.request.contextPath }/profile/detail.do?id=${tmp.id }">${tmp.name }</a></td>
											<td>${tmp.password }</td>
											<td>${tmp.email }</td>
											<td>${tmp.phone_no }</td>
											<td>${tmp.regdate }</td>
				
										</tr>
									</c:forEach>
                                 
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Exportable Table -->
        </div> 
    </section>
</body>

</html>