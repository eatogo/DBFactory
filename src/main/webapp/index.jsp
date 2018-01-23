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
	<fieldset>
		<legend>新增Eatogo資料庫</legend>
		<a href="CreateAllTablesJDBC.do">JDBC</a><br> <a
			href="CreateAllTablesJNDI.do">JNDI</a><br> <a
			href="CreateAllTablesHibernate.do">Hibernate</a>
	</fieldset>
	<a href="InsertStaticData.do">新增靜態資料</a><br>
	<hr>
	<a href="InsertDynamicData.do">新增動態(假)資料</a>
</body>
</html>
