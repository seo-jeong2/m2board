<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>게시글 목록</h1>
   <div>
      <a href="${pageContext.request.contextPath}/addBoard">
         글쓰기
      </a>
   </div>
   <table border="1">
      <thead>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
            <th>좋아요</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="b" items="${list}">
            <td>${b.boardNo}</td> <!-- b.getNo() -->
            <td>
               <a href="${pageContext.request.contextPath}/boardOne?boardNo=${b.boardNo}">
                  ${b.boardTitle}
               </a>
            </td>
            <td>${b.boardWriter}</td>
            <td>${b.createDate}</td>
            <td>${b.boardRead}</td>
            <td>${b.boardNice}</td>
         </c:forEach>
      </tbody>
   </table>
   <div>
   	<c:if test="${currentPage >1}">
   	<a href = "${pageContext.request.contextPath}/boardList?currentPage=${currentPage-1}">이전</a>
   	</c:if>
  	<c:if test="${currentPage < 1}">
  	<a href = "${pageContext.request.contextPath}/boardList?currentPage=${currentPage+1}">다음</a>
   </c:if>
   </div>
   
   <div>
   <a href = "${pageContext.request.contextPath}/index">뒤로가기</a>
   </div>
   
</body>
</html>