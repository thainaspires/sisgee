<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registro de Rescis�o</title>
	<%@ include file="head_imports.jspf" %>	
	<meta charset="utf-8">
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form method="post" action="">
			<h2 class="title-func text-center">Registro de Rescis�o</h2>
			<fieldset>
				<legend>Dados do Aluno</legend>
				<div class="row">
					<div class="form-group col-md-4" style="display:inline-block;">
						<label for="matricula">Matr�cula</label>
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
			<div class="row" id="recisaogrupo">
				<div class="col-md-4"></div>
				<div class="form-group col-md-4">
						<label for="unidade">Data de Rescis�o</label>
						<input type="date" class="form-control" name="data_rescisao" id="data_rescisao">
				</div>
			</div>
			<br/>
			<input type="submit" id="btn-enviar" class="btn btn-active" name="enviar" value="Enviar">
		</form>
	</div>			
    <%@ include file="scripts_imports.jspf" %>
</body>
</html>