<%@ page import="friendsofmine.DemandeVisite" %>



<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonnes', 'error')} required">
	<label for="nbPersonnes">
		<g:message code="demandeVisite.nbPersonnes.label" default="Nb Personnes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nbPersonnes" type="number" min="1" max="6" value="${demandeVisiteInstance.nbPersonnes}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'debut', 'error')} required">
	<label for="debut">
		<g:message code="demandeVisite.debut.label" default="Debut" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="debut" precision="day"  value="${demandeVisiteInstance?.debut}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'fin', 'error')} required">
	<label for="fin">
		<g:message code="demandeVisite.fin.label" default="Fin" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fin" precision="day"  value="${demandeVisiteInstance?.fin}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'codeDemande', 'error')} required">
	<label for="codeDemande">
		<g:message code="demandeVisite.codeDemande.label" default="Code Demande" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codeDemande" required="" value="${demandeVisiteInstance?.codeDemande}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'museesVisite', 'error')} ">
	<label for="museesVisite">
		<g:message code="demandeVisite.museesVisite.label" default="Musees Visite" />
		
	</label>
	<g:select name="museesVisite" from="${friendsofmine.Musee.list()}" multiple="multiple" optionKey="id" size="5" value="${demandeVisiteInstance?.museesVisite*.id}" class="many-to-many"/>

</div>

