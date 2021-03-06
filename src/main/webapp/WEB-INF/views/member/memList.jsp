<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
	#mod{
		position: fixed;
		width: 100%;
		height: 100vh;
		background-color: #f1d0d5;
		color: black;
		opacity: 0.9;
		z-index: 10;
		top: 0;
		left: 0;
		display: none;
	}
	
	#mod>form{
		margin-top: 40vh;
	}
	
	#mod>div{
		text-decoration: none;
		text-align: center;
		margin: auto;
		cursor: pointer;
	}
	
#Modified{
	text-decoration: none;
	color: black;
	font-size: 50pt;
	}
	
	.right{
	margin-left:300px;
	}

</style>
<script type="text/javascript" src="/open/resources/js/member.js"></script>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/main/main.jsp" />
	</header>
	<section>
	<a href="pdf">PDF 다운로드</a>

	<h2>회원 리스트</h2>
		<table>
		<thead>
			<tr>
				<th>회원 번호</th>
				<th>회원 아이디</th>
				<th>패스워드</th>
				<th>회원 사진</th>
				<th>회원 이름</th>
				<th>회원 가입일</th>
				<th>회원 관리</th>
			</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
		<div id="mod">
			<form action="/editMember.do" method="POST" enctype="multipart/form-data">
				
				<div class ="right" onclick="x()"><a href="#"  id ="Modified" data-role="button">X</a></div>
				<input type="hidden" id="idx" name="idx"/><br>
				<label for="id">아이디(이메일)</label>
				<input type="text" name="id" id="id" /><br>
				<label for="password">비밀번호</label>
				<input type="password" name="password" id="password" /><br>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" /><br>
				<input type="submit" value="변경" />
				
			</form>
			
		</div>
	</section>
	<script>
		
		var tbody = $('tbody');
		$(document).ready(function(){
			var mod = $('#mod>form');
			makeList();
			
			$('input[type=submit]').on('click', function(e){
				e.preventDefault();
				var member = {idx:$('#idx').val(), id:$('#id').val(), password:$('#password').val(), name:$('#name').val()};
				memberService.update(member, function(result){
					alert(result);
					//$('#mod').fadeOut(1000);
					makeList();
				});
			});
			
		});
	
		function makeList(){
			tbody.empty();
			
			memberService.getList(function(list){
				for(var i = 0, len = list.length || 0 ; i < len; i++){
					var tr = $('<tr></tr>');
					var idx = $('<td id="'+ list[i].idx +'">' + list[i].idx + '</td>');
					var id = $('<td>' + list[i].id + '</td>');
					var pwd = $('<td>' + list[i].password + '</td>');
					var name = $('<td>' + list[i].name + '</td>');
					var photo = $('<td><img src="/open/resources/upload/' + list[i].photo + '" alt="member_photo"></td>');
					var regDate = $('<td>' + list[i].regDate + '</td>');
					var manage = $('<td><a href="#" class="modify" onclick="modify(' + list[i].idx + ')">수정</a> <a href="#" class="remove" onclick="remove(' + list[i].idx + ')">삭제</a></td>');
					tr.append(idx).append(id).append(pwd).append(photo).append(name).append(regDate).append(manage);
					tbody.append(tr);
					console.log(list[i]);
				}
			});
		}
		
		function x(){
			$('#mod').fadeOut(500);
		}
		
		function modify(idx){
			$('#idx').val(idx);
			$('#id').val($('#'+idx).siblings().eq(0).text());
			$('#pwd').val($('#'+idx).siblings().eq(1).text());
			$('#name').val($('#'+idx).siblings().eq(3).text());
			$('#mod').fadeIn(500);
		}
		
		function remove(idx){
			
			var removeFlag = confirm('정말로 삭제하시겠습니까?');
			if(!removeFlag) return;
			
			memberService.remove(idx, function(result){
				if(result === 'success'){
					alert('삭제 성공');
					makeList();
				}
			//
			}, function(err){
				alert('에러니까 다시 시도 해주세요 .');
			});
		}
	</script>
</body>
</html>