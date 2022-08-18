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
	<tr>
		<td>제목</td>
		<td><input type= "text" name="boardtitle" id="boardTitle"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea rows="5" cols="80" name="boardContent" id="boardContent"></textarea></td>
	</tr>
	<tr>
		<td>비밀번호 입력</td>
		<td><input type="password" name="boardPw"></td>
	</tr>	
			
</div>

<div>
	<button type="submit" id="btn">등록</button>
	<button type="reset">초기화</button>
</div>

<a href="${pageContext.request.contextPath}/boardList">뒤로가기</a>

</body>
</html>