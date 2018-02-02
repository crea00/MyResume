<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- LISTs -->
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Jquery DataTable | Bootstrap Based Admin Template - Material Design</title>
<jsp:include page="/resources/resource.jsp"></jsp:include>v
</head>

<body class="theme-red">
  <!-- nav -->
<jsp:include page="/resources/nav.jsp"></jsp:include>  
<!-- nav./ -->
    <section class="content">
        <div class="container-fluid">
        
    <!-- Advanced Validation -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>EXPERIENCES</h2>
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
                            <form action="expsUpdate.do" id="form_advanced_validation" method="POST" novalidate>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                    	<input type="hidden" name="id" value="${dto.id}" />
                                    	<input type="hidden" name="num" value="${dto.num }" />
                                        <input value="${dto.position}" placeholder="업무 포지션" type="text" class="form-control" name="position" maxlength="10" minlength="3" required>
                                    </div>
                                    <div class="help-info">* 필수 작성</div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                    	<input value="${dto.place}" placeholder="회사 또는 기관명" type="text" class="form-control" name="place" maxlength="50" minlength="3" required>
                                    </div>
                                    <div class="help-info">* 필수 작성</div>
                                </div>
                                 <div class="form-group form-float">
                                    <div class="form-line">
                                    	<input value="${dto.ex_exp}" placeholder="이력설명" type="text" class="form-control" name="ex_exp" maxlength="500" minlength="3" required>
                                    </div>
                                    <div class="help-info">* 필수 작성</div>
                                </div>
                                 <div class="form-group form-float">
                                    <div class="form-line">
                                    	<input id="inputMsg" value="${dto.start_date}" placeholder="시작일('YYYY-MM-DD'형식으로 작성해주세요)" type="text" class="form-control" name="start_date" maxlength="50" minlength="3" required>
                                    </div>
                                    <div class="help-info">* 필수 작성</div>
                                </div>
                                 <div class="form-group form-float">
                                    <div class="form-line">
                                    	<input id="inputMsg2" value="${dto.end_date}" placeholder="종료일('YYYY-MM-DD'형식으로 작성해주세요)" type="text" class="form-control" name="end_date" maxlength="50" minlength="3" required>
                                    </div>
                                    <div class="help-info">* 필수 작성</div>
                                </div>
                                
                                <button id="myBtn" class="btn btn-primary waves-effect" type="button">SUBMIT</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Advanced Validation -->
        </div> 
    </section>
	<script>
	$("#form_advanced_validation").validate();
	 $("#myBtn").click(function(){
			var str= $("#inputMsg").val();
			var str2 =$("#inputMsg2").val();
			
			var reg=/^(\d{4})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;

			var isOk2=reg.test(str2);
			var isOk=reg.test(str);
			
			if(isOk && isOk2){	
				$('#form_advanced_validation').submit();
			}
			else if(!isOk)
			{
				alert(str+"날짜형식x");
				$("#inputMsg").focus();
				return false;
			}
			else if(!isOk2)
			{
				alert(str2+"날짜형식x");
				$("#inputMsg2").focus();
				return false;
			}
		});	
	</script>
</body>

</html>