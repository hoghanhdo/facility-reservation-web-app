<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>施設予約検索結果</title>
</head>
<body>
<h2>===== 予約一覧 =====</h2><br />
ログイン名：${user.realName}<br />
<span style="color:darkred"; >${exception}</span><br />


<table border=1>
     <tr style="color: midnightblue; background: antiquewhite">
        <th>予約番号</th>
        <th>開始日時</th>
        <th>終了日時</th>
        <th>利用目的</th>
        <th>施設名</th>
        <th>予約者</th>
        <th>予約者名</th>
        <th>予約者内線番号</th>
      </tr>

    <c:forEach var="reservation" items="${reservationInfoList}">
        <tr style="color: dimgrey;">
          <td><c:out value="${reservation.reservationId}" /></td>
          <td><c:out value="${reservation.startDate}" /></td>
          <td><c:out value="${reservation.endDate}" /></td>
          <td><c:out value="${reservation.purpose}" /></td>
          <td><c:out value="${reservation.equipmentName}" /></td>
          <td><c:out value="${reservation.reserverName}" /></td>
          <td><c:out value="${reservation.department}" /></td>
          <td><c:out value="${reservation.extensionNumber}" /></td>
         </tr>
     </c:forEach>


</table>
<br />
<a href="userMenu.jsp" >予約者メニュー</a>

</body>
</html>