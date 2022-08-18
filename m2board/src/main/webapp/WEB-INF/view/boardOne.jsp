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
<h1>글 상세보기</h1>
<table border="1">
	<thead>
	<tr> 
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
        <th>작성일</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="b" items="${list}">	
            <td>${b.boardTitle}</td>
            <td>${b.boardWriter}</td>
            <td>${b.boardContents}</td>
            <td>${b.createDate}</td>
</c:forEach>
</tbody>
</table>

<a href="${pageContext.request.contextPath}/boardList">뒤로가기</a>
</body>
</html>