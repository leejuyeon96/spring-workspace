<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
	<style>
		h1{
			margin-top: 70px;
		}
		.form-group {
			margin: 20px 0;
		}
	</style>
</head>
<body>
	<div class="container">
	
		<h1>게시글 정보</h1>
		<form action="/board/update" method="post"> 
			
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" name="title" id="title" readonly value="${vo.title}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea name="content" id="content" cols="30" rows="10" class="form-control" style="resize: none" readonly>
				${vo.content}</textarea>
				<img src="${vo.url}"/>
			</div>	
			<div class="form-group">
				<label for="writer">Writer</label>
				<input type="text" readonly value="${vo.writer}" id="writer" name="writer" class="form-control"/>
			</div>	
			<!-- principal : 계정정보를 가지고 있음/! ㅁ나약에 로그인된 정보가 없으면 annonymousUser(문자열)이 들어감
				*authorize : 권한부여와 관련된 것
				*authentication : 인증과 관련된 것, 계정 정보
			 -->
			<sec:authorize access="hasRole('ROLE_MEMBER')">	
		  <sec:authentication property="principal" var="info">
				<a class="btn btn-outline-warning" href="/board/update?no=${vo.no}">수정</a>
		
				<a class="btn btn-outline-danger" href="/board/delete?no=${vo.no}">삭제</a>	
	      </sec:authentication>
			</sec:authorize>	
			
		</form>	 
	</div>
</body>
</html>