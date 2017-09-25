<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<% String english = (String)session.getAttribute("english"); %>
<% String japanese = (String)session.getAttribute("japanese"); %>
<% int i = (int)session.getAttribute("i"); %>
<% int j = (int)session.getAttribute("j"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<h1><%=i %>件登録しました。</h1>
	<p>登録件数は<%=j %>件です。</p>
	<a href="index.jsp">トップページに戻る</a>
</form>
</body>
</html>