<%@ page import="friendsofmine.Gestionnaire" %>



<div class="fieldcontain ${hasErrors(bean: gestionnaireInstance, field: 'nomGestionnaire', 'error')} required">
	<label for="nomGestionnaire">
		<g:message code="gestionnaire.nomGestionnaire.label" default="Nom Gestionnaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nomGestionnaire" required="" value="${gestionnaireInstance?.nomGestionnaire}"/>

</div>

