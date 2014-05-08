<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="page">
		<html>
			<head>
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
						<li><a href="articles.jsp">Home</a></li>
					</ul>
				</nav>
				<xsl:call-template name="content" />
			</body>
		</html>
	</xsl:template>

	<xsl:template name="content">
		<span style="color: red">Content template is empty - overrule in page
			template.</span>
	</xsl:template>

</xsl:stylesheet>