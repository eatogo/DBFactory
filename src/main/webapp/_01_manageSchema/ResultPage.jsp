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
		<c:when test="${not empty FixedDataInserted}">
			<p>靜態資料建立成功</p>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${not empty DatabaseCreated}">
					<p>Eatogo資料庫建立成功</p>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${not empty TablesCreated}">
							<p>Tables建立成功</p>
						</c:when>
						<c:otherwise>
							<p>動作不成功</p>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<a href='/DBFactory/index.jsp'>回首頁</a>
</body>
</html>