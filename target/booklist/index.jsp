<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
    <p><h3>===== 施設予約システム =====</h3></p>
    <div>
        ログイン名とパスワードを入力してください
    </div>
    <br />
    <div style="color:darkred;">
        ${exception}
        <br />
    </div>
    <br />
 <c:url var="actionPath" value="login" />
     <form method="post" action="${actionPath}">
        ログイン名 <input type="text" name="loginName" size="12" /><br /><br />
        パスワード <input type="password" name="password" size="12" /><br /><br />
        <input type="submit" value="ログイン" />
    </form>
</body>
</html>