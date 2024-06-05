<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Crear Alumno</h2>
<form:form modelAttribute="alumno" method="POST" action="${pageContext.request.contextPath}/alumno/crear.do">
<form:hidden path="id" />
	<form:hidden path="version" />
	

    <table>
   		
        <tr>
            <td>Nombre usuario:</td>
            <td><form:input path="nombre"/></td>
        </tr>
        <tr>
            <td>Apellidos:</td>
            <td><form:input path="apellidos"/></td>
        </tr>
        <tr>
            <td>Dirección:</td>
            <td><form:input path="direccion"/></td>
        </tr>
        <tr>
            <td>Código Postal:</td>
            <td><form:input path="codigoPostal"/></td>
        </tr>
        <tr>
            <td>Teléfono:</td>
            <td><form:input path="telefono"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Crear"/></td>
        </tr>
    </table>
</form:form>