<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eatogo DB Management Service</title>
</head>
<body>
	<h1>新建Eatogo資料庫</h1>
	<p>${sqlResult}</p>
	<c:choose>
		<c:when test="${not empty sqlResult}">
			<p>Eatogo資料庫建立成功</p>
		</c:when>
		<c:otherwise>
			<p>Eatogo資料庫建立不成功</p>
		</c:otherwise>
	</c:choose>
	<a href='/DBFactory/index.jsp'>回首頁</a>
</body>
</html>