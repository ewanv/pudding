<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="articles.xsl"?>
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
%>
<page title="Articles">
	<articles>
		<% for(Article article: articles.getArticles()) { %>
			<% Author author = authors.findAuthor(article.getAuthorId());  %>
			<article id="<%= article.getId() %>">
				<title><%= article.getTitle() %></title>
				<publishedDate><%= article.getPublishedDate() %></publishedDate>
				<author><%= author.getName() %></author>
				<categoryTag><%= article.getCategoryTag() %></categoryTag>
			</article>
		<% } %>
	</articles>
</page>