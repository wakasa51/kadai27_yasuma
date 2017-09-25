<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<% String user_id = (String)session.getAttribute("user_id"); %>
<% String pass = (String)session.getAttribute("pass"); %>
<% String user_name = (String)session.getAttribute("user_name"); %>
<% String mail = (String)session.getAttribute("mail"); %>
<% String book_list = (String)session.getAttribute("book_list"); %>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<title>Index</title>
</head>
<body>
</div>
<div class="head wrapper">
	<div class="idx-form">
		<h1 class="welcom-t"><%=user_id %>さんこんにちは！</h1>
		<form action="logout" method="post">
			<button type="submit" name="button" class="logout">ログアウト</button>
		</form>
	</div>
	<div class="idx-form">
		<div class="select-shelf">
			<form class="mybook" action="mybook" method="post">
				<button type="submit" name="mybook-btn" class="mybook-btn">自分の本棚</button>
			</form>
			<form class="others" action="index" method="post">
				<button type="submit" name="others-btn" class="others-btn">みんなの本棚</button>
			</form>
		</div>
		<form action="searchbook" method="post" class="search">
			<button type="submit" name="button" class="search-inputs" placeholder="&#xf002;">本を検索</button>
			<input type="text" name="book_name">
			<input type="hidden" name="user_id" value="<%=user_id %>">
		</form>
	</div>
</div>
<div class="wrapper r-wrap">
	<div class="book-list">
		<%= book_list %>
	</div>
</div>
</body>
</html>
