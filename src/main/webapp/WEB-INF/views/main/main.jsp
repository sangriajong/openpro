<%@page import="org.springframework.web.servlet.support.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈창</title>
<link rel="stylesheet" type="text/css"
	href="/open/resources/css/main.css">

</head>
<body>
	<h1>
		<a href="/open">Open Project</a>
	</h1>
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath }/signup">회원가입</a></li>
			<c:if test="${login == null }"> <!-- 로긴 상태 x  -->
				<li><a href="${pageContext.request.contextPath }/login">로그인</a></li>
			</c:if>
			<c:if test="${login != null }">     <!-- 로긴 상태 O  -->
				<li><a href="${pageContext.request.contextPath }/logout">로그아웃</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath }/member/mypage">회원마이페이지(회원)</a></li>
			<li><a
				href="${pageContext.request.contextPath }/member/memberList">회원리스트(회원)</a></li>
			
			<li><a href="${pageContext.request.contextPath }/">방명록</a></li>
		</ul>
	</nav>
</body>
</html>