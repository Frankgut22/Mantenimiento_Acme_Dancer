<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Academias</title>
</head>
<body>
    <h2>Lista de Academias</h2>
	 <table border="1">
        <tr>
            <th>apellidos</th>
            <th>codigoPostal</th>
            <th>direccion</th>
            <th>nombre</th>
            <th>telefono</th>
            <th>nombreComercial</th>
        </tr>
        <c:forEach var="academia" items="${academia}">
            <tr>
                <td>${academia.apellidos}</td>
                <td>${academia.codigoPostal}</td>
                <td>${academia.direccion}</td>
                <td>${academia.nombre}</td>
                <td>${academia.telefono}</td>
                <td>${academia.nombreComercial}</td>
             </tr>
        </c:forEach>
    </table>
</body>
</html>