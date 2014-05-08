<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="form.xsl"?>
<%@page contentType="application/xml"%>
<%
	session.setAttribute("author", null);
%>
<page title="Login">
	<form method="post" action="loginAction.jsp">
		<textField title="Username" name="username"/>
		<passwordField title="Password" name="password"/>
		<submitButton title="Login"/>
	</form>
</page>