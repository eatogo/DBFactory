<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eatogo DB Manage Service</title>
<style>
.button {
	width: 250px;
	text-align: center;
	margin-right: 10px;
	margin-top: 10px;
}
.warning {
	color: red;
	font-weight: bold;
}
</style>
<script>
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
			case "InsertStaticData":
				document.dbConnectForm.action = "InsertStaticDataJDBC.do";
				document.dbConnectForm.submit();
				break
			case "MoreFakeData":
				document.dbConnectForm.action = "InsertFakedDataJDBC.do";
				document.dbConnectForm.submit();
				break;
			case "AllInOne":
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
			DB使用者名稱 
			<input type="text" name="dbUsername"
				value="${param.dbUsername}" placeholder="Username..."
				id="dbUsername">
			<span id="errorMessage"></span>
		</p>
		<p>
			DB使用者密碼
			<input type="password" name="dbPassword"
				value="${param.dbPassword}" placeholder="Password..."
				id="dbPassword">
		</p>
		<button type="reset">重填資料</button>
		<hr>
		<p class="warning">注意，一鍵重建會將資料庫中所有資料重置</p>
		<button class="button" type="button" onclick="doSomethingOnDb(this)"
			value="AllInOne">一鍵(重)建立Eatogo資料庫</button>
		<hr>
		<button class="button" type="button" onclick="doSomethingOnDb(this)"
			value="InsertStaticData">增加靜態資料</button>
		<button class="button" type="button" onclick="doSomethingOnDb(this)"
			value="MoreFakeData">增加動態(假)資料</button>
	</form>
</body>
</html>