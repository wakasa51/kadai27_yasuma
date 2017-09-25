<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<% String user_id = (String)session.getAttribute("user_id"); %>
<% String own_user_id = (String)session.getAttribute("own_user_id"); %>
<% String book_id = (String)session.getAttribute("book_id"); %>
<% String author = (String)session.getAttribute("author"); %>
<% String title = (String)session.getAttribute("title"); %>
<% String image = (String)session.getAttribute("image"); %>
<% String review = (String)session.getAttribute("review"); %>
<% String rating = (String)session.getAttribute("rating"); %>
<% String rental = (String)session.getAttribute("rental"); %>
<% String rental_btn = (String)session.getAttribute("rental_btn"); %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<title>Description</title>
</head>
<body>
	<div class="wrapper">
	<div class="bookreg">
		<img src="<%=image%>" alt="<%=title%>" class="book-img">
		<p class="book-text book-title"><%=title%></p>
		<p class="book-text book-author"><%=author%></p>
		<p class="review"><%=own_user_id%>さんの評価：<%=rating %><br>感想：<%=review %></p>
		<form class="book-reg" action="index.jsp" method="post">
			<input type="hidden" name="user_id" value="<%=user_id %>">
			<input type="hidden" name="book_id" value="<%=book_id %>">
			<input type="hidden" name="title" value="<%=title %>">
			<input type="hidden" name="author" value="<%=author %>">
			<input type="hidden" name="image" value="<%=image %>">
			<br>
			<div class="btn-center">
				<%=rental_btn %>
				<button type="submit" name="return-btn" class="return-btn">Topに戻る</button>
			</div>
		</form>

	</div>
	</div>
</body>
</html>
