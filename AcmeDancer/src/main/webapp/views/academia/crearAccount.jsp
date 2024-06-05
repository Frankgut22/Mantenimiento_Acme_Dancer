<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Crear Nuevo User Account</h2>
<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/academia/crearAccount.do">
    <form:hidden path="id" />
    <form:hidden path="version" />

    <table>
        
        <tr>
            <td>Nombre usuario:</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>Contraseña:</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Crear"/></td>
        </tr>
    </table>
</form:form>