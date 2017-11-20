<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<h2 class="title-func text-center">Pesquisa de Relatório Consolidado</h2>
			<div class="row text-center">
				<div class="col-md-2"></div>
				<div class="form-group col-md-4">
						<label for="unidade">Data de Início</label>
						<input type="text" class="form-control" name="data_inicio" id="data_inicio">
				</div>
				<div class="form-group col-md-4">
						<label for="unidade">Data de Fim</label>
						<input type="text" class="form-control" name="data_fim" id="data_fim">
				</div>
				<div class="form-group col-md-12" id="radioestagio">
					<div>
						<label class="form-check-label">
						  <input class="form-check-input" type="radio" name="isn_obrigatorio" checked value="s"/>
						  Estágio Obrigatório
						</label>
						<label class="form-check-label">
						  <input class="form-check-input" type="radio" name="isn_obrigatorio" value="n"/>
						  Estágio Não Obrigatório
						</label>
					</div>
					<button style="margin-top: 15px;" type="button" class="btn btn-primary">Pesquisar</button>
				</div>				
			</div>
			<hr/>
			<div class="row">
				<div class="result col-md-12">
					<div class="row">
						<div class="col-md-12 title text-center">
							<h4>Resultados da Pesquisa</h4>
						</div>
						<div class="col-md-6 col-md-offset-3">
							<h5>Tecnico em Informática</h5>
							<table class="table table-striped">
							    <thead>
							      <tr>
							        <th></th>
							        <th>Total</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td>Termo de Estágios Registrados</td>
							        <td>900</td>
							      </tr>
							      <tr>
							        <td>Aditivos Regitrados</td>
							        <td>207</td>
							      </tr>
							      <tr>
							        <td>Rescisões Registradas</td>
							        <td>105</td>
							      </tr>
							    </tbody>
							</table>
						</div>
						<div class="col-md-6">
							<h5>Engenharia Civil</h5>
							<table class="table table-striped">
							    <thead>
							      <tr>
							        <th></th>
							        <th>Total</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td>Termo de Estágios Registrados</td>
							        <td>456</td>
							      </tr>
							      <tr>
							        <td>Aditivos Regitrados</td>
							        <td>81</td>
							      </tr>
							      <tr>
							        <td>Rescisões Registradas</td>
							        <td>12</td>
							      </tr>
							    </tbody>
							</table>
						</div>
					</div>
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