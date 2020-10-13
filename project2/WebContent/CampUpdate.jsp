<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>資料新增確認</title>
</head>
<body>
<jsp:useBean id="dao" class="project.CampBean" scope="session" />
<h2>修改資料</h2>
<form action=".\CampServlet" method="post">
<c:forEach items='${list1}' var="acamp" varStatus="status">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#FFFFE1" >
    <td>編號:</td>
    <td><input type="text" name="id" maxlength="5"></td>
    <td>${acamp.id}</td>
</tr><tr bgcolor="#F2F4FB">
    <td>姓名:</td>
    <td><input type="text" name="name" size="10" maxlength="10"></td>
    <td>${acamp.name}</td>
</tr><tr bgcolor="#FFFFE1">
    <td>城市:</td>
     <td><input type="text" name="city" size="10" maxlength="10"></td>
    <td>${acamp.city}</td>
</tr><tr bgcolor="#F2F4FB">
    <td width="150">地址:</td>
    <td><input type="text" name="adress" size="120" maxlength="200"></td>
    <td>${acamp.adress}</td>
</tr><tr bgcolor="#FFFFE1">
    <td>聯絡電話</td>
    <td><input type="text" name="tel" size="20"></td>
    <td>${acamp.tel}</td>
</tr><tr bgcolor="#F2F4FB">
    <td>平日價格</td>
    <td><input type="text" name="oprice" maxlength="10"></td>
    <td>${acamp.oprice}</td>
</tr><tr bgcolor="#FFFFE1">
    <td>假日價格</td>
    <td><input type="text" name="wprice" maxlength="10"></td>
    <td>${acamp.wprice}</td>
</tr><tr bgcolor="#F2F4FB">
    <td>帳篷數量</td>
    <td><input type="text" name="tentnum" maxlength="10"></td>
    <td>${acamp.tentnum}</td>
</tr><tr bgcolor="#FFFFE1">
    <td>海拔</td>
    <td><input type="text" name="elevation" maxlength="10"></td>
    <td>${acamp.elevation}</td>
</tr><tr bgcolor="#F2F4FB">
    <td>營區特色</td>
    <td><input type="text" name="feature" size="120" maxlength="200"></td>
    <td>${acamp.feature}</td>
</tr><tr bgcolor="#FFFFE1">
    <td>附屬設施</td>
    <td><input type="text" name="facility" size="120" maxlength="200"></td>
    <td>${acamp.facility}</td>
</tr><tr bgcolor="#F2F4FB">
    <td>攜帶寵物</td>
    <td><input type="text" name="pet" size="120" maxlength="200"></td>
    <td>${acamp.pet}</td>
</tr><tr bgcolor="#FFFFE1">
    <td>附屬服務</td>
    <td><input type="text" name="service" size="120" maxlength="200"></td>
    <td>${acamp.service}<c:set var="service" value='${acamp.service}' /></td>
</tr><tr bgcolor="#F2F4FB">
    <td>停車方式</td>
    <td><input type="text" name="parking" size="120" maxlength="200"></td>
    <td>${acamp.parking}</td>
</tr>
</table>
</c:forEach>
<center>
<input type="submit" name="confirmupdate" value="確認" >
</center>
</form>
</body>
</html>