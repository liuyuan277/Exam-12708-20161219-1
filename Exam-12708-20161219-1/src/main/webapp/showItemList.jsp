<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.*" 
    import="com.hand.util.*"     
    import="com.hand.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>             
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="bootstrap.min.css" type="text/css" rel="stylesheet"> 
<style type="text/css">
#tb{
	border-collapse: collapse;
	width: 100%;
}
#tb td,#tb th{
	border:1px solid bisque;
	padding: 5px;
}  
#tb th{
	text-align: right;
	background-color: aqua;
	color: #FFFFFF;
}
#tb tr.alt td{
	color: black;
	background-color: aquamarine;
}
</style>
<script type="text/javascript">
function sumbit_sure(){  
	   var gnl=confirm("确定要删除?");  
	   if (gnl==true){  
	       return true;  
	   }else{  
	     return false;  
	   }  
	 }
</script>
</head>

<body>
<%
PageUtil p=(PageUtil)session.getAttribute("page");
if(p!=null){%>
<div>
  <a href="insertItem.jsp" target="_self">新增电影</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome <%=(String)session.getAttribute("OnLineUser") %>&nbsp;&nbsp;&nbsp;&nbsp;<a href="main.jsp">返回首页</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="loginOutServlet"  target="_parent">退出</a><br />          
</div>
     <table  id="tb" width="95%" border="1" cellspacing="1" cellpadding="1" bordercolor="#CC9966">
          <tr align="center"> 
            <th>序号</th><th>Title</th><th>description</th><th>language_id</th>
             <th>Update</th>
             <th>Delete</th> 
          </tr>
<%

   ArrayList<Film> list=p.getData();
   session.setAttribute("curentPageNo", p.getPageNo());
   for(int i=0;i<list.size();i++){ 
       if(i%2 == 0){%>
          <tr align="center">
          <td><%=list.get(i).getFilm_id()%></td>
          <td><%=list.get(i).getTitle()%></td>
          <td><%= list.get(i).getDescription()%></td>
          <td><%=list.get(i).getLanguage()%></td>
          
           <form name="update" method="post" action="updateItem.jsp"  target="_self">
			 <input type="hidden" name="film_id" value="<%=list.get(i).getFilm_id()%>" >
			 <input type="hidden" name="language_id" value="<%=list.get(i).getLanguage_id()%>" >
			 <td align=center width=55> <input type="submit" name="update" value="update" type="button" class="btn btn-success"></td>
          </form>
          
           <form name="delete" method="post" action="deleteFilmServlet" target="_self" onsubmit="return sumbit_sure()">
			 <input type="hidden" name="film_id" value="<%=list.get(i).getFilm_id()%>" >
			 <td align=center width=55> <input type="submit" name="del" value="delete" type="button" class="btn btn-danger"></td>
          </form>
       </tr>  
    <% }else{%> 
   
    	  <tr align="center" class="alt">
          <td><%=list.get(i).getFilm_id()%></td>
          <td><%=list.get(i).getTitle()%></td>
          <td><%= list.get(i).getDescription()%></td>
          <td><%=list.get(i).getLanguage()%></td>
          
           <form name="update" method="post" action="updateItem.jsp"  target="_self">
			 <input type="hidden" name="film_id" value="<%=list.get(i).getFilm_id()%>" >
			 <input type="hidden" name="language_id" value="<%=list.get(i).getLanguage_id()%>" >
			 <td align=center width=55> <input type="submit" name="update" value="update" type="button" class="btn btn-success"></td>
          </form>
          
           <form name="delete" method="post" action="deleteFilmServlet" target="_self" onsubmit="return sumbit_sure()">
			 <input type="hidden" name="film_id" value="<%=list.get(i).getFilm_id()%>" >
			 <td align=center width=55> <input type="submit" name="del" value="delete" type="button" class="btn btn-danger"></td>
          </form>
       </tr> 
         
   <% }} %>     
   </table>
<tr><td  colspan="7" rowspan="2" align="right">
                总共【<%=p.getTotalPage()%>】页 &nbsp;&nbsp;<%=p.getPageNo() %>/<%=p.getTotalPage()%>&nbsp;&nbsp; <a href="selectFilmByPageServlet?pageNo=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <%
                   if(p.getPageNo() > 1){%>
                	   <a href="selectFilmByPageServlet?method=showPage&pageNo=<%=p.getPageNo()-1%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <%   }else{ %>
                                               上一页  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <%    }  %> 
                
                 <% if( p.getPageNo() <p.getTotalPage()){ %>
                	<a href="selectFilmByPageServlet?method=showPage&pageNo=<%=p.getPageNo()+1%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <%}else{ %>  
                                          下一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <% }  %>    
                  <a href="selectFilmByPageServlet?method=showPage&pageNo=<%=p.getTotalPage()%>">尾页</a>          </td>
            </tr>
</body>	
<% } %>

</html>