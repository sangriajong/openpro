<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록(게시판)</title>
</head>
<body>
	<header>
			<jsp:include page="/WEB-INF/views/main/main.jsp"/>
	</header>
	<hr>
	<c:if test="${board.isEmpty() }">
	<p>등록된 메시지가 없습니다.</p>
	</c:if>
	<c:if test="${!board.isEmpty() }">
		<a href="write">글작성</a>
		<table border="1">
		<c:forEach items="${board}" var="msg">
			<tr>
				<td>메시지 번호 : ${msg.no }<br>
				이름 : ${msg.bname }<br>
				내용 : ${msg.bcontent }<br>
				<a href="delete?no=${msg.no}">[삭제]</a></td>
			</tr>
		</c:forEach>
		</table>
		<!--  페이징 처리  -->
		<div class="paging">
			<c:if test="${page.prev }">
				<a href="/open/board/board?pageNum=${page.startPage -1 }"> &lt;&lt; </a>
			</c:if>
			<c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
				<a href="/open/board/board?pageNum=${num }&amount=3"> ${num } </a>
			</c:forEach>
			<c:if test="${page.next }">
				<a href="/open/board/board?pageNum=${page.endPage +1 }"> &gt;&gt; </a>
			</c:if>
		</div>
	</c:if>
</body>
</html>