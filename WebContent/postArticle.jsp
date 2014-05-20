<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="form.xsl"?>
<%@page import="com.sun.xml.ws.util.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="application/xml"%>
<% String authorsFilePath = application.getRealPath("WEB-INF/authors.xml"); %>
<% String articlesFilePath = application.getRealPath("WEB-INF/articles.xml"); %>
<jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application">
    <jsp:setProperty name="newsApp" property="authorsFilePath" value="<%=authorsFilePath%>"/>
    <jsp:setProperty name="newsApp" property="articlesFilePath" value="<%=articlesFilePath%>"/>
</jsp:useBean>
<jsp:useBean id="article" class="uts.wsd.Article" scope="page">
	<jsp:setProperty name="article" property="*"/>
</jsp:useBean>
<%
	Author loggedInAuthor = (Author)session.getAttribute("author");

	Articles articles = newsApp.getArticles();
	ArrayList<String> errors = null;
	String title = "";
	String fullText = "";
	String categoryTag = "";
	if(request.getMethod().equalsIgnoreCase("post")) {
		title = request.getParameter("title");
		fullText = request.getParameter("fullText");
		categoryTag = request.getParameter("categoryTag");
		boolean validArticle = true;
		if(article.isValid()) {
			articles.addArticle(article);
			newsApp.setArticles(articles);
			response.sendRedirect("index.jsp");
		} else {
			errors = article.errors();
		}
	}
%>
<page title="Post Article">
	<% if(loggedInAuthor != null) { %>
	<loggedInAuthor id="<%= loggedInAuthor.getId() %>"/>
	<% if(errors != null) { %>
		<errors>
			<% for(String error: errors) { %>
				<error><%= error %></error>
			<% } %>
		</errors>
	<% } %>
	<form method="post" action="postArticle.jsp">
		<textField title="Title" name="title" value="<%= title %>"/>
		<textArea title="Full Text" name="fullText" value="<%= fullText %>"/>
		<textField title="Category" name="categoryTag" value="<%= categoryTag %>"/>
		<hiddenField name="authorId" value="<%= loggedInAuthor.getId() %>"/>
		<submitButton title="Post Article"/>
	</form>
	<% } %>
</page>