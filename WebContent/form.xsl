<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl"/>
	<xsl:template name="content">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="form">
		<form method="{@method}" action="{@action}">
			<table>
				<xsl:apply-templates/>
			</table>
		</form>
	</xsl:template>
	<xsl:template match="textField">
				<tr><td><xsl:value-of select="@title"/></td><td><input type="text" name="{@name}" value="{@value}"/></td></tr>
	</xsl:template>
	<xsl:template match="textArea">
				<tr><td><xsl:value-of select="@title"/></td><td><textarea name="{@name}"> <xsl:value-of select="@value"/></textarea></td></tr>
	</xsl:template>
	<xsl:template match="passwordField">
				<tr><td><xsl:value-of select="@title"/></td><td><input type="password" name="{@name}" value="{@value}"/></td></tr>
	</xsl:template>
	<xsl:template match="hiddenField">
				<input type="hidden" name="{@name}" value="{@value}"/>
	</xsl:template>
	<xsl:template match="submitButton">
				<tr><td></td><td><input type="submit" value="{@title}"/></td></tr>
	</xsl:template>
</xsl:stylesheet>