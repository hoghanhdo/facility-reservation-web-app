<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約者メニュー</title>
</head>
<body>
  <h2>===== 予約者メニュー =====</h2>
  ログインユーザ名: ${user.realName}
  <br>
  <br> [1]
  <a href="reservationInquiry">予約照会</a>
  <br> [2]
  <a href="facilityReservation">施設予約</a>
  <br>
  <br>
  <a href="logout">ログアウト</a>

</body>
</html>