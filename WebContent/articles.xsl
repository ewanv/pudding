<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl" />
	<xsl:template name="content">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="articles">
		<div class="row">
			<xsl:apply-templates />
		</div>
	</xsl:template>
	<xsl:template match="article">

		<!-- <div class="col-sm-3"> -->
		<div>
			<div class="thumbnail">
				<div class="caption">
					<h3>
						<xsl:value-of select="title" />
						<br />
						<small>
							<a href="author.jsp?id={author/id}">
								<xsl:value-of select="author/name" />
							</a>
						</small>
					</h3>
					<p>
						<xsl:value-of select="shortText" />
					</p>
					<small>
						<xsl:value-of select="publishedDate" />
						-
						<xsl:value-of select="categoryTag" />
					</small>
					<p>
						<a href="article.jsp?id={@id}" class="btn btn-primary" role="button">Read
							more</a>
					</p>
				</div>
			</div>
		</div>
	</xsl:template>
</xsl:stylesheet>