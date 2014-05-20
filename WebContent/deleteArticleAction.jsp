<?xml version="1.0" encoding="UTF-8"?>
<%@page import="com.sun.xml.ws.util.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="application/xml"%>
<% String articlesFilePath = application.getRealPath("WEB-INF/articles.xml"); %>
<jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application">
    <jsp:setProperty name="newsApp" property="articlesFilePath" value="<%=articlesFilePath%>"/>
</jsp:useBean>
<%
	Author loggedInAuthor = (Author)session.getAttribute("author");

	Articles articles = newsApp.getArticles();
	Article article = articles.findArticle(Long.parseLong(request.getParameter("id")));
	if(article.getAuthorId() == loggedInAuthor.getId()) {
		articles.removeArticle(article);
		newsApp.setArticles(articles);
	}
	response.sendRedirect("index.jsp");
%>