<%@ page import="friendsofmine.Musee" %>



<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'nomMusee', 'error')} required">
    <label for="nomMusee">
        <g:message code="musee.nomMusee.label" default="Nom Musee"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nomMusee" required="" value="${museeInstance?.nomMusee}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'telMusee', 'error')} required">
    <label for="telMusee">
        <g:message code="musee.telMusee.label" default="Tel Musee"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="telMusee" required="" value="${museeInstance?.telMusee}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'accesMetro', 'error')} required">
    <label for="accesMetro">
        <g:message code="musee.accesMetro.label" default="Acces Metro"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="accesMetro" required="" value="${museeInstance?.accesMetro}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'accesBus', 'error')} required">
    <label for="accesBus">
        <g:message code="musee.accesBus.label" default="Acces Bus"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="accesBus" required="" value="${museeInstance?.accesBus}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: museeInstance, field: 'horairesMusee', 'error')} required">
    <label for="horairesMusee">
        <g:message code="musee.horairesMusee.label" default="Horaires Musee"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="horairesMusee" required="" value="${museeInstance?.horairesMusee}"/>

</div>

