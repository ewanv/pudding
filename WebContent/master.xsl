<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="page">
		<html>
			<head>
				<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
				<script src="bootstrap/js/bootstrap.min.js" />
				<title>
					<xsl:value-of select="@title" />
				</title>
			</head>
			<body>
				<xsl:call-template name="nav"/>
				<div class="container">
					<xsl:call-template name="content" />
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template name="content">
		<!-- Only displayed if an XSL stylesheet which imports master is missing a content template.
		Serves to remind developers if they forget. -->
		<span style="color: red">Content template is empty - overrule in page
			template.</span>
	</xsl:template>

	<!-- Standard bootstrap navigation markup. It's possible to add more to allow for
	a responsive navigation bar, but that's unnecessary for this application -->
	<xsl:template name="nav">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">

					<a class="navbar-brand" href="index.jsp">NewsApplication</a>
				</div>

				<ul class="nav navbar-nav">
					<li>
						<a href="index.jsp">Articles</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<xsl:choose>
						<xsl:when test="loggedInAuthor">
							<li>
								<a href="postArticle.jsp">Post Article</a>
							</li>
							<li>
								<a href="logout.jsp">Logout</a>
							</li>
						</xsl:when>
						<xsl:otherwise>
							<li>
								<a href="login.jsp">Login</a>
							</li>
						</xsl:otherwise>
					</xsl:choose>
				</ul>
			</div>
		</nav>
	</xsl:template>

</xsl:stylesheet>