<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eatogo DB Manage Service</title>
<style>
div {
	width: 25%;
	float: left;
	text-align: center;
}
</style>
<script type="text/javascript">
function doSomethingOnDb(obj) {
	var dbUsername = document.getElementById("dbUsername").value;
	var dbPassword = document.getElementById("dbPassword").value;
	var queryString = '?dbUsername=' + dbUsername + '&dbPassword=' + dbPassword;
	
	var thingsToDo = obj.value;
	switch (thingsToDo) {
	case "建立Eatogo資料庫":
		document.dbConnectForm.action = "CreateDatabaseJDBC.do" + queryString;
		document.dbConnectForm.submit();	
	break;
	case "建立表格":
		document.dbConnectForm.action = "CreateAllTablesJDBC.do" + queryString;
		document.dbConnectForm.submit();	
	break;
	case "新增靜態資料":
		document.dbConnectForm.action = "InsertStaticDataJDBC.do" + queryString;
		document.dbConnectForm.submit();	
	break;
	case "重建資料庫":
		document.dbConnectForm.action = "CreateDatabaseJDBC.do" + queryString;
		document.dbConnectForm.submit();	
	break;
	case "重建表格":
		document.dbConnectForm.action = "RecreateAllTablesJDBC.do" + queryString;
		document.dbConnectForm.submit();	
	break;
	case "重建靜態資料":
		document.dbConnectForm.action = "InsertStaticDataJDBC.do" + queryString;
		document.dbConnectForm.submit();	
	break;
	}
};
</script>
</head>
<body>
	<h1>Eatogo Database 操作目錄</h1>
	<p style="color: red; font-weight: bold;">請確認瀏覽器Javascript已開啟</p>
	<form name="dbConnectForm">
		<p>DB Username <input type="text" name="dbUsername" id="dbUsername" required></p>
		<p>DB Password <input type="text" name="dbPassword" id="dbPassword"></p>
		<input type="reset" value="重填資料"><br>
		<input type="button" onclick="doSomethingOnDb(this)" value="建立Eatogo資料庫">
		<input type="button" onclick="doSomethingOnDb(this)" value="建立表格">
		<input type="button" onclick="doSomethingOnDb(this)" value="新增靜態資料"><br>
		<input type="button" onclick="doSomethingOnDb(this)" value="重建資料庫">
		<input type="button" onclick="doSomethingOnDb(this)" value="重建表格">
		<input type="button" onclick="doSomethingOnDb(this)" value="重建靜態資料">
	</form>
</body>
</html>
