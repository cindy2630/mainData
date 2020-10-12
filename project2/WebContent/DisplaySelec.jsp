<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>露營地查詢</title>
</head>
<body>
<jsp:useBean id="dao" class="project.CampBean" scope="session" />
<h2>露營地資訊</h2>
<form action=".\CampServlet" method="post">
<center>
<table  cellspacing="2" cellpadding="1" border="1" >
<tr> 
<td></td> 
<td>編號</td>  
<td>城市</td>  
<td>露營地</td>  
<td>地址</td> 
<td>電話</td> 
<td>平日價格</td> 
<td>假日價格</td> 
<td>帳篷數量</td> 
<td>海拔</td> 
<td>營區特色</td> 
<td>附屬設施</td> 
<td>攜帶寵物</td> 
<td>附屬服務</td> 
<td>停車方式</td> 
</tr> 
<c:forEach items="${list2}" var="acamp" varStatus="status">
                        <tr >
                            <td><input type="checkbox" /></td>
                            <td>${acamp.id}</td>
                            <td>${acamp.city}</td>
                            <td>${acamp.name}</td>
                            <td>${acamp.adress}</td>
                            <td>${acamp.tel}</td>
                            <td>${acamp.oprice}</td>
                            <td>${acamp.wprice}</td>
                            <td>${acamp.tentnum}</td>
                            <td>${acamp.elevation}</td>
                            <td>${acamp.feature}</td>
                            <td>${acamp.facility}</td>
                            <td>${acamp.pet}</td>
                            <td>${acamp.service}</td>
                            <td>${acamp.parking}</td>
                        </tr>
                    </c:forEach>
</table>
</center>
</form>
</body>
</html>