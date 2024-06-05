<%--
 * action-1.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1><spring:message code="curso.listado" /></h1>

<a href="${pageContext.request.contextPath}/curso/crear.do">Agregar Nuevo Curso</a>


<h1>Listado de Cursos</h1>
<table border="1">
    <thead>
        <tr>
            <th>Título</th>
            <th>Fecha de Inicio</th>
            <th>Fecha de Fin</th>
            <th>Día de la Semana</th>
            <th>Hora de Ejecución</th>
            <th>Capacidad</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="curso" items="${cursos}">
            <tr>
                <td>${curso.titulo}</td>
                <td><fmt:formatDate value="${curso.fecha_Inicio}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${curso.fecha_fin}" pattern="dd/MM/yyyy"/></td>
                <td>${curso.diaSemana}</td>
                <td>${curso.horaEjecucion}</td>
                <td>${curso.capacidad}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/curso/editar.do?id=${curso.id}">Editar</a>
                    <form action="${pageContext.request.contextPath}/curso/listado.do" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${curso.id}" />
                        <input type="submit" value="Eliminar" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
