<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eatogo DB Manage Service</title>
</head>
<body>
	<h1>Eatogo Database 操作目錄</h1>
	<a href="CreateDatabase.do">建立Eatogo資料庫</a>
	<br>
	<a href="CreateAllTablesJDBC.do">建立Tables</a>
	<br>
	<a href="InsertFixedData.do">新增靜態資料</a>
	<br>
	<hr>
	<a href="CreateDatabase.do">重建Eatogo資料庫</a>
	<br>
	<a href="RecreateAllTablesJDBC.do">重建Tables</a>
	<br>
	<a href="InsertFixedData.do">重建靜態資料</a>
	<br>
	<br>
</body>
</html>
