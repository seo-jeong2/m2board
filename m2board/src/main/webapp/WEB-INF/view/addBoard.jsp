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
<div>
<h1>게시글 입력</h1>

<table border = "1">	
	<tr>
		<th>제목</th>
		<td><input type= "text" name="boardtitle" id="boardTitle"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="5" cols="80" name="boardContent" id="boardContent"></textarea></td>
	</tr>
	<tr>
		<th>비밀번호 입력</th>
		<td><input type="password" name="boardPw"></td>
	</tr>	
</table>			
</div>

<div>
	<button type="submit" id="btn">등록</button>
	<button type="reset">초기화</button>
</div>

<a href="${pageContext.request.contextPath}/index">뒤로가기</a>

</body>
</html>