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
				<style>
					table { border: solid 1px black; border-collapse:collapse; }
					table td { border: solid 1px #999; }
					nav ul {
						list-style-type:none;
						margin:0 0 20px 0;
						padding:10px;
						overflow:hidden;
						background-color:#dddddd;
					}
					nav li { float:left; }
					nav li.pull-right { float:right; }
					nav a { display:block; width:60px; }
				</style>
			</head>
			<body>
				<nav>
					<ul>
						<li>
							<a href="index.jsp">Home</a>
						</li>
						<xsl:choose>
							<xsl:when test="loggedInAuthor">
								<li class="pull-right">
									<a href="logout.jsp">Logout</a>
								</li>
							</xsl:when>
							<xsl:otherwise>
								<li class="pull-right">
									<a href="login.jsp">Login</a>
								</li>
							</xsl:otherwise>
						</xsl:choose>
					</ul>
				</nav>
				<xsl:call-templates name="errors" />
				<xsl:call-template name="content" />
			</body>
		</html>
	</xsl:template>
	
	<xsl:template name="errors">
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="error">
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template name="content">
		<span style="color: red">Content template is empty - overrule in page
			template.</span>
	</xsl:template>

</xsl:stylesheet>