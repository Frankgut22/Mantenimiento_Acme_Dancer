<!-- editarTutorial.jsp -->
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form modelAttribute="tutorial" method="POST" action="${pageContext.request.contextPath}/tutorial/editarTutorial.do">
    <table>
        <tr>
            <td>Título:</td>
            <td><form:input path="titulo"/></td>
        </tr>
        <tr>
            <td>Descripción:</td>
            <td><form:input path="descripcion"/></td>
        </tr>
        <tr>
            <td>Video:</td>
            <td><form:input path="video"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Guardar Cambios"/></td>
        </tr>
    </table>
</form:form>
