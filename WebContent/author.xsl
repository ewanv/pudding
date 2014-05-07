<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="page">
		<html>
			<head>
				<title><xsl:value-of select="@title"/></title>
				<style>
					table { border: solid 1px black; border-collapse:collapse; }
					table td { border: solid 1px #999; }
				</style>
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	<xsl:template match="author">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Date of Birth</th>
					<th>Bio</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><xsl:value-of select="name"/></td>
					<td><xsl:value-of select="dateOfBirth"/></td>
					<td><xsl:value-of select="bio"/></td>
				</tr>		
			</tbody>
		</table>
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="name|dateOfBirth|bio"/>
	<xsl:template match="articles">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Published Date</th>
					<th>Short Text</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<xsl:apply-templates />
			</tbody>
		</table>
	</xsl:template>
	<xsl:template match="article">
		<tr>
			<td>#<a href="article.jsp?id={@id}"><xsl:value-of select="@id"/></a></td>
			<xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="title|publishedDate|categoryTag|shortText">
		<td><xsl:apply-templates/></td>
	</xsl:template>
</xsl:stylesheet>