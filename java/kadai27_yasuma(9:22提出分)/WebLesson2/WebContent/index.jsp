
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Index</title>
</head>
<body>
    <p class="title">あなたの睡眠時間、足りていますか？？</p>
    <p>昨日の寝た時間と起きた時間を入力してください。</p>
    <img src="img/sleep.jpg">
<div class="formtag">
    <form action="resist" method="post" class="formtag">
        <table>
            <tr><th>寝た時間</th><td><input type="text" name="sleep"></td></tr>
            <tr><th>起きた時間</th><td><input type="text" name="wake"></td></tr>
        </table>
        <p class="caution">※時間は「yyyy/mm/dd hh:mm:ss」の形で入力してください。</p>
        <input class="btn" type="submit" value="登録">
    </form>
</div>
</body>
</html>