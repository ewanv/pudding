<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="form.xsl"?>
<%@page import="uts.wsd.rest.LoremIpsum4J"%>
<%@page import="com.sun.xml.ws.util.StringUtils"%>
<%@page import="java.util.*"%>
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
	HashMap<String,String> errors = new HashMap<String,String>();
	String title = "";
	String fullText = "";
	String categoryTag = "";
	String generateText = "";
	if(request.getMethod().equalsIgnoreCase("post") && loggedInAuthor != null) {
		title = request.getParameter("title");
		fullText = request.getParameter("fullText");
		categoryTag = request.getParameter("categoryTag");
		generateText = request.getParameter("generateText");
		if (generateText != null && generateText.equals("true")) {
			LoremIpsum4J lipsumGenerator = new LoremIpsum4J();
			String[] paragraphs = lipsumGenerator.getParagraphs(5);
			for (int i = 0; i < paragraphs.length; i++) {
				fullText = paragraphs[i];
			}
			article.setFullText(fullText);
		}
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
	<% if(errors.size() != 0) { %>
		<errors>
			<% for(String errorKey: errors.keySet()) { %>
				<error name="<%= errorKey %>"><%= errors.get(errorKey) %></error>
			<% } %>
		</errors>
	<% } %>
	<form method="post" action="postArticle.jsp">
		<textField title="Title" name="title" value="<%= title %>"/>
		<textArea title="Full Text" name="fullText" value="<%= fullText %>"/>
		<checkbox title="Generate article text" name="generateText" checked="<%= generateText %>"/>
		<selectField title="Category" name="categoryTag" value="<%= categoryTag %>">
			<selectOption value="News" selected="<%= categoryTag.equals("News") %>">News</selectOption>
			<selectOption value="Entertainment" selected="<%= categoryTag.equals("Entertainment") %>">Entertainment</selectOption>
			<selectOption value="Sport" selected="<%= categoryTag.equals("Sport") %>">Sport</selectOption>
			<selectOption value="Business" selected="<%= categoryTag.equals("Business") %>">Business</selectOption>
			<selectOption value="Finance" selected="<%= categoryTag.equals("Finance") %>">Finance</selectOption>
			<selectOption value="Technology" selected="<%= categoryTag.equals("Technology") %>">Technology</selectOption>
		</selectField>
		<hiddenField name="authorId" value="<%= loggedInAuthor.getId() %>"/>
		<submitButton title="Post Article"/>
	</form>
	<% } %>
</page>