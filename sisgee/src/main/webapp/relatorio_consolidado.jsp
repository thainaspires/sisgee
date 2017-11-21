<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Relat�rio Consolidado</title>
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
			<h2 class="title-func text-center">Pesquisa de Relat�rio Consolidado</h2>
			<div class="row text-center">
				<div class="col-md-2"></div>
				<div class="form-group col-md-4">
						<label for="unidade">Data de In�cio</label>
						<input type="text" class="form-control" name="data_inicio" id="data_inicio">
				</div>
				<div class="form-group col-md-4">
						<label for="unidade">Data de Fim</label>
						<input type="text" class="form-control" name="data_fim" id="data_fim">
				</div>
				<div class="form-group col-md-12" id="radioestagio">
					<div>
						<label class="form-check-label">
						  <input class="form-check-input" id="radioestagio1" type="radio" name="isn_obrigatorio" checked value="1"/>
						  Est�gio Obrigat�rio
						</label>
						<label class="form-check-label">
						  <input class="form-check-input" id="radioestagio2" type="radio" name="isn_obrigatorio" value="0"/>
						  Est�gio N�o Obrigat�rio
						</label>
					</div>
					
					<button style="margin-top: 15px;" type="button" class="btn btn-primary"  onClick = "var teste = document.getElementById('radioestagio1').checked; if(teste == true){radio = document.getElementById('radioestagio1').value;}else{radio = document.getElementById('radioestagio2').value;};var dataInicial = document.getElementById('data_inicio').value;var dataFinal = document.getElementById('data_fim').value;javascript:location.href='FrontControllerServlet?action=GerarRelatorio&datainicio='+dataInicial+'&datafim='+dataFinal+'&radioestagio='+radio">Pesquisar</button>
					
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
							<h5>Tecnico em Inform�tica</h5>
							<table class="table table-striped">
							    <thead>
							      <tr>
							        <th></th>
							        <th>Total</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td>Termo de Est�gios Registrados</td>
							        <td>900</td>
							      </tr>
							      <tr>
							        <td>Aditivos Regitrados</td>
							        <td>207</td>
							      </tr>
							      <tr>
							        <td>Rescis�es Registradas</td>
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
							        <td>Termo de Est�gios Registrados</td>
							        <td>456</td>
							      </tr>
							      <tr>
							        <td>Aditivos Regitrados</td>
							        <td>81</td>
							      </tr>
							      <tr>
							        <td>Rescis�es Registradas</td>
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