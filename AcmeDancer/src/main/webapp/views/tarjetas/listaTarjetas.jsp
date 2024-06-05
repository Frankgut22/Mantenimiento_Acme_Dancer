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

<p><spring:message code="tarjetas.listaTarjetas" /></p>


<display:table pagesize="5" class="displaytag" keepStatus="true"
    name="tarjetas" id="row" requestURI="tarjetas/listaTarjetas.do">
    
    <!-- Attributes -->
    <display:column property="nombreTitular"   />
    <display:column property="numeroTarjeta"   />
    <display:column property="tipoTarjeta"   />
    <display:column property="mes"   />
    <display:column property="anio"   />
    <display:column property="cvv"   />
<!-- Columna para el botón de eliminación -->

</display:table>