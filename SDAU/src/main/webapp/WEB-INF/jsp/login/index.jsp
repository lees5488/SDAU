<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body onLoad="userIdfocus()">
    <form  id="loginForm" action="#springUrl('/login.htm')" method="post" onSubmit="return check();">

	<div>
		用户名：<input type="text" class="userName" name="userName">
	</div>
	<div>
		密码：<input type="password" name="password">
	</div>
	<div>
	 <div class="message"><span id="errorMessage"></span></div>
     <div class="submit"><input type="submit" class="btnSubmit" value="登录" onkeyup="javascript:if(event.keyCode==13){$('.btnSubmit').click()}"></div>
	</div>
	</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>

<script type="text/javascript">

function userIdfocus(){
	$("#userName").focus();
	$("#userName").select();
}
</script>
</body>
</html>