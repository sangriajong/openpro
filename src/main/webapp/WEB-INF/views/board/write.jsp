<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>
</head>
<body>
	<header>
			<jsp:include page="/WEB-INF/views/main/main.jsp"/>
	</header>
	<form action="/open/board/write" method="post">
		<label for="bname">이름</label>
		<input type="text" name="bname" /><br>
		<label for="bpassword">암호</label>
		<input type="password" name="bpassword" /><br>
		<label for="bcontent">내용</label>
		<textarea name="bcontent" cols="30" rows="10"></textarea><br>
		<input type="submit" value="메시지 남기기" />
	</form>
	<c:if test="${msg != null}">
		<script>
			alert('${msg}');
		</script>
	</c:if>
</body>
</html>