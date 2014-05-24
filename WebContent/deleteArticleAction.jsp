<?xml version="1.0" encoding="UTF-8"?>
<%@page import="com.sun.xml.ws.util.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="application/xml"%>
<% String articlesFilePath = application.getRealPath("WEB-INF/articles.xml"); %>
<!-- Will only be dealing with the articles of the newsApp, so no  need to load authors -->
<jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application">
    <jsp:setProperty name="newsApp" property="articlesFilePath" value="<%=articlesFilePath%>"/>
</jsp:useBean>
<%
	Author loggedInAuthor = (Author)session.getAttribute("author");

	Articles articles = newsApp.getArticles();
	Article article = articles.findArticle(Long.parseLong(request.getParameter("id")));
	if(article == null) {
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "Article not found");
	} else {
		// Ensures that only an article's author can delete their articles
		if(article.getAuthorId() == loggedInAuthor.getId()) {
			articles.removeArticle(article);
			newsApp.setArticles(articles);
		}
		response.sendRedirect("index.jsp");
	}
%>
