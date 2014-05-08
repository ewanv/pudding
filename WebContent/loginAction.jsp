<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="loginAction.xsl"?>
<%@page import="java.util.*"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="application/xml"%>
<% String authorsFilePath = application.getRealPath("WEB-INF/authors.xml"); %>
<% String articlesFilePath = application.getRealPath("WEB-INF/articles.xml"); %>
<jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application">
    <jsp:setProperty name="newsApp" property="authorsFilePath" value="<%=authorsFilePath%>"/>
    <jsp:setProperty name="newsApp" property="articlesFilePath" value="<%=articlesFilePath%>"/>
</jsp:useBean>
<%
	Authors authors = newsApp.getAuthors();
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	Author author = authors.login(username, password);
	if(author != null) {
		session.setAttribute("author", author);
	}
%>
<page title="Dashboard">
	<% if(author != null) { %>
		<loggedInAuthor id="<%= author.getId() %>"/>
	<% } %>
</page>