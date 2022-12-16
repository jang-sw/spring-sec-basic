<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://unpkg.com/mvp.css">

</head>
<body>
	<main>
		<form action="/login/process" method="post">
			id : <input type="text" name="id" />
			pwd : <input type="password" name="pwd" />
			<button>로그인</button>
		</form>
		<button onclick="window.location.href='/joinForm'">회원가입</button>
	</main>																																																													
</body>
</html>