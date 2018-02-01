<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Myresume - 회원가입</title>
    <!-- Favico1n-->
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
<body class="signup-page">
    <div class="signup-box">
        <div class="logo">
           <a href="javascript:void(0);">My<b>Resume</b></a>
           <small>Customized Individual Resume Platform</small>
        </div>
        <div class="card">
            <div class="body">
                <form id="sign_up" action="signup.do" method="POST" novalidate>
                    <div class="msg">회원가입으로 다양한 이력서 서비스를 누려보세요!</div>
                     <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" id="id" name="id" placeholder="아이디" required autofocus/>                  	
                        </div>
                        <span id="checkResult"></span>                            
                    </div>
                
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">picture_in_picture</i>
                        </span>
                        <div class="form-line">
                        	<label type="hidden" for="id_check"></label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="이름" required>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">email</i>
                        </span>
                        <div class="form-line">
                            <input type="email" class="form-control" id="email" name="email" placeholder="이메일" required>
                        </div>
                        <span id="checkResult2"></span>  
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">phone</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="phone_no" placeholder="전화번호" required>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" minlength="6" placeholder="비밀번호" required>
                        </div>
                    </div>
                    <input type="hidden" class="form-control" name="is_admin" value="N" required>
                    <div class="form-group">
                        <input type="checkbox" name="terms" id="terms" class="filled-in chk-col-pink">
                        <label for="terms"><a href="javascript:void(0);">회원가입 약관 동의</a></label>
                    </div>

                    <button class="btn btn-block btn-lg bg-pink waves-effect" type="submit">회원가입</button>

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
    <script src="${pageContext.request.contextPath }/resources/js/pages/examples/sign-up.js"></script>
    <script>
    
    	
    $(function(){
    	// 입력한 아이디가 유효한지 여부
    	var idValid = false;
		var inputId = null;
    	
    	$("#id").on("keyup", function(){
    		// 입력한 아이디를 읽어와서
    		inputId = $("#id").val();
    		var str=$("#id").val();
    		// 아이디를 검증할 정규식
    		var reg= /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
    		// 정규식으로 아이디 검증
    		var isOk = reg.test(inputId);
 
    		// ajax를 이용해서 서버에 전송
    		$.ajax({
    			url : "checkid.do",
    			method : "GET", 
    			data : {"inputId" : inputId},
    			success : function(data){
    				if(data.canUse && (inputId !="" && isOk) ){
    					$("#checkResult").text("사용가능한 아이디입니다.").css("color","green");	
    					idValid = true;
    					console.log(idValid);
    				} else {
    					$("#checkResult").text("사용이 불가능한 아이디입니다.").css("color","red");
    					idValid = false;
    					console.log(idValid);
    				}
    			}
    		});
    	});
	});
    
   	// email 형식에 맞는지 여부
	$("#email").keyup(function(){
		var email = $("#email").val();
		var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

		var isOk2 = regEmail.test(email);
		
		if(isOk2){
			$("#checkResult2").text("사용가능").css("color","green");
		}else{
			$("#checkResult2").text("사용불가").css("color","red");
			return false;
		}
	});
    
	//폼 전송 이벤트가 발생했을때
	$("#myForm").submit(function(){
		if(idValid==false){
			alert("아이디 중복 확인을 하세요.");
			$("#id").val("").focus();
			return false; //폼 전송 막기 
		}
	});
	
    </script>
</body>
</html>