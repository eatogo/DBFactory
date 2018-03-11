<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eatogo DB Management</title>
<style>
.button {
	width: 250px;
	text-align: center;
	margin-right: 10px;
}
.warning {
	color: red;
	font-weight: bold;
}
</style>
<script>
	function doSomething(obj) {
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
				document.dbConnectForm.action = "InsertStaticData.do";
				document.dbConnectForm.submit();
				break
			case "MoreFakeData":
				document.dbConnectForm.action = "InsertFakeData.do";
				document.dbConnectForm.submit();
				break;
			case "AllInOne":
				document.dbConnectForm.action = "CreateAll.do";
				document.dbConnectForm.submit();
				break;
			}
		}
	};
</script>
</head>
<body>
	<h1>Eatogo Database 操作目錄</h1>
	<h2 class="warning">注意事項</h2>
	<ul>
		<li>請確認瀏覽器Javascript已開啟</li>
		<li>請輸入您本地資料庫的使用者名稱及密碼，若無密碼可只填使用者名稱</li>
		<li>注意一鍵重建會將資料庫中所有資料重置</li>
	</ul>
	<hr>
	<form name="dbConnectForm" method="post">
		<p>DB使用者名稱 
			<input type="text" name="dbUsername" id="dbUsername"
				value="${param.dbUsername}" placeholder="Username...">
			<span id="errorMessage"></span>
		</p>
		<p>DB使用者密碼
			<input type="password" name="dbPassword" id="dbPassword"
				value="${param.dbPassword}" placeholder="Password...">
		</p>
		<button type="reset">重填資料</button>
		<hr>
		<h2>主要選項</h2>
		<button class="button" type="button" onclick="doSomething(this)" value="AllInOne">一鍵(重)建立Eatogo資料庫</button>
		<hr>
		<h2>單獨選項</h2>
		<button class="button" type="button" onclick="doSomething(this)" value="InsertStaticData">建立靜態資料</button>
		<button class="button" type="button" onclick="doSomething(this)" value="MoreFakeData">增加動態(假)資料</button>
	</form>
</body>
</html>