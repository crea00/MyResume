<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Myresume - 로그인</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="${pageContext.request.contextPath }/resources/plugins/bootstrap/css/bootstrap.css" rel="stylesheet"> 

    <!-- Waves Effect Css -->
    <link href="${pageContext.request.contextPath }/resources/plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="${pageContext.request.contextPath }/resources/plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
</head>
<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <a href="${pagecontext.request.contextPath }/myresume/">My<b>Resume</b></a>
            <small>Customized Individual Resume Platform</small>
        </div>
        <div class="card">
            <div class="body">
	                <form class="form-signin" action="login.do" method="POST" onsubmit="return FormSubmit();">

                    <div class="msg">로그인 후 나의 이력서를 만들어 보세요!</div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                        	<input type="hidden" name="url" value="${url }" />
                            <input type="text" class="form-control" name="id" placeholder="회원 아이디" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" placeholder="비밀번호" required>     	
                        </div> 	
                    </div>
                     <div class="g-recaptcha" data-sitekey="6Le780MUAAAAAAEstmgpleGJGu0uKopxAfZhNb84"></div>
                    <br/>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                                             
                        	 <c:if test="${not empty msg }">
                            	<p><strong style="color:red">${msg }</strong></p>
                            </c:if> 
                     
                        </div>
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                            <label for="rememberme">Remember Me</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">로그인</button>
                        </div>
                            <a class="btn btn-block bg-green bg-lg waves-effect" href="naverlogin.do" type="button"> 네이버계정으로 로그인</a>
                    </div>
                    <div class="row m-t-15 m-b--20">
                        <div class="col-xs-12 text-center">
                            <a href="signup_form.do">Myresume 회원이 아니신가요?</a>
                        </div>
                    </div>
                
                </form>
            </div>
        </div>
    </div>

    <!-- Jquery Core Js -->
    <script src="${pageContext.request.contextPath }/resources/plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="${pageContext.request.contextPath }/resources/plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="${pageContext.request.contextPath }/resources/plugins/node-waves/waves.js"></script>

    <!-- Validation Plugin Js -->
    <script src="${pageContext.request.contextPath }/resources/plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath }/resources/js/admin.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/pages/examples/sign-in.js"></script>
	<script>
	
		function FormSubmit() {
			if (grecaptcha.getResponse() == "") {
				alert("리캡챠를 체크해야 합니다.");
				return false;
			} else {
				return true;
			}
		}
		
		
		// localStorage 에 저장된 아이디 비밀번호가 있으면 복구시켜준다.
		if(localStorage.id != undefined){
			$("#id").val(localStorage.id);
			$("#password").val(localStorage.passward);
			//체크박스 체크해주기
			$("#rememberme").prop("checked", true);
		}


		//폼 전송 이벤트가 발생했을때 실행할 함수 등록
		$(".form-signin").on("submit", function(){
			//아이디 비밀번호 저장여부 
			var isSave=$("#rememberme").is(":checked");
			if(isSave){
				//입력한 아이디 비밀번호를 읽어와서
				var inputId=$("#id").val();
				var inputPwd=$("#password").val();
				//localStorage 에 저장한다.
				localStorage.id=inputId;
				localStorage.password=inputPwd;
			}else{
				//localStorage 에 id, pwd 삭제하기 
				delete localStorage.id;
				delete localStorage.password;
			}
		});
	</script>
</body>
</html>