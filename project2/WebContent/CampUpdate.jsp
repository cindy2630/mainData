 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增營區資料</title>
</head>
<body>
<h2>營區資料登入</h2>
<form action=".\CampServlet" method="post">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr>
    <td>編號:</td>
    <td><input type="text" name="id" maxlength="5"></td>
</tr><tr>
    <td>姓名:</td>
    <td><input type="text" name="name" size="10" maxlength="10"></td>
</tr><tr>
    <td>城市:</td>
    <td><input type="text" name="city" size="10" maxlength="10"></td>
</tr><tr>
    <td width="100">地址:</td>
    <td><input type="text" name="adress" size="120" maxlength="200"></td>
</tr><tr>
    <td>聯絡電話:</td>
    <td><input type="text" name="tel" size="20"></td>
</tr><tr>
    <td>平日價格:</td>
    <td><input type="text" name="oprice" maxlength="10"></td>
</tr><tr>
    <td>假日價格:</td>
    <td><input type="text" name="wprice" maxlength="10"></td>
</tr><tr>
    <td>帳篷數量:</td>
    <td><input type="text" name="tentnum" maxlength="10"></td>
</tr><tr>
    <td>海拔:</td>
    <td><input type="text" name="elevation" maxlength="10"></td>
</tr><tr>
    <td width="100">營區特色:</td>
    <td><input type="text" name="feature" size="120" maxlength="200"></td>
</tr><tr>
    <td width="100">附屬設施:</td>
    <td><input type="text" name="facility" size="120" maxlength="200"></td>
</tr><tr>
    <td width="100">攜帶寵物:</td>
    <td><input type="text" name="pet" size="120" maxlength="200"></td>
</tr><tr>
    <td width="100">附屬服務:</td>
    <td><input type="text" name="service" size="120" maxlength="200"></td>
</tr><tr>
    <td width="100">停車方式:</td>
    <td><input type="text" name="parking" size="120" maxlength="200"></td>
</tr>
</table>
<center>
<input type="submit" name="submit" value="送出">
</center>
</form>
</body>
</html>