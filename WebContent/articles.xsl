<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl"/>
	<xsl:template name="content">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="articles">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Published Date</th>
					<th>Short Text</th>
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
		<tr>
			<td>#<a href="article.jsp?id={@id}"><xsl:value-of select="@id"/></a></td>
			<xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="title|publishedDate|categoryTag|shortText">
		<td><xsl:apply-templates/></td>
	</xsl:template>
	<xsl:template match="author">
		<td><a href="author.jsp?id={id}"><xsl:value-of select="name"/></a></td>
	</xsl:template>
</xsl:stylesheet>