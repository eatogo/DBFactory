<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eatogo DB Manage Service</title>
<style>
.button {
	width: 120px;
	text-align: center;
	margin-right: 10px;
	margin-top: 10px;
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
	case "新增動態(假)資料":
		document.dbConnectForm.action = "InsertFakedDataJDBC.do" + queryString;
		document.dbConnectForm.submit();	
	break;
	}
};
</script>
</head>
<body>
	<h1>Eatogo Database 操作目錄</h1>
	<p style="color: red; font-weight: bold;">請確認瀏覽器Javascript已開啟</p>
	<p style="color: red; font-weight: bold;">直接輸入資料庫使用者名稱及密碼，不需要修改程式碼</p>
	<form name="dbConnectForm">
		<p>DB使用者名稱 <input type="text" name="dbUsername" placeholder="Username..." id="dbUsername" required></p>
		<p>DB使用者密碼 <input type="text" name="dbPassword" placeholder="Password..." id="dbPassword"></p>
		<input type="reset" value="重填資料"><hr>
		<input class="button" type="button" onclick="doSomethingOnDb(this)" value="建立Eatogo資料庫">
		<input class="button" type="button" onclick="doSomethingOnDb(this)" value="建立表格">
		<input class="button" type="button" onclick="doSomethingOnDb(this)" value="新增靜態資料">
		<input class="button" type="button" onclick="doSomethingOnDb(this)" value="新增動態(假)資料">
	</form>
</body>
</html>
