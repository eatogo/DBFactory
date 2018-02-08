<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eatogo DB Management Service</title>
</head>
<body>
	<h1>動作結果：</h1>
	<c:choose>
		<c:when test="${not empty AllSchemaCreated}">
			<p>一鍵建立Eatogo資料庫成功</p>
		</c:when>
		<c:when test="${not empty ViewsCreated}">
			<p>Views建立成功</p>
		</c:when>
		<c:when test="${not empty FakedDataInserted}">
			<p>動態(假)資料建立成功</p>
		</c:when>
		<c:when test="${not empty FixedDataInserted}">
			<p>靜態資料建立成功</p>
		</c:when>
		<c:when test="${not empty DatabaseCreated}">
			<p>Eatogo資料庫建立成功</p>
		</c:when>
		<c:when test="${not empty TablesCreated}">
			<p>Tables建立成功</p>
		</c:when>
		<c:otherwise>
			<p>動作不成功</p>
		</c:otherwise>
	</c:choose>
	<form action="/DBFactory/index.jsp" method="post">
		<input type="hidden" name="dbUsername" value="${dbUsername}"><br>
		<input type="hidden" name="dbPassword" value="${dbPassword}"><br>
		<button type="submit">回首頁</button>
	</form>
</body>
</html>