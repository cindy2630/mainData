<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>新增資料如下請確認</h2>
<form action=".\CampServlet" method="post">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#FFFFE1">
    <td>編號:</td>
    <td><jsp:getProperty name="dao" property="id" /></td>
</tr><tr bgcolor="#F2F4FB">
    <td>姓名:</td>
    <td><jsp:getProperty name="dao" property="name" /></td>
</tr><tr bgcolor="#FFFFE1">
    <td>城市:</td>
    <td><jsp:getProperty name="dao"  property="city" /></td>
</tr><tr bgcolor="#F2F4FB">
    <td width="150">地址:</td>
    <td><jsp:getProperty name="dao" property="adress" /></td>
</tr><tr bgcolor="#FFFFE1">
    <td>聯絡電話</td>
    <td><jsp:getProperty name="dao" property="tel" /></td>
</tr><tr bgcolor="#F2F4FB">
    <td>平日價格</td>
    <td><jsp:getProperty name="dao" property="oprice" /></td>
</tr><tr bgcolor="#FFFFE1">
    <td>假日價格</td>
    <td><jsp:getProperty name="dao" property="wprice" /></td>
</tr><tr bgcolor="#F2F4FB">
    <td>帳篷數量</td>
    <td><jsp:getProperty name="dao" property="tentnum" /></td>
</tr><tr bgcolor="#FFFFE1">
    <td>海拔</td>
    <td><jsp:getProperty name="dao" property="elevation" /></td>
</tr><tr bgcolor="#F2F4FB">
    <td>營區特色</td>
    <td><jsp:getProperty name="dao" property="feature" /></td>
</tr><tr bgcolor="#FFFFE1">
    <td>附屬設施</td>
    <td><jsp:getProperty name="dao" property="facility" /></td>
</tr><tr bgcolor="#F2F4FB">
    <td>攜帶寵物</td>
    <td><jsp:getProperty name="dao" property="pet" /></td>
</tr><tr bgcolor="#FFFFE1">
    <td>附屬服務</td>
    <td><jsp:getProperty name="dao" property="service" /></td>
</tr><tr bgcolor="#F2F4FB">
    <td>停車方式</td>
    <td><jsp:getProperty name="dao" property="parking" /></td>
</tr>
</table>
<center>
<input type="submit" name="confirmshow" value="確認" >
</center>
</form>
</body>
</html>