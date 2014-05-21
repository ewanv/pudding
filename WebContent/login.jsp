<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="form.xsl"?>
<%@page import="java.util.*"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="application/xml"%>
<% String authorsFilePath = application.getRealPath("WEB-INF/authors.xml"); %>
<%@page contentType="application/xml"%><jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application">
    <jsp:setProperty name="newsApp" property="authorsFilePath" value="<%=authorsFilePath%>"/>
</jsp:useBean>
<%
	session.setAttribute("author", null);
	HashMap<String,String> errors = new HashMap<String,String>();
	String username = "";
	String password = "";
	if(request.getMethod().equalsIgnoreCase("post")) {
		Authors authors = newsApp.getAuthors();
		username = request.getParameter("username");
		password = request.getParameter("password");
		Author author = authors.login(username, password);
		if(author != null) {
			session.setAttribute("author", author);
			response.sendRedirect("index.jsp");
		} else {
			if(username == null || username.equals("")){
				errors.put("username","Username can't be blank");
			}
			if(password == null || password.equals("")){
				errors.put("password","Password can't be blank");
			}
			if(errors.size() == 0) { //If password and username are present
				errors.put("page","Username or password incorrect");
			}
		}
	}
%>
<page title="Login">
	<% if(errors.size() != 0) { %>
		<errors>
			<% for(String errorKey: errors.keySet()) { %>
				<error name="<%= errorKey %>"><%= errors.get(errorKey) %></error>
			<% } %>
		</errors>
	<% } %>
	<form method="post" action="login.jsp">
		<textField title="Username" name="username" value="<%= username %>"/>
		<passwordField title="Password" name="password"/>
		<submitButton title="Login"/>
	</form>
</page>