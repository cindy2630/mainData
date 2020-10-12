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
<title>查詢營區資料</title>
</head>
<body>
<center>
<h2>營區資料查詢</h2>
<form action=".\CampServlet" method="post">
<table  cellspacing="2" cellpadding="1" border="1">
<tr>
    <td>城市:</td>
    <td><INPUT TYPE="TEXT" NAME="city" ></td>
</tr>
</table>
<input type="submit" name="submitfind" value="送出">
</form>
</center>
</body>
</html>