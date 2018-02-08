<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eatogo DB Manage Service</title>
<style>
.button {
	width: 150px;
	text-align: center;
	margin-right: 10px;
	margin-top: 10px;
}

.warning {
	color: red;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	function doSomethingOnDb(obj) {
		var dbUsername = document.getElementById("dbUsername");
		var errorMessage = document.getElementById("errorMessage");
		if (dbUsername.value == null || dbUsername.value == "") {
			text = document.createTextNode(" DB名稱未填");
			errorMessage.className = "warning";
			errorMessage.appendChild(text);
		} else {
			var thingsToDo = obj.value;
			switch (thingsToDo) {
			/* case "建立Eatogo資料庫":
				document.dbConnectForm.action = "CreateDatabaseJDBC.do";
				document.dbConnectForm.submit();
				break;
			case "建立表格":
				document.dbConnectForm.action = "CreateAllTablesJDBC.do";
				document.dbConnectForm.submit();
				break;
			case "新增靜態資料":
				document.dbConnectForm.action = "InsertStaticDataJDBC.do";
				document.dbConnectForm.submit();
				break;
			case "新增Views":
				document.dbConnectForm.action = "CreateAllViews.do";
				document.dbConnectForm.submit();
				break; */
			case "新增動態(假)資料":
				document.dbConnectForm.action = "InsertFakedDataJDBC.do";
				document.dbConnectForm.submit();
				break;
			case "一鍵(重)建立Eatogo資料庫":
				document.dbConnectForm.action = "CreateAllSchema.do";
				document.dbConnectForm.submit();
				break;
			}
		}
	};
</script>
</head>
<body>
	<h1>Eatogo Database 操作目錄</h1>
	<p class="warning">請確認瀏覽器Javascript已開啟</p>
	<hr>
	<form name="dbConnectForm" method="post">
		<p class="warning">直接輸入資料庫使用者名稱及密碼，不需要修改程式碼</p>
		<p>
			DB使用者名稱 <input type="text" name="dbUsername"
				value="${param.dbUsername}" placeholder="Username..."
				id="dbUsername"><span id="errorMessage"></span>
		</p>
		<p>
			DB使用者密碼 <input type="text" name="dbPassword"
				value="${param.dbPassword}" placeholder="Password..."
				id="dbPassword">
		</p>
		<input type="reset" value="重填資料">
		<hr>
		<p class="warning">注意，一鍵重建會將資料庫中所有資料重置</p>
		<input class="button" type="button" onclick="doSomethingOnDb(this)"
			value="一鍵(重)建立Eatogo資料庫">
		<hr>
		<input class="button" type="button" onclick="doSomethingOnDb(this)"
			value="增加動態(假)資料">
	</form>
</body>
</html>
<!-- <input class="button" type="button" onclick="doSomethingOnDb(this)"
			value="建立Eatogo資料庫">
		<input class="button" type="button"
			onclick="doSomethingOnDb(this)" value="建立表格">
		<input
			class="button" type="button" onclick="doSomethingOnDb(this)"
			value="新增靜態資料">
		<input
			class="button" type="button" onclick="doSomethingOnDb(this)"
			value="新增Views"> -->