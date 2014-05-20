<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="author.xsl"?>
<%@page import="java.util.*"%>
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
	Author author = authors.findAuthor(id);
	ArrayList<Article> articleList = articles.findArticlesWrittenByAuthor(author);
	Author loggedInAuthor = (Author)session.getAttribute("author");
%>
<page title="<%= author.getName() %>">
	<% if(loggedInAuthor != null) { %>
		<loggedInAuthor id="<%= loggedInAuthor.getId() %>"/>
	<% } %>
	<author id="<%= author.getId() %>">
		<name><%= author.getName() %></name>
		<dateOfBirth><%= author.getDateOfBirth() %></dateOfBirth>
		<bio><%= author.getBio() %></bio>
		<articles>
			<% for(Article article: articleList) { %>
				<article id="<%= article.getId() %>">
					<title><%= article.getTitle() %></title>
					<publishedDate><%= article.getPublishedDate() %></publishedDate>
					<shortText><%= article.getFullText().substring(0, Math.min(article.getFullText().length(), 40)) %></shortText>
					<categoryTag><%= article.getCategoryTag() %></categoryTag>
				</article>
			<% } %>
		</articles>
	</author>
</page>