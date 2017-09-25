<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<title>Login</title>
</head>
<body>
<div class="wrapper">
	<div class="cert-l">
		<form class="cert_form" action="login" method="post">
			<input type="text" name="user_id" placeholder="ID" class="input-f">
			<input type="text" name="pass" placeholder="Pass" class="input-f">
			<button class="login-button" type="submit" name="button">ログイン</button>
		</form>
		<form action="user_regist.html">
			<button type="submit" name="reg" class="reg">新規登録ページへ</button>
		</form>
	</div>
</div>
</body>
</html>
