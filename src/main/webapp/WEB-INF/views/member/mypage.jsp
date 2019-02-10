<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
.image {
	width: 300px;
	height: 300px;
	border-radius: 180px;
	background-image: url("/open/resources/upload/${login.photo}");
	background-size: contain;
	overflow: hidden;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/main/main.jsp" />
	</header>
	<section>
		<h2>회원 마이페이지</h2>
		<hr>
		<div id="wrap">
			<div class="image"></div>
			<p>
				<span>회원번호:&nbsp;</span>${login.idx }</p>
			<p>
				<span>회원아이디:&nbsp;</span>${login.id }</p>
			<p>
				<span>회원이름: &nbsp;</span>${login.name }</p>
		</div>
	</section>
</body>
</html>