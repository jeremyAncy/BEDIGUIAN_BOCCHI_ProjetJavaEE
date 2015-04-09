<%@ page import="friendsofmine.Musee" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-musee" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list musee">

        <g:if test="${museeInstance?.nomMusee}">
            <li class="fieldcontain">
                <span id="nomMusee-label" class="property-label"><g:message code="musee.nomMusee.label"
                                                                            default="Nom Musee"/></span>

                <span class="property-value" aria-labelledby="nomMusee-label"><g:fieldValue bean="${museeInstance}"
                                                                                            field="nomMusee"/></span>

            </li>
        </g:if>

        <g:if test="${museeInstance?.telMusee}">
            <li class="fieldcontain">
                <span id="telMusee-label" class="property-label"><g:message code="musee.telMusee.label"
                                                                            default="Tel Musee"/></span>

                <span class="property-value" aria-labelledby="telMusee-label"><g:fieldValue bean="${museeInstance}"
                                                                                            field="telMusee"/></span>

            </li>
        </g:if>

        <g:if test="${museeInstance?.accesMetro}">
            <li class="fieldcontain">
                <span id="accesMetro-label" class="property-label"><g:message code="musee.accesMetro.label"
                                                                              default="Acces Metro"/></span>

                <span class="property-value" aria-labelledby="accesMetro-label"><g:fieldValue bean="${museeInstance}"
                                                                                              field="accesMetro"/></span>

            </li>
        </g:if>

        <g:if test="${museeInstance?.accesBus}">
            <li class="fieldcontain">
                <span id="accesBus-label" class="property-label"><g:message code="musee.accesBus.label"
                                                                            default="Acces Bus"/></span>

                <span class="property-value" aria-labelledby="accesBus-label"><g:fieldValue bean="${museeInstance}"
                                                                                            field="accesBus"/></span>

            </li>
        </g:if>

        <g:if test="${museeInstance?.horairesMusee}">
            <li class="fieldcontain">
                <span id="horairesMusee-label" class="property-label"><g:message code="musee.horairesMusee.label"
                                                                                 default="Horaires Musee"/></span>

                <span class="property-value" aria-labelledby="horairesMusee-label"><g:fieldValue bean="${museeInstance}"
                                                                                                 field="horairesMusee"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: museeInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${museeInstance}"><g:message code="default.button.edit.label"
                                                                                      default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
