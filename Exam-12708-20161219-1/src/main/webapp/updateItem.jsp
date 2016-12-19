<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
        import="java.util.*"  
    import="com.hand.entity.*"
    import="com.hand.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
     <% 
           String film_id=request.getParameter("film_id");
           String language_id=request.getParameter("language_id");
     	  System.out.print(film_id+" " +language_id+"<<<<<<<<<<<<<<<");
           Film  film=new Film();
           film.setFilm_id(Integer.parseInt(film_id));
           SelectFilmService service=new SelectFilmService();
           Film f=service.selectFilm(film);
          // String pageNo=(String)session.getAttribute("curentPageNo");
          // session.setAttribute("curentPageNo",pageNo);
       %> 
  <form name="insert" action="updateFilmServlet" method="post"  target="_parent">
     TITLE:<input type="text" name="title" value="<%=f.getTitle()%>"><br/>
     CONTENT:<input type="text" name="description" value="<%=f.getDescription()%>"><br/>
     language:<select name="language">
     <%
          ArrayList<Language> list=SelectLanguageService.select();
          for(int i=0;i<list.size();i++ ){
        	  if(list.get(i).getLanguage_id()==Integer.parseInt(language_id)){
        %>
         <option value ="<%=list.get(i).getLanguage_id()%>" selected ><%=list.get(i).getName()%></option> 
        		  
      <%  }else{ %> 
              <option value ="<%=list.get(i).getLanguage_id()%>"><%=list.get(i).getName()%></option> 
        		  
        <% 	  } %> 
       <%  } %>
     </select>
   <input type="hidden" name="film_id" value="<%=film_id%>"><br/>
   
     <input type="submit"/>
  </form>
</body>
</html>