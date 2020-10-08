<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約照会</title>
</head>
<body>
<h2>===== 予約照会 =====</h2>
 <p style="color: midnightblue;">ログインユーザ名: ${user.realName}</p>

 <table border=1>
    施設一覧
    <tr style="color: darkslateblue; background: antiquewhite" bgcolor=#708090>
        <th>施設番号</th>
        <th>施設名</th>
        <th>定員</th>
        <th>内線番号</th>
    </tr>
     <c:forEach var="facility" items="${facilityList}">
         <tr style="color: dimgrey">
             <td><c:out value="${facility.facilityId}"/></td>
             <td><c:out value="${facility.facilityName}"/></td>
             <td align="center"><c:out value="${facility.capacity}"/></td>
             <td><c:out value="${facility.extensionNumber}"/></td>
         </tr>
     </c:forEach>
</table>
<br />
<div>
    <span style="color:darkred;">
    ${exception} </span>
    <c:url var="actionPath" value="/searchReservation"/>
    <form method="post" action="${actionPath}">
      <span style="color: brown">予約照会</span><br />
      施設名：<input type="text" name="facilityName" /><br />
      <input type="submit" value="検索"/>
     </form>
</div>
</body>
</html>