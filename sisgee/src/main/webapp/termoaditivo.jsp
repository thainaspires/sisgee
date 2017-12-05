<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registro do Termo de Aditivo</title>
	<%@ include file="head_imports.jspf" %>	
	<meta charset="utf-8">
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form method="post" action="" id="formulario">
			<h2 class="title-func text-center"><fmt:message key="br.cefetrj.sisgee.termo_aditivo.alteracoesaditivo"></fmt:message></h2>
			<fieldset>
				<legend><fmt:message key="br.cefetrj.sisgee.termo_aditivo.dados_aluno"></fmt:message></legend>
				<c:if test="${ not empty msg }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg }</div>		
	 			</c:if>
				<div class="row">
					<div class="form-group col-md-4" style="display:inline-block;">
						<label for="matricula"><fmt:message key="br.cefetrj.sisgee.termo_estagio.matricula"></fmt:message></label>
						<div class="input-group">
							<input type="text" class="form-control" name="matricula" id="matricula" value="${ matricula }">	
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button" onClick="var form = document.getElementById('formulario'); var mat = document.getElementById('matricula').value;form.action='FrontControllerServlet?action=ListarTermosAditivos&matricula='+mat;form.submit();">Buscar</button>
							</span>
						</div>
					</div>

					<div class="form-group col-md-8">
						<label for="nome_aluno"><fmt:message key="br.cefetrj.sisgee.termo_estagio.nomealuno"></fmt:message></label>
						<input type="text" class="form-control" name="nome_aluno" id="nome_aluno" disabled="disabled" value="${ aluno.pessoa }">
					</div>							
					<div class="form-group col-md-6">
						<label for="curso"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cursoaluno"></fmt:message></label>
						<input type="text" class="form-control" name="curso" id="curso" disabled="disabled" value="${ aluno.curso }">
					</div>

					<div class="form-group col-md-6">
						<label for="unidade"><fmt:message key="br.cefetrj.sisgee.termo_estagio.unidadealuno"></fmt:message></label>
						<input type="text" class="form-control" name="unidade" id="unidade" disabled="disabled" value="${ aluno.curso.campus }">
					</div>
				</div>
			</fieldset>
			<hr/>
			<c:if test="${ not empty msg2 }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg2 }</div>		
	 		</c:if>
	 		<c:if test="${ empty msg2 }">
			<table class="table table-striped text-center">
			    <thead>
			      <tr>
			        <th><fmt:message key="br.cefetrj.sisgee.termo_aditivo.dados_registro"></fmt:message></th>
			        <th><fmt:message key="br.cefetrj.sisgee.termo_aditivo.CNPJ"></fmt:message></th>
			        <th><fmt:message key="br.cefetrj.sisgee.termo_aditivo.razao"></fmt:message></th>
			      </tr>
			    </thead>
			    <tbody>
				    <c:forEach items="${ listaTermos }" var="listaTermos">
				    	<tr>
				        <!--<td><a href="FrontControllerServlet?action=BuscarTermo&idTermo=${ listaTermos[3] }&eEstagio=${ eEstagio }">${ listaTermos[0] }</a></td>-->
				        <td><a href="erro.jsp">${ listaTermos[0] }</a></td>
				        <td>${ listaTermos[1] }</td>
				        <td>${ listaTermos[2] }</td>
				      </tr>
				    </c:forEach>
			    </tbody>
			</table>
			</c:if>
			<hr/>
			<div class="form-group" id="checkgroup">
				<div class="checkbox">
				  <label><input type="checkbox" value=""><fmt:message key="br.cefetrj.sisgee.termo_aditivo.vigencia"></fmt:message></label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value=""><fmt:message key="br.cefetrj.sisgee.termo_aditivo.carga"></fmt:message></label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value=""><fmt:message key="br.cefetrj.sisgee.termo_aditivo.bolsa"></fmt:message></label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value=""><fmt:message key="br.cefetrj.sisgee.termo_aditivo.endereco"></fmt:message></label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value=""><fmt:message key="br.cefetrj.sisgee.termo_aditivo.professor"></fmt:message></label>
				</div>
			</div>
			<br/>
			<input type="submit" id="btn-enviar" class="btn btn-active" name="enviar" value="<fmt:message key='br.cefetrj.sisgee.termo_aditivo.enviar'></fmt:message>">
		</form>
	</div>			
    <%@ include file="scripts_imports.jspf" %>
</body>
</html>