<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="author.xsl"?>
<%@page import="java.text.SimpleDateFormat"%>
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
	ArrayList<Article> articleList = null;
	if(author == null) {
		// Render a 404 page
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "Author not found");
	} else {
		articleList = articles.findArticlesWrittenByAuthor(author);
	}
		Author loggedInAuthor = (Author)session.getAttribute("author");
%>
<% if(author != null) { %>
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
				<% if(!article.isAuthorOnly() || loggedInAuthor != null) { %>
					<%
						// Grabs the first 200 characters of the article's full text
						String shortText = article.getFullText().substring(0, Math.min(article.getFullText().length(), 200));
						// Append ellipses if the text was truncated
						if(article.getFullText().length() > 200)
							shortText += "...";
					%> 
					<article id="<%= article.getId() %>">
						<title><%= article.getTitle() %></title>
						<publishedDate><%= new SimpleDateFormat("EEEEE, d MMMMM yyyy").format(article.getPublishedDate()) %></publishedDate>
						<shortText><%= shortText %></shortText>
						<categoryTag><%= article.getCategoryTag() %></categoryTag>
					</article>
				<% } %>
			<% } %>
		</articles>
	</author>
</page>
<% } %>