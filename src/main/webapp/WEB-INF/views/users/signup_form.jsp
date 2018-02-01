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
                            <input type="text" class="form-control" id="id" name="id" placeholder="아이디" required autofocus>
                        </div>
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
    $("#id").keyup(function(){
		//입력한 문자열을 읽어온다.
		var id_check=$(this).val();
		//ajax 요청을 해서 서버에 전송한다.
		$.ajax({
			method:"post",
			url:"check.do",
			data:{inputId:id_check},
			success:function(data){
				var obj=JSON.parse(data);
				if(obj.canUse){//사용 가능한 아이디 라면 
					$("#overlapErr").hide();
					// 성공한 상태로 바꾸는 함수 호출
					successState("#id");
				

				}else{//사용 가능한 아이디가 아니라면 
					$("#overlapErr").show();
					//실패한 상태로 바꾸는 함수 호출
					errorState("#id");
					
				}
			}
		});
	});

	

    </script>
</body>
</html>