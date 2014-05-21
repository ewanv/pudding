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
				Form contains errors!
				<xsl:apply-templates select="error[@name='page']"/>
			</ul>
		</div>
	</xsl:template>

	<xsl:template match="error[@name='page']">
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
		<xsl:variable name="class">
			<xsl:if test="boolean(//error/@name=@name)" >
				<xsl:text>has-error</xsl:text>
			</xsl:if>
		</xsl:variable>
		<div class="form-group {$class}">
			<label class="control-label col-sm-1" for="{@name}"><xsl:value-of select="@title"/></label>
			<div class="col-sm-3">
				<input type="text" name="{@name}" value="{@value}" class="form-control"/>
			</div>
			<xsl:if test="boolean(//error/@name=@name)" >
				<span class="help-block">
					<xsl:value-of select="//error[@name=current()/@name]"/>
				</span>
			</xsl:if>
		</div>
	</xsl:template>
	<xsl:template match="textArea">
		<xsl:variable name="class">
			<xsl:if test="boolean(//error/@name=@name)" >
				<xsl:text>has-error</xsl:text>
			</xsl:if>
		</xsl:variable>
		<div class="form-group {$class}">
			<label class="control-label col-sm-1" for="{@name}"><xsl:value-of select="@title"/></label>
			<div class="col-sm-3">
				<textarea name="{@name}" class="form-control">
				<xsl:value-of select="@value"/>
				</textarea>
			</div>
			<xsl:if test="boolean(//error/@name=@name)" >
				<span class="help-block">
					<xsl:value-of select="//error[@name=current()/@name]"/>
				</span>
			</xsl:if>
		</div>
	</xsl:template>
	<xsl:template match="selectField">
		<xsl:variable name="class">
			<xsl:if test="boolean(//error/@name=@name)" >
				<xsl:text>has-error</xsl:text>
			</xsl:if>
		</xsl:variable>
		<div class="form-group {$class}">
			<label class="control-label col-sm-1" for="{@name}"><xsl:value-of select="@title"/></label>
			<div class="col-sm-3">
				<select name="{@name}" class="form-control">
					<xsl:apply-templates/>
				</select>
			</div>
			<xsl:if test="boolean(//error/@name=@name)" >
				<span class="help-block">
					<xsl:value-of select="//error[@name=current()/@name]" />
				</span>
			</xsl:if>
		</div>
	</xsl:template>
	<xsl:template match="selectOption">
		<xsl:choose>
			<xsl:when test="@selected='true'">
				<option value="{@value}" selected="selected"><xsl:apply-templates/></option>
			</xsl:when>
			<xsl:otherwise>
				<option value="{@value}"><xsl:apply-templates/></option>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template match="passwordField">
		<xsl:variable name="class">
			<xsl:if test="boolean(//error/@name=@name)" >
				<xsl:text>has-error</xsl:text>
			</xsl:if>
		</xsl:variable>
		<div class="form-group {$class}">
			<label class="control-label col-sm-1" for="{@name}"><xsl:value-of select="@title"/></label>
			<div class="col-sm-3">
				<input type="password" name="{@name}" value="{@value}" class="form-control"/>
			</div>
			<xsl:if test="boolean(//error/@name=@name)" >
				<span class="help-block">
					<xsl:value-of select="//error[@name=current()/@name]"/>
				</span>
			</xsl:if>
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