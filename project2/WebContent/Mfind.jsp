<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>露營地查詢</title>
<script type="text/javascript">
function setFocus()
{
     document.getElementById("id").focus();
}


function confirmDelete(n) {
	if (confirm("確定刪除此項露營地資料? ") ) {
		document.forms[0].action="CampServlet?cmd=DEL&id="+n;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}

function confirmupdate(a) {
    document.forms[0].action="CampServlet?cmd=Update&id="+a;
	document.forms[0].method="POST";
	document.forms[0].submit();
}


</script>
</head>
<body onload="setFocus()">
	<jsp:useBean id="dao" class="project.CampBean" scope="session" />
	<form action=".\CampServlet" method="post">
<center>
	<h2>露營地資訊</h2>
	<a href=".\CampAdd.jsp"><input type="button" name="add" value="新增" ></a>
			<table cellspacing="2" cellpadding="1" border="1">
				<tr>
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
					<td></td>
				</tr>
				<c:forEach items="${list2}" var="acamp" varStatus="status">
					<tr>
<!-- 					<form action="./CampServlet" method="post"> -->
						<td>${acamp.id}<c:set var="id" value='${acamp.id}' /></td>
						<td>${acamp.city}<c:set var="city" value='${acamp.city}' /></td>
						<td>${acamp.name}<c:set var="name" value='${acamp.name}' /></td>
						<td>${acamp.adress}<c:set var="adress" value='${acamp.adress}' /></td>
						<td>${acamp.tel}<c:set var="tel" value='${acamp.tel}' /></td>
						<td>${acamp.oprice}<c:set var="oprice" value='${acamp.oprice}' /></td>
						<td>${acamp.wprice}<c:set var="wprice" value='${acamp.wprice}' /></td>
						<td>${acamp.tentnum}<c:set var="tentnum" value='${acamp.tentnum}' /></td>
						<td>${acamp.elevation}<c:set var="elevation" value='${acamp.elevation}' /></td>
						<td>${acamp.feature}<c:set var="feature" value='${acamp.feature}' /></td>
						<td>${acamp.facility}<c:set var="facility" value='${acamp.facility}' /></td>
						<td>${acamp.pet}<c:set var="pet" value='${acamp.pet}' /></td>
						<td>${acamp.service}<c:set var="service" value='${acamp.service}' /></td>
						<td>${acamp.parking}<c:set var="parking" value='${acamp.parking}' /></td>  
						<td><input type="button" name="delete" value="刪除" onclick="confirmDelete(${acamp.id})"></td>
			            <td><input type="button" name="update" value="修改" onclick="confirmupdate(${acamp.id})"></td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</form>
</body>
</html>