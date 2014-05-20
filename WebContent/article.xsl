<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl"/>
	<xsl:template name="content">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="article">
		<h1 class="page-header">
			<xsl:value-of select="title"/>
			<br/>
			<small><a href="author.jsp?id={author/id}"><xsl:value-of select="author/name"/></a></small>
		</h1>
		<p>
			<xsl:value-of select="text"/>
		</p>
		<div class="well well-sm">
			<xsl:value-of select="publishedDate"/> | <xsl:value-of select="categoryTag"/> |  
			<xsl:if test="@deleteable = 'true'">
				<a href="deleteArticleAction.jsp?id={@id}" class="btn btn-danger btn-small">Delete</a>
			</xsl:if>
		</div>
	</xsl:template>
</xsl:stylesheet>