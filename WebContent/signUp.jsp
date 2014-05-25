<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="form.xsl"?>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="uts.wsd.rest.LoremIpsum4J"%>
<%@page import="com.sun.xml.ws.util.StringUtils"%>
<%@page import="java.util.*"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="application/xml"%>
<% String authorsFilePath = application.getRealPath("WEB-INF/authors.xml"); %>
<jsp:useBean id="newsApp" class="uts.wsd.NewsApplication" scope="application">
    <jsp:setProperty name="newsApp" property="authorsFilePath" value="<%=authorsFilePath%>"/>
</jsp:useBean>
<jsp:useBean id="author" class="uts.wsd.Author" scope="page">
	<jsp:setProperty name="author" property="username"/>
	<jsp:setProperty name="author" property="password"/>
	<jsp:setProperty name="author" property="bio"/>
	<jsp:setProperty name="author" property="name"/>
</jsp:useBean>
<%
	session.invalidate();
	Authors authors = newsApp.getAuthors();
	HashMap<String,String> errors = new HashMap<String,String>();
	String formattedDateOfBirth = "";
	if(request.getMethod().equalsIgnoreCase("post")) {
		String dateOfBirthParam = request.getParameter("dateOfBirth");
		Date dateOfBirth = null;
		boolean parseDidFail = false;
		try {
			if(dateOfBirthParam != null && !dateOfBirthParam.equals(""))
				dateOfBirth = new SimpleDateFormat("dd/mm/yyyy").parse(dateOfBirthParam);
		} catch(ParseException e) {
			parseDidFail = true;
		}
		author.setDateOfBirth(dateOfBirth);
		if(author.getDateOfBirth() != null) {
			formattedDateOfBirth = new SimpleDateFormat("dd/mm/yyyy").format(author.getDateOfBirth());
		}
		// Check to make sure that no author already exists with the same username
		// Doesn't belong in the model, should go in the controller but controllers don't exist
		Author existingAuthor = authors.findAuthor(author.getUsername());
		if(author.isValid() && existingAuthor == null) {
			authors.addAuthor(author);
			newsApp.setAuthors(authors);
			response.sendRedirect("index.jsp");
		} else {
			errors = author.errors();
			if(parseDidFail) {
				// Date of birth didn't parse, so instead of telling users
				// it's blank, tell them it's incorrectly formatted
				errors.put("dateOfBirth", "Date of Birth incorrectly formatted");
			}
			if(existingAuthor != null) {
				errors.put("username", "Username already taken");
			}
		 }
	}
%>
<page title="Sign Up">
	<% if(errors.size() != 0) { %>
		<errors>
			<% for(String errorKey: errors.keySet()) { %>
				<error name="<%= errorKey %>"><%= errors.get(errorKey) %></error>
			<% } %>
		</errors>
	<% } %>
	<form method="post" action="signUp.jsp">
		<textField title="Username" name="username" value="<%= author.getUsername() != null ? author.getUsername() : "" %>"/>
		<passwordField title="Password" name="password"/>
		<textField title="Name" name="name" value="<%= author.getName() != null ? author.getName() : "" %>"/>
		<textArea title="Biography" name="bio" value="<%= author.getBio() != null ? author.getBio() : "" %>"/>
		<textField title="Date of Birth (dd/mm/yyyy)" name="dateOfBirth" value="<%= formattedDateOfBirth  %>"/>
		<submitButton title="Post Article"/>
	</form>
</page>