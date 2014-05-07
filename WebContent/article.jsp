<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="article.xsl"?>
<%@page import="com.sun.xml.ws.util.StringUtils"%>
<%@ page import="uts.wsd.*" %>
<%@page contentType="application/xml"%>
<jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application"/>
<%
	Articles articles = newsApp.getArticles();
	Authors authors = newsApp.getAuthors();
	long id = Long.parseLong(request.getParameter("id"));
	Article article = articles.findArticle(id);
%>
<page title="<%= article.getTitle() %>">
	<% Author author = authors.findAuthor(article.getAuthorId());  %>
	<article id="<%= article.getId() %>">
		<title><%= article.getTitle() %></title>
		<publishedDate><%= article.getPublishedDate() %></publishedDate>
		<text><%= article.getFullText() %></text>
		<author><%= author.getName() %></author>
		<categoryTag><%= article.getCategoryTag() %></categoryTag>
	</article>
</page>