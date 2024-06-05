<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>



<display:table pagesize="5" class="displaytag" keepStatus="true"
    name="academia" id="row" requestURI="academia/listaAcademia.do">
    
    <!-- Attributes -->
    <display:column property="nombre"   />
    <display:column property="apellidos"   />
    <display:column property="direccion"   />
    <display:column property="codigoPostal"   />
    <display:column property="telefono"   />
    <display:column property="email"   />
      <display:column property="nombreComercial"   />

</display:table>