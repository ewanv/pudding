<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl"/>
	<xsl:template name="content">
		<xsl:choose>
		<xsl:when test="loggedInAuthor">
			<p>Login successful. Click <a href="articles.jsp">here</a> to return to the main page.</p>
		</xsl:when>
		<xsl:otherwise>
			<p>Password incorrect. Click <a href="login.jsp">here</a> to try again.</p>
		</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>