<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.*"  
    import="com.hand.util.*"
    import="com.hand.service.SelectLanguageService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
//int pageNo=1;
//PageUtil p=(PageUtil)session.getAttribute("page");
//if(p!=null){
//	pageNo=p.getPageNo();	
//}
//System.out.print("selectFilmByPageServlet?pageNo=+"+pageNo);
%>

<a href="selectFilmByPageServlet?pageNo=1"  target="_center">查看电影</a><br>
<a href="insertItem.jsp" target="_center">新增电影</a>
</body>
</html>