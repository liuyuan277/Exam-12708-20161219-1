<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
        import="java.util.*"  
    import="com.hand.entity.*"
    import="com.hand.service.SelectLanguageService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body{
  margin:0px auto;
  padding:0px;
  text-align:center;
}
#tb{
	border-collapse: collapse;
}
</style>
</head>
<body>
<center>
<table width="400px" border="1" cellspacing="15" cellpadding="15" bordercolor="#CC9966"   id="tb">
  <tr><td>
    <form name="insert" action="insertFilmServlet" method="post"  target="_parent" align="center">
  TITLE:</td><td><input style="width:100%;" type="text" name="title"> </td> 
  </tr>
  <tr><td>
     DESCRIPTION:</td><td><input style="width:100%;" type="text" name="description"><br/></td>
  </tr>
    <tr><td>
     LANGUAGE:</td><td><select name="language">
     <%
          ArrayList<Language> list=SelectLanguageService.select();
          for(int i=0;i<list.size();i++ ){
       %> 
              <option value ="<%=list.get(i).getLanguage_id()%>"><%=list.get(i).getName()%></option> 
       <%  } %>
     </select></td>
 </tr>

 <tr style="text-align:center;" ><td colspan=2>
     <input type="submit" value="提交"/>  </td> </tr>
     </table>
     </center>
  </form>

</body>
</html>