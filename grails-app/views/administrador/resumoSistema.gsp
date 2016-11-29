<%--
  Created by IntelliJ IDEA.
  User: gvmgs
  Date: 29/11/16
  Time: 11:08
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name ="layout" content = "main">
    <title>Resumo Sistema</title>
</head>

<body>
    <a href="#list-laboratorio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="/ResiduosQuimicos"><g:message code="default.home.label"/></a></li>
        </ul>
    </div>
    <div class="content scaffold-show" role="main">
        <label>Peso total dos Residuos:</label>
            <p name="peso">
            ${peso}
        </p>
        <br>
        <label>Numero de residuos cadastrados:</label>
    <p name="qntResiduos">
        ${numResiduos}
    </p>
    </div>

        <div class="content scaffold-create" role="main">
            <h1><g:message code="default.relatorio.label" args="[entityName]"/> <g:message code="default.paginate.since"/></h1>
            <g:form url="[resource: laboratorioInstance]">
                <fieldset class="form">

                    <div class="fieldcontain">
                        <label for="date"></label>
                        <g:datePicker name="date" precision="day" value="${params.date}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton id="relatory" formaction="relatory" name="Relatory" class="relatory" action="relatory" value="${message(code: 'default.button.list.label', default: 'Relatory')}" />
                </fieldset>
            </g:form>
        </div>


</body>
</html>