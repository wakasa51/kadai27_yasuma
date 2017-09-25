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
	  <form class="msg-form" action="rental" method="post">
			<p class="msg-d">レンタル期間</p>
			<input type="radio" name="rental_period" value="2週間">2週間　
			<input type="radio" name="rental_period" value="1ヶ月">1ヶ月　
			<input type="radio" name="rental_period" value="2ヶ月">2ヶ月<br>
			<p class="msg-d">受け取り方法</p>
			<input type="radio" name="how_receive" value="郵送">郵送　
			<input type="radio" name="how_receive" value="手渡し">手渡し<br>
			<p class="msg-d"><%=own_user_id %>さんへのメッセージ</p>
			<textarea name="msg" rows="5" cols="50"></textarea><br>
      <input type="hidden" name="send_user" value="<%=user_id %>">
      <input type="hidden" name="receive_user" value="<%=own_user_id %>">
			<input type="hidden" name="book_id" value="<%=book_id %>">
      <div class="btn-center">
        <button type="submit" name="msg-send" class="send-btn">送信する</button>
      </div>
	  </form>

	</div>
	</div>
</body>
</html>
