<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="article.xsl"?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sun.xml.ws.util.StringUtils"%>
<%@ page import="uts.wsd.*" %>
<%@page contentType="application/xml"%>
<% String authorsFilePath = application.getRealPath("WEB-INF/authors.xml"); %>
<% String articlesFilePath = application.getRealPath("WEB-INF/articles.xml"); %>
<jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application">
    <jsp:setProperty name="newsApp" property="authorsFilePath" value="<%=authorsFilePath%>"/>
    <jsp:setProperty name="newsApp" property="articlesFilePath" value="<%=articlesFilePath%>"/>
</jsp:useBean>
<%
	Articles articles = newsApp.getArticles();
	Authors authors = newsApp.getAuthors();
	long id = Long.parseLong(request.getParameter("id"));
	Article article = articles.findArticle(id);
	Author loggedInAuthor = (Author)session.getAttribute("author");
	if(article == null) {
		// Render a 404 page
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "Article not found");
	}
%>
<% if(article != null) { %>
	<page title="<%= article.getTitle() %>">
		<% if(loggedInAuthor != null) { %>
			<loggedInAuthor id="<%= loggedInAuthor.getId() %>"/>
		<% } %>
		<% if(!article.isAuthorOnly() || loggedInAuthor != null) { %>
			<% Author author = authors.findAuthor(article.getAuthorId());  %>
			<article id="<%= article.getId() %>" deleteable="<%= loggedInAuthor != null && loggedInAuthor.getId() == article.getAuthorId() %>">
				<title><%= article.getTitle() %></title>
				<publishedDate><%= new SimpleDateFormat("EEEEE, d MMMMM yyyy").format(article.getPublishedDate()) %></publishedDate>
				<text><%= article.getFullText() %></text>
				<author>
					<name><%= author.getName() %></name>
					<id><%= article.getAuthorId() %></id>
				</author>
				<categoryTag><%= article.getCategoryTag() %></categoryTag>
			</article>
		<% } %>
	</page>
<% } %>