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
	<h1>DB操作目錄</h1>
	<a href="CreateDatabase.do">新增Eatogo資料庫</a>
	<fieldset>
		<legend>新增Schema</legend>
		<a href="CreateAllTablesJDBC.do">新增Tables(JDBC)</a><br> <a
			href="#">新增Tables(JNDI)</a><br> <a href="#">新增Tables(Hibernate)</a>
	</fieldset>
	<fieldset>
		<legend>新增資料</legend>
		<a href="#">新增靜態資料</a><br> <br> <a href="#">新增動態(假)資料</a>
	</fieldset>
	<fieldset>
		<legend>重建Schema</legend>
		<a href="RecreateAllTablesJDBC.do">重建Tables(JDBC)</a><br> <a
			href="#">重建Tables(JNDI)</a><br> <a href="#">重建Tables(Hibernate)</a>
	</fieldset>
</body>
</html>
