<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
#tb{
	border-collapse: collapse;
	width: 400px;
}
#tb td,#tb th{
	border:1px solid bisque;
	padding: 15px;
}  
#tb th{
	text-align: left;
}
</style>
</head>
<body>
<center>

<table id="tb" >
<form action="loginChatServlet" method="post">
  <tr><th>用户名</th><th><input style="width:100%" type="text" id="username" name="username"></th></tr>
   <tr style="text-align:center;"><td colspan=2><input type="submit" value="登陆"></td></tr>
</form>   
</table>

</center>
</body>
</html>