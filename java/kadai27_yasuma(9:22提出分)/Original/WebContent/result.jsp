<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<% String search_result = (String)session.getAttribute("search_result"); %>
<% String user_id = (String)session.getAttribute("user_id"); %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<title>Result</title>
</head>
<body>
<div class="r-menu">
	<form class="return-top" action="index">
		<button type="submit" name="button" class="return-btn rb1">トップに戻る</button>
	</form>
	<form action="logout">
		<button type="submit" name="button" class="logout-btn lb1">ログアウト</button>
	</form>
</div>
<div class="wrapper r-wrap">
	<h1 class="head-text">検索結果</h1>
	<div class="book-list">
		<%= search_result %>
	</div>
</div>
</body>
</html>
