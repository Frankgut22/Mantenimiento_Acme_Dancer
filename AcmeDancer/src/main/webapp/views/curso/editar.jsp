<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Editar Curso</h1>

<form:form modelAttribute="curso" method="post" action="${pageContext.request.contextPath}/curso/editar.do">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td><spring:message code="curso.titulo" /></td>
            <td><form:input path="titulo"/></td>
        </tr>
        <tr>
            <td><spring:message code="curso.fecha_Inicio" /></td>
            <td><form:input path="fecha_Inicio"/></td>
        </tr>
        <tr>
            <td><spring:message code="curso.fecha_fin" /></td>
            <td><form:input path="fecha_fin"/></td>
        </tr>
        <tr>
            <td><spring:message code="curso.diaSemana" /></td>
            <td><form:input path="diaSemana"/></td>
        </tr>
        <tr>
            <td><spring:message code="curso.horaEjecucion" /></td>
            <td><form:input path="horaEjecucion"/></td>
        </tr>
        <tr>
            <td><spring:message code="curso.capacidad" /></td>
            <td><form:input path="capacidad"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Guardar"/></td>
        </tr>
    </table>
</form:form>