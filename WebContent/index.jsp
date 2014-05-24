<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="articles.xsl"?>
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
	Author loggedInAuthor = (Author)session.getAttribute("author");
%>
<page title="Articles">
	<% if(loggedInAuthor != null) { %>
		<loggedInAuthor id="<%= loggedInAuthor.getId() %>"/>
	<% } %>
	<articles>
		<% for(Article article: articles.getArticles()) { %>
			<% if(!article.isAuthorOnly() || loggedInAuthor != null) { %>
				<% Author author = authors.findAuthor(article.getAuthorId());  %>
				<article id="<%= article.getId() %>">
					<title><%= article.getTitle() %></title>
					<publishedDate><%= new SimpleDateFormat("EEEEE, d MMMMM yyyy").format(article.getPublishedDate()) %></publishedDate>
					<!-- Grabs the first 40 characters of the article's full text to use as a short snippet -->
					<shortText><%= article.getFullText().substring(0, Math.min(article.getFullText().length(), 80)) + "..." %></shortText>
					<author>
						<name><%= author.getName() %></name>
						<id><%= article.getAuthorId() %></id>
					</author>
					<categoryTag><%= article.getCategoryTag() %></categoryTag>
				</article>
			<% } %>
		<% } %>
	</articles>
</page>