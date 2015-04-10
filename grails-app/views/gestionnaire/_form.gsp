<%@ page import="friendsofmine.Gestionnaire" %>



<div class="fieldcontain ${hasErrors(bean: gestionnaireInstance, field: 'nomGestionnaire', 'error')} required">
	<label for="nomGestionnaire">
		<g:message code="gestionnaire.nomGestionnaire.label" default="Nom Gestionnaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nomGestionnaire" required="" value="${gestionnaireInstance?.nomGestionnaire}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gestionnaireInstance, field: 'musees', 'error')} ">
	<label for="musees">
		<g:message code="gestionnaire.musees.label" default="Musees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${gestionnaireInstance?.musees?}" var="m">
    <li><g:link controller="musee" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="musee" action="create" params="['gestionnaire.id': gestionnaireInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'musee.label', default: 'Musee')])}</g:link>
</li>
</ul>


</div>

