<%--
 * header.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="images/logo.png" alt="Sample Co., Inc." /></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/action-1.do"><spring:message code="master.page.administrator.action.1" /></a></li>
					<li><a href="administrator/action-2.do"><spring:message code="master.page.administrator.action.2" /></a></li>					
					<li><a href="administrator/action-3.do"><spring:message code="master.page.administrator.action.3" /></a></li>				
				</ul>
			</li>
			<li><a class="fNiv"><spring:message	code="master.page.curso" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="curso/listado.do"><spring:message code="master.page.curso.listado" /></a></li>				
					<li><a href="curso/create.do"><spring:message code="master.page.curso.crear" /></a></li>				
				
				</ul>
			</li>
			<li><a class="fNiv"><spring:message	code="master.page.academia" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="academia/listaAcademia.do"><spring:message code="master.page.academia.listaAcademia" /></a></li>				
				</ul>
			</li>
			<li><a class="fNiv"><spring:message	code="master.page.tarjetas" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="tarjetas/listaTarjetas.do"><spring:message code="master.page.tarjetas.listaTarjetas" /></a></li>				
				</ul>
			</li>
			<li><a class="fNiv"><spring:message	code="master.page.tutorial" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="tutorial/listaTuto.do"><spring:message code="master.page.tutorial.listaTuto" /></a></li>				
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('CUSTOMER')">
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="customer/action-1.do"><spring:message code="master.page.customer.action.1" /></a></li>
					<li><a href="customer/action-2.do"><spring:message code="master.page.customer.action.2" /></a></li>
				</ul>
			</li>
			<li><a href="curso/listado.do"><spring:message code="master.page.curso" /></a></li>	
			<li><a href="academia/listaAcademia.do"><spring:message code="master.page.academia.listaAcademia" /></a></li>							
			<li><a href="tutorial/listaTuto.do"><spring:message code="master.page.tutorial.listaTuto" /></a></li>								
		
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
			<li><a href="academia/crear.do">Crear Academia</a></li>
			<li><a href="curso/listado.do"><spring:message code="master.page.curso" /></a></li>	
			<li><a href="academia/listaAcademia.do"><spring:message code="master.page.academia.listaAcademia" /></a></li>				
						
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="profile/action-1.do"><spring:message code="master.page.profile.action.1" /></a></li>
					<li><a href="profile/action-2.do"><spring:message code="master.page.profile.action.2" /></a></li>
					<li><a href="profile/action-3.do"><spring:message code="master.page.profile.action.3" /></a></li>					
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

