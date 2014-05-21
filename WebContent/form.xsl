<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="master.xsl"/>
	<xsl:template name="content">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="errors">
		<div class="alert alert-danger">
			<ul class="list-unstyled">
				<xsl:apply-templates />
			</ul>
		</div>
	</xsl:template>

	<xsl:template match="error">
		<li>
			<xsl:apply-templates />
		</li>
	</xsl:template>
	<xsl:template match="form">
		<form method="{@method}" action="{@action}" class="form-horizontal">
			<xsl:apply-templates/>
		</form>
	</xsl:template>
	<xsl:template match="textField">
		<div class="form-group">
			<label class="control-label col-sm-1" for="{@name}"><xsl:value-of select="@title"/></label>
			<div class="col-sm-3">
				<input type="text" name="{@name}" value="{@value}" class="form-control"/>
			</div>
		</div>
	</xsl:template>
	<xsl:template match="textArea">
		<div class="form-group">
			<label class="control-label col-sm-1" for="{@name}"><xsl:value-of select="@title"/></label>
			<div class="col-sm-3">
				<textarea name="{@name}" class="form-control">
				<xsl:value-of select="@value"/>
				</textarea>
			</div>
		</div>
	</xsl:template>
	<xsl:template match="passwordField">
		<div class="form-group">
			<label class="control-label col-sm-1" for="{@name}"><xsl:value-of select="@title"/></label>
			<div class="col-sm-3">
				<input type="password" name="{@name}" value="{@value}" class="form-control"/>
			</div>
		</div>
	</xsl:template>
	<xsl:template match="hiddenField">
		<input type="hidden" name="{@name}" value="{@value}"/>
	</xsl:template>
	<xsl:template match="submitButton">
		<div class="form-group">
			<div class="col-sm-3 col-sm-offset-1">
				<input type="submit" value="{@title}" class="btn btn-primary" />
			</div>
		</div>
	</xsl:template>
</xsl:stylesheet>