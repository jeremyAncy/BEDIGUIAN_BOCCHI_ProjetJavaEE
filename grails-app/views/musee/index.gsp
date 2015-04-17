
<%@ page import="friendsofmine.Musee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

        <script type="text/javascript">
            $( document ).ready(function() {
                $("tbody").hide();
                $("form").submit(function( event ) {
                    $("tbody").show();
                    event.preventDefault();
                });
            });
        </script>

	</head>
	<body>
		<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div id="list-musee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

            <g:form>
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="nomMusée">
                            Nom du musée contient :
                        </label>
                        <g:textField name="nomMusée"/>
                        <label for="codePostal">
                            Le code postal du musée contient :
                        </label>
                        <g:textField name="codePostal"/>
                    </div>
                    <div class="fieldcontain">
                        <label for="rue">
                            La rue du musée contient :
                        </label>
                        <g:textField name="rue"/>
                    </div>
                    <div style="float: right">
                        <g:actionSubmit action="doSearchMusee" value="Rechercher" />
                    </div>
                </fieldset>

            </g:form>


            <table>
                <thead>
                <tr>

                    <g:sortableColumn property="nomMusee" title="${message(code: 'musee.nomMusee.label', default: 'Nom Musée')}" />
                    <g:sortableColumn property="rue" title="${message(code: 'musee.adresseMusee.rue.label', default: 'Rue')}" />
                    <g:sortableColumn property="codePostal" title="${message(code: 'musee.adresseMusee.codePostal.label', default: 'Code postal')}" />



                </tr>
                </thead>
                <tbody>


                <g:each in="${museeInstanceList}" status="i" var="museeInstance">

                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                        <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nomMusee")}</g:link></td>


                        <td>${fieldValue(bean: museeInstance, field: "adresseMusee.rue")}</td>
                        <td>${fieldValue(bean: museeInstance, field: "adresseMusee.codePostal")}</td>


                    </tr>
                </g:each>
                </tbody>
            </table>


			<div class="pagination">
				<g:paginate max="5" total="${museeInstanceCount ?: 5}" />
			</div>
		</div>
	</body>
</html>
