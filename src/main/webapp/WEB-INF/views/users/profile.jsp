<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Resume - Start Bootstrap Theme</title>
	<jsp:include page="/resources/profile_resource.jsp"></jsp:include>

  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">
        <span class="d-block d-lg-none">Start Bootstrap</span>
        <span class="d-none d-lg-block">
        
        <c:if test="${not empty userDto.saveFileName }">
          <img style="width: 225px; height: 225px;" class="img-fluid img-profile rounded-circle mx-auto mb-2" src="/upload/${userDto.saveFileName }" alt="">
	    </c:if>
        <c:if test="${empty userDto.saveFileName }">	            
			<img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="${pageContext.request.contextPath}/resources/img/profile.jpg" alt="">
			
	    </c:if>
	    </span>
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#about">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#experience">Experience</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#education">Education</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#skills">Skills</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#interests">Interests</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#awards">Awards</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container-fluid p-0">
	
      <section class="resume-section p-3 p-lg-5 d-flex d-column" id="about">
        <div class="my-auto">
          <h1 class="mb-0">${userDto.name }
          </h1>
          <div class="subheading mb-5">${userDto.phone_no } ·
            <a href="mailto:name@email.com">${userDto.email }</a>
          <c:forEach var="tmp" items="${expsList }">
          <br />
          <span style="color:#9E9E9E;">
          	${tmp.ex_exp }
          </span>
          </c:forEach>
          </div>
        </div>
      </section>

      <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="experience">
        <div class="my-auto">
          <h2 class="mb-5">Experience</h2>
			<!-- experience select  -->
			<c:forEach var="tmp" items="${expsList }">
				<div class="resume-item d-flex flex-column flex-md-row mb-5">
		            <div class="resume-content mr-auto">
		              <h3 class="mb-0">${tmp.position }</h3>
		              <div class="subheading mb-3">${tmp.place }</div>
		              <p>${tmp.ex_exp }</p>
		            </div>
		            <div class="resume-date text-md-right">
		              <span class="text-primary">${tmp.start_date } - ${tmp.end_date }</span>
		            </div>
		          </div>
			</c:forEach>
     	   </div>
      </section>

      <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="education">
        <div class="my-auto">
          <h2 class="mb-5">Education</h2>
			<!-- education select  -->
			<c:forEach var="tmp" items="${eduList }">
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
	            <div class="resume-content mr-auto">
	              <h3 class="mb-0">${tmp.place }</h3>
	          	   <div class="subheading mb-3">${tmp.major }</div>
	       		     <div>${tmp.edu_exp }</div>
	          	  </div>
	        	<div class="resume-date text-md-right">
            	 <span class="text-primary">${tmp.start_date } - ${tmp.end_date }</span>
           	 </div>
         	 </div>
			</c:forEach>
        </div>
      </section>
      
      <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="skills">
        <div class="my-auto">
          <h2 class="mb-5">Skills</h2>
			<!-- education select  -->
			<c:forEach var="tmp" items="${skillsList }">
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
	            <div class="resume-content mr-auto">
	              <h3 class="mb-0">${tmp.skill_nm }</h3>
	          	   <div class="subheading mb-3">${tmp.skill_exp }</div>
	          	  </div>
         	 </div>
			</c:forEach>
        </div>
      </section>
      
       <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="interests">
        <div class="my-auto">
          <h2 class="mb-5">Interests</h2>
			<!-- education select  -->
			<c:forEach var="tmp" items="${intsList }">
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
	            <div class="resume-content mr-auto">
	              <h3 class="mb-0">${tmp.ints_nm }</h3>
	          	   <div class="subheading mb-3">${tmp.ints_exp }</div>
	          	  </div>
         	 </div>
			</c:forEach>
        </div>
      </section>



 

      <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="awards">
        <div class="my-auto">
          <h2 class="mb-5">Awards &amp; Certifications</h2>
          <ul class="fa-ul mb-0">
          <c:forEach var="tmp" items="${acList }">
            <li>
              <i class="fa-li fa fa-trophy text-warning"></i>
             ${tmp.ac_nm } - ${tmp.ac_exp }</li>
            </c:forEach>
          </ul>
        </div>
      </section>

    </div>
   
    
        <!-- Bootstrap core JavaScript -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="/resources/js/resume.min.js"></script>

  </body>

</html>
