<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String sleep =(String)request.getAttribute("sleep");%>
<% String wake = (String)request.getAttribute("wake");%>
<% String hour = (String)request.getAttribute("hour");%>
<% String minute = (String)request.getAttribute("minute");%>
<% String secound = (String)request.getAttribute("secound");%>

<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Result</title>
</head>
<body>

    <p>寝た時間は<%=sleep%></p>
    <p>起きた時間は<%=wake%></p>

    <p class="time">睡眠時間は<%=hour%>時間<%=minute%>分<%=secound%>秒です。</p>

<% if (Integer.parseInt(hour) <= 4){%>
 <p class="result">やばいです。このままだと死にます！！</p>
 <img src="img/karoshi.png">
<% }else{%>
 <p class="result">もうちょっと頑張れます！Work Hard！！</p>
 <img src="img/namake.png">
<% }%>

   	<a href="index.jsp">TOPページへ</a>


</body>
