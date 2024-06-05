<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<h1><spring:message code="tutorial.listado.titulo" /></h1>


<security:authorize access="hasRole('ADMIN')">
<!-- Botón para añadir un nuevo tutorial -->
<a href="${pageContext.request.contextPath}/tutorial/nuevoTutorial.do">
    <button type="button">Añadir Nuevo Tutorial</button>
</a>
</security:authorize>


<display:table pagesize="5" class="displaytag" keepStatus="true"
    name="tutoriales" id="row" requestURI="tutorial/listaTuto.do">
    
    <!-- Attributes -->
    <display:column property="titulo"   />
    <display:column property="descripcion"   />
    <display:column property="video"   />
<!-- Columna para el botón de eliminación -->
<security:authorize access="hasRole('ADMIN')">
    <display:column title="Eliminar" media="html">
        <form:form method="POST" action="${pageContext.request.contextPath}/tutorial/listaTuto.do">
            <input type="hidden" name="id" value="${row.id}" />
            <button type="submit">Eliminar</button>
        </form:form>
    </display:column>
    </security:authorize>
</display:table>