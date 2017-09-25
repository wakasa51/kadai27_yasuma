<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<% String user_id = (String)session.getAttribute("user_id"); %>
<% String book_id = (String)session.getAttribute("book_id"); %>
<% String author = (String)session.getAttribute("author"); %>
<% String title = (String)session.getAttribute("title"); %>
<% String image = (String)session.getAttribute("image"); %>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<title>BookReg</title>
</head>
<body>
<div class="wrapper">
<div class="bookreg">
  <img src="<%=image%>" alt="<%=title%>" class="book-img">
  <p class="book-text book-title"><%=title%></p>
  <p class="book-text book-author"><%=author%></p>
  <form class="book-reg" action="bookregdb" method="post">
    <p class="rental">本の感想をお書きください</p>
    <textarea name="review" rows="5" cols="60"></textarea>
    <p class="rsting">こちらの本はいかがでしたか？</p>
    <input type="radio" name="rating" value="1">☆<br>
    <input type="radio" name="rating" value="2">☆☆<br>
    <input type="radio" name="rating" value="3">☆☆☆<br>
    <p class="rental"> 本をお貸しすることができますか？</p>
    <input type="radio" name="rental" value="1">可<br>
    <input type="radio" name="rental" value="0">不可
    <input type="hidden" name="user_id" value="<%=user_id %>">
    <input type="hidden" name="book_id" value="<%=book_id %>">
    <input type="hidden" name="title" value="<%=title %>">
    <input type="hidden" name="author" value="<%=author %>">
    <input type="hidden" name="image" value="<%=image %>">
    <br>
    <div class="btn-center">
      <button type="submit" name="book-reg-btn" class="book-reg-btn">本棚に登録する</button>
    </div>
  </form>
</div>
</div>
</body>
</html>
