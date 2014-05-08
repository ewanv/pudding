<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl"/>
	<xsl:template name="content">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="article">
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Published Date</th>
					<th>Text</th>
					<th>Author</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<xsl:apply-templates />
				</tr>
			</tbody>
		</table>
	</xsl:template>
	<xsl:template match="title|publishedDate|categoryTag|text">
		<td><xsl:apply-templates/></td>
	</xsl:template>
	<xsl:template match="author">
		<td><a href="author.jsp?id={id}"><xsl:value-of select="name"/></a></td>
	</xsl:template>
</xsl:stylesheet>