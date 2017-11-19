<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<form method="post" action="">
			<h2 class="title-func text-center">Alterações do Aditivo</h2>
			<fieldset>
				<legend>Dados do Aluno</legend>
				<div class="row">
					<div class="form-group col-md-4" style="display:inline-block;">
						<label for="matricula">Matrícula</label>
						<div class="input-group">
							<input type="text" class="form-control" name="matricula" id="matricula">	
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button">Buscar</button>
							</span>
						</div>
					</div>

					<div class="form-group col-md-8">
						<label for="nome_aluno">Nome</label>
						<input type="text" class="form-control" name="nome_aluno" id="nome_aluno" disabled="disabled">
					</div>							
					<div class="form-group col-md-6">
						<label for="curso">Curso</label>
						<input type="text" class="form-control" name="curso" id="curso" disabled="disabled">
					</div>

					<div class="form-group col-md-6">
						<label for="unidade">Unidade</label>
						<input type="text" class="form-control" name="unidade" id="unidade" disabled="disabled">
					</div>
				</div>
			</fieldset>
			<hr/>
			<table class="table table-striped text-center">
			    <thead>
			      <tr>
			        <th>Data de Registro</th>
			        <th>CNPJ</th>
			        <th>Razão Social</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td><a href="#">09/09/2016</a></td>
			        <td>23.456.242/0001-95</td>
			        <td>Google</td>
			      </tr>
			      <tr>
			        <td><a href="#">09/04/2017</a></td>
			        <td>23.456.242/0001-95</td>
			        <td>Google</td>
			      </tr>
			      <tr>
			        <td><a href="#">09/07/2017</a></td>
			        <td>23.456.242/0001-95</td>
			        <td>Google</td>
			      </tr>
			    </tbody>
			</table>
			<hr/>
			<div class="form-group" id="checkgroup">
				<div class="checkbox">
				  <label><input type="checkbox" value="">Vigência</label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value="">Carga Horária</label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value="">Valor da Bolsa</label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value="">Endereço do Estágio</label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value="">Professor Orientador</label>
				</div>
			</div>
			<br/>
			<input type="submit" id="btn-enviar" class="btn btn-active" name="enviar" value="Enviar">
		</form>
	</div>			
    <%@ include file="scripts_imports.jspf" %>
</body>
</html>