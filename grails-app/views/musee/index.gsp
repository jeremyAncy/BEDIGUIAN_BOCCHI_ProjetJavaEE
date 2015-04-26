<%@ page import="friendsofmine.Musee" %>
<!DOCTYPE html>
<html>

<!-- init -->
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <style>
    body {
        max-width: none;
        width: 90%;
    }

    #museeFav {
        width: 30%;
        margin-left: 61%;
    }
    </style>

    <script>
        $(document).ready(function () {
            var rowCount = $('.ligneFav').length;
            console.log("taille ligne : "+rowCount);

            /*for (var i = 0; i < rowCount; i++) {
                var num = $('.ligneFav').children().val();
                var nameId = $('.ligneFav').siblings().children().attr('id');
                console.log(num);
                console.log("Id = " + nameId);
                var idNum = "#btnFavory" + num;
                $(idNum).hide();
            }*/
            $('.ligneFav').each (function() {
                var nameId = $(this).siblings().children().attr('id');
                console.log("Id = " + nameId);
                //var numHide = nameId.slice(-1);
                var idNum = "#btnFavory" + nameId.slice(-1);
                $(idNum).hide();
            });
        });
    </script>
</head>

<body>
<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>


<div id="list-musee" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:form>
        <fieldset class="form">
            <div class="fieldcontain">
                <label for="nomMusee">
                    Nom du musée contient :
                </label>
                <g:textField name="nomMusee"/>
                <br/>
                <label for="codePostal" style="padding-top: 2%;">
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
                <g:actionSubmit action="doSearchMusee" value="Rechercher"/>
            </div>
        </fieldset>

    </g:form>
</div>

<div id="museeFav">
    <table id="museesFavoris">
        <thead>
        <tr>
            <g:sortableColumn property="nomMusee"
                              title="${message(code: 'musee.nomMusee.label', default: 'Mes musées préférés')}"/>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <g:each in="${museeFavorisList}" status="i" var="museeFavori">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <g:form>
                    <td class="ligneFav"><g:hiddenField name="id" value="${museeFavori.id}"/>${fieldValue(bean: museeFavori, field: "nomMusee")}</td>
                    <td><g:actionSubmit id="removeMuseeFav${museeFavori.id}" action="removeMuseeFavory" value="supprimer de ma liste de musées"/></td>
                </g:form>
            </tr>
        </g:each>
        </tbody>
    </table>
    <g:form>
        <g:actionSubmit action="demandeVisite" value="Effectuer	une demande	de visite"/>
    </g:form>
</div>


<div id="rechercheMusees">

    <table id="museesList">
        <thead>
        <tr>
            <g:sortableColumn property="nomMusee"
                              title="${message(code: 'musee.nomMusee.label', default: 'Nom Musée')}"/>
            <g:sortableColumn property="adresse"
                              title="${message(code: 'musee.adresseMusee.label', default: 'Adresse')}"/>
            <g:sortableColumn property="codePostal"
                              title="${message(code: 'musee.adressMusee.codePostal.label', default: 'Code Postal')}"/>
            <g:sortableColumn property="telMusee"
                              title="${message(code: 'musee.telMusee.label', default: 'Téléphone')}"/>
            <g:sortableColumn property="accesBus"
                              title="${message(code: 'musee.accesBus.label', default: 'Acces Bus')}"/>
            <g:sortableColumn property="accesMetro"
                              title="${message(code: 'musee.accesMetro.label', default: 'Acces Métro')}"/>
            <g:sortableColumn property="horairesMusee"
                              title="${message(code: 'musee.horairesMusee.label', default: 'Horaire')}"/>
            <g:sortableColumn property="gestionnaire"
                              title="${message(code: 'musee.gestionnaire.nom.label', default: 'Gestionnaire')}"/>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <g:each in="${museeInstanceList}" status="i" var="museeInstance">

            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <g:form>
                    <td><g:hiddenField name="nomMusee"
                                       value="${fieldValue(bean: museeInstance, field: "nomMusee")}"/><g:link
                            action="addMuseeFavory"
                            id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nomMusee")}</g:link></td>
                    <td>${fieldValue(bean: museeInstance, field: "adresseMusee")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "adresseMusee.codePostal")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "telMusee")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "horairesMusee")}</td>
                    <td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>
                    <td><g:actionSubmit id="btnFavory${museeInstance.id}" action="addMuseeFavory"
                                        value="Ajouter à ma liste de musées"/></td>
                </g:form>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate max="5" total="${museeInstanceCount ?: 5}"/>
    </div>
</div>
</body>
<!-- fin init -->

</html>
