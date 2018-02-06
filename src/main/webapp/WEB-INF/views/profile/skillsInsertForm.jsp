<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- LISTs -->
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Jquery DataTable | Bootstrap Based Admin Template - Material Design</title>
 <jsp:include page="/resources/resource.jsp"></jsp:include>
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
                            <h2>SKILLS</h2>
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
                            
                            <form action="skillsInsert.do" id="form_advanced_validation" method="POST" novalidate>
                            <input type="hidden" name="id" value="${id}" />
                         	<input type="hidden" id="skill_nm" name="skill_nm" value="${skill_nm }" />
	           			   
	           			    	<div class="btn-group">
	           			    		<button type="button" class="btn btn-default"><span id="skillsBtn">기술명을 입력해주세요.</span></button>
		                       		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
		                           	 <span class="caret"></span>
	                           		</button>
	                          		<ul class="dropdown-menu" role="menu" style="top : 65px"> 
	                      				<li><a href="javascript:set('java')">java</a></li>
	                      				<li><a href="javascript:set('JSP')">JSP</a></li>
	                      				<li><a href="javascript:set('Spring')">Spring</a></li>
	                          			<li><a href="javascript:set('javascript')">javascript</a></li>
	                          			<li><a href="javascript:set('nodeJS')">nodeJS</a></li>
	                          			<li><a href="javascript:set('Python')">Python</a></li>
		                          		<li><a href="javascript:set('C')">C</a></li>
	                          			
	                      		    </ul>
	                       		</div>
	                       		<!-- Split button -->
                          	    	
                                <div class="form-group form-float">
                                    <div class="form-line">
                                    	<input placeholder="기술 설명" type="text" class="form-control" name="skill_exp" maxlength="500" required>
                                    </div>
                                    <div class="help-info">* 필수 작성</div>
                                </div>                              	
   
                                <button class="btn btn-primary" type="submit">SUBMIT</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Advanced Validation -->
        </div> 
    </section>
   							
    <script>
    
    set("${skill_nm}");
    
    function set(skill_nm){
    	if(skill_nm == "java"){
    		$("#skillsBtn").text("java");
    	} else if(skill_nm == "JSP"){
    		$("#skillsBtn").text("JSP")
    	} else if(skill_nm == "Spring"){
    		$("#skillsBtn").text("Spring")
    	} else if(skill_nm == "javascript"){
    		//console.log("javascript");
    		$("#skillsBtn").text("javascript");
    	} else if(skill_nm == "nodeJS"){
    		$("#skillsBtn").text("nodeJS");
    	} else if(skill_nm == "Python") {
    		$("#skillsBtn").text("Python");
    	} else if(skill_nm == "C") {
    		$("#skilllsBtn").text("C");
    	}
    	
    	$("#skill_nm").val(skill_nm);
    	console.log(skill_nm);
    }


	
 	/*
 	$('#example .dropdown-menu li > a').on('click', function (e) {
 	    var skillName = $(this).html();
 	    console.log($(this).html().val());
 	    $('#example button.dropdown-toggle').html(skillName + '<span class="caret"></span>');
 	});
	*/
    
    
    
    </script>


</body>

</html>