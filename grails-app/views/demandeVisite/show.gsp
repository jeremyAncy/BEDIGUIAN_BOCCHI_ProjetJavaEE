
<%@ page import="friendsofmine.DemandeVisite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-demandeVisite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-demandeVisite" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list demandeVisite">
			
				<g:if test="${demandeVisiteInstance?.nbPersonnes}">
				<li class="fieldcontain">
					<span id="nbPersonnes-label" class="property-label"><g:message code="demandeVisite.nbPersonnes.label" default="Nb Personnes" /></span>
					
						<span class="property-value" aria-labelledby="nbPersonnes-label"><g:fieldValue bean="${demandeVisiteInstance}" field="nbPersonnes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${demandeVisiteInstance?.debut}">
				<li class="fieldcontain">
					<span id="debut-label" class="property-label"><g:message code="demandeVisite.debut.label" default="Debut" /></span>
					
						<span class="property-value" aria-labelledby="debut-label"><g:formatDate date="${demandeVisiteInstance?.debut}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${demandeVisiteInstance?.fin}">
				<li class="fieldcontain">
					<span id="fin-label" class="property-label"><g:message code="demandeVisite.fin.label" default="Fin" /></span>
					
						<span class="property-value" aria-labelledby="fin-label"><g:formatDate date="${demandeVisiteInstance?.fin}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${demandeVisiteInstance?.codeDemande}">
				<li class="fieldcontain">
					<span id="codeDemande-label" class="property-label"><g:message code="demandeVisite.codeDemande.label" default="Code Demande" /></span>
					
						<span class="property-value" aria-labelledby="codeDemande-label"><g:fieldValue bean="${demandeVisiteInstance}" field="codeDemande"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${demandeVisiteInstance?.museesVisite}">
				<li class="fieldcontain">
					<span id="museesVisite-label" class="property-label"><g:message code="demandeVisite.museesVisite.label" default="Musees Visite" /></span>
					
						<g:each in="${demandeVisiteInstance.museesVisite}" var="m">
						<span class="property-value" aria-labelledby="museesVisite-label"><g:link controller="musee" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:demandeVisiteInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${demandeVisiteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
