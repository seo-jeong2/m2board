<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Index</h1>

	 
 	<h3> ${loginMember.memberId}님 접속중 </h3>
	<br>
	
	<a href="${pageContext.request.contextPath}/logout"> 로그아웃 </a>
	<a href="${pageContext.request.contextPath}/outMember"> 회원탈퇴 </a><br>
	<a href="${pageContext.request.contextPath}/addBoard"> 글쓰기 </a>
	<a href="${pageContext.request.contextPath}/boardList"> 글목록 </a>


</body>
</html>