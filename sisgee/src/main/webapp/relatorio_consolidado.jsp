<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Relatório Consolidado</title>
	<%@ include file="head_imports.jspf" %>	
	
	<meta charset="utf-8">
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form method="post" action="">
			<c:if test="${ not empty msg }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg }</div>		
	 		</c:if>
			<h2 class="title-func text-center"><fmt:message key="br.cefetrj.sisgee.relatorio.pesquisaRelatorio"></fmt:message></h2>
			<div class="row text-center">
				<div class="col-md-2"></div>
				<div class="form-group col-md-4">
						<label for="unidade"><fmt:message key="br.cefetrj.sisgee.relatorio.dataInicio"></fmt:message></label>
						<input type="text" class="form-control" name="data_inicio" id="data_inicio">
				</div>
				<div class="form-group col-md-4">
						<label for="unidade"><fmt:message key="br.cefetrj.sisgee.relatorio.dataFinal"></fmt:message></label>
						<input type="text" class="form-control" name="data_fim" id="data_fim">
				</div>
				<div class="form-group col-md-12" id="radioestagio">
					<div>
						<label class="form-check-label">
						  <input class="form-check-input" id="radioestagio1" type="radio" name="isn_obrigatorio" checked value="1"/>
						  <fmt:message key="br.cefetrj.sisgee.relatorio.estagioobrigatorio"></fmt:message>
						</label>
						<label class="form-check-label">
						  <input class="form-check-input" id="radioestagio2" type="radio" name="isn_obrigatorio" value="0"/>
						  <fmt:message key="br.cefetrj.sisgee.relatorio.estagioobrigatorio"></fmt:message>
						</label>
					</div>
					
					<button style="margin-top: 15px;" type="button" class="btn btn-primary"  onClick = "var teste = document.getElementById('radioestagio1').checked; if(teste == true){radio = document.getElementById('radioestagio1').value;}else{radio = document.getElementById('radioestagio2').value;};var dataInicial = document.getElementById('data_inicio').value;var dataFinal = document.getElementById('data_fim').value;javascript:location.href='FrontControllerServlet?action=GerarRelatorio&datainicio='+dataInicial+'&datafim='+dataFinal+'&radioestagio='+radio"><fmt:message key="br.cefetrj.sisgee.relatorio.pesquisa"></fmt:message></button>
					
				</div>
			</div>
			<hr/>
			<c:if test="${ not empty msg2 }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg2 }</div>		
	 		</c:if>
				<div class="result col-md-12">
					<div class="row">
						<c:if test="${ empty msg2 }">
						<div class="col-md-12 title text-center">
							<h4><fmt:message key="br.cefetrj.sisgee.relatorio.resultadospesquisa"></fmt:message></h4>
						</div>
						</c:if>
						<c:forEach items="${ listaRelatorio }" var="listaRelatorio">
							<div class="col-md-6">
								<h5>${ listaRelatorio[0] }</h5>
									<table class="table table-striped">
									    <thead>
									      <tr>
									        <th></th>
												<th><fmt:message key="br.cefetrj.sisgee.relatorio.total"></fmt:message></th>
									      </tr>
									    </thead>
									    <tbody>
									      <tr>
									        <td><fmt:message key="br.cefetrj.sisgee.relatorio.termosregistrados"></fmt:message></td>
									        <td>${ listaRelatorio[1] }</td>
									      </tr>
									      <tr>
									        <td><fmt:message key="br.cefetrj.sisgee.relatorio.aditivosregistrados"></fmt:message></td>
									        <td>${ listaRelatorio[2] }</td>
									      </tr>
									      <tr>
									        <td><fmt:message key="br.cefetrj.sisgee.relatorio.rescisoesregistradas"></fmt:message></td>
									        <td>${ listaRelatorio[3] }</td>
									      </tr>
									    </tbody>
									</table>
								</div>
						</c:forEach>
					</div>
				</div>
		</form>
	</div>			
    <%@ include file="scripts_imports.jspf" %>
    <script type="text/javascript">
    $('#data_inicio').datepicker({
    	<c:if test="${ lang eq 'pt_BR' }">
    	language: 'pt-BR'
        </c:if>
    });
    $('#data_fim').datepicker({
    	<c:if test="${ lang eq 'pt_BR' }">
    	language: 'pt-BR'
        </c:if>
    });
    </script>
</body>
</html>