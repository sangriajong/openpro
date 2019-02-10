<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<header>
			<jsp:include page="/WEB-INF/views/main/main.jsp"/>
	</header>
	
	<h2>로그인</h2>
	<hr>
	
<form action="/open/login" method="POST">


<table>
<tr>
    <td style="width: 200px;">ID</td>
    <td style="width: 390px"><input type="text" name="id" style="width: 99%;" required/></td>
</tr>
<tr>
    <td>비밀번호(Password)</td>
    <td><input type="password" name="password" id="password"style="width: 99%;" required/></td>
</tr>
</table>
<br><br>
<div style=" margin-left:200px;" >
    <input type="submit" value="로그인" />
</div>
</form>
<c:if test="${msg != null}">
		<script>
			alert('${msg}');
		</script>
	</c:if>
</body>
</html>