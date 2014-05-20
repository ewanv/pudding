<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl"/>
	<xsl:template name="content">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="author">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="name">
		<h1 class="page-header"><xsl:apply-templates/></h1>
	</xsl:template>
	<xsl:template match="dateOfBirth">
		<p>Born: <xsl:apply-templates /></p>
	</xsl:template>
	<xsl:template match="bio">
		<p><xsl:apply-templates /></p>
	</xsl:template>
	<xsl:template match="articles">
		<div class="list-group">
			<xsl:apply-templates />
		</div>
	</xsl:template>
	<xsl:template match="article">
		<a href="article.jsp?id={@id}" class="list-group-item">
			<xsl:apply-templates select="title|shortText"/>
			<small><xsl:apply-templates select="publishedDate|categoryTag"/></small>
		</a>
	</xsl:template>
	<xsl:template match="title">
		<h4 class="list-group-item-heading"><xsl:apply-templates /></h4>
	</xsl:template>
	<xsl:template match="shortText">
		<p class="list-group-item-text"><xsl:apply-templates /></p>
	</xsl:template>
	<xsl:template match="publishedDate|categoryTag">
		<xsl:apply-templates /> |
	</xsl:template>
</xsl:stylesheet>