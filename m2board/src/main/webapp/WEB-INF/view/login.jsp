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
<h1>로그인</h1>
<div>
      <a href="${pageContext.request.contextPath}/addMember"> 
      회원가입
      </a>
</div>
<fieldset>
<form action="login" method="post">
				<legend> 회원 로그인 </legend>
				<table border="1">
					<tr>
						<td> ID </td>
						<td><input type="text" name="memberId" id="memberId"></td>
					</tr>
					<tr>
						<td> PW </td>
						<td><input type="password" name="memberPass" id="memberPass"></td>
					</tr>
				</table>
				<button type="submit" id="memberBtn"> 로그인 </button>
   
 </form>        


				
</fieldset>
</body>
</html>