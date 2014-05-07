<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="page">
		<html>
			<head>
				<title><xsl:value-of select="@title"/></title>
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	<xsl:template match="articles">
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Published Date</th>
					<th>Author</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<xsl:apply-templates />
			</tbody>
		</table>
	</xsl:template>
	<xsl:template match="article">
		<tr><xsl:apply-templates/></tr>
	</xsl:template>
	<xsl:template match="title|publishedDate|author|categoryTag">
		<td><xsl:apply-templates/></td>
	</xsl:template>
</xsl:stylesheet>