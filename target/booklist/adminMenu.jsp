<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者メニュー</title>
</head>
<body>
<h2>===== 管理者メニュー =====</h2>
    ログインユーザ名: ${admin.realName}
<br>
  <br> [1]
  <a href="./registerUser">管理登録</a>
  <br> [2]
  <a href="./registerFacility">ユーザ登録</a>
  <br>
  <br>
  <a href="logout">ログアウト</a>

</body>
</html>