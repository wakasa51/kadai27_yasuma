<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<% String message = (String)request.getAttribute("message"); %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">

<title>Index</title>
</head>
<body>
<div class="wrapper">
	<div class="cert-l">
		<p class="cert-msg"><%=message %></p>
		<form class="" action="login.jsp">
			<button class="login-button" type="submit" name="button">ログインページへ</button>
		</form>
		<form action="user_regist.html">
			<button type="submit" name="reg" class="reg">新規登録ページへ</button>
		</form>
	</div>
</div>
</body>
</html>
