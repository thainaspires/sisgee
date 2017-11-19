<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Cadastro de Empresas</title>
	<%@ include file="head_imports.jspf" %>	
	<meta charset="utf-8">
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form method="post" action="">
			<h2 class="title-func text-center" style="margin-bottom: 20px;">Registro de Empresas (ou Agente de Integra��o)</h2>
			<div class="form-group col-md-12" id="radioestagio">
				<label style="float: left; margin-right: 25px;">� Agente de Integra��o?</label>
				<div>
					<label class="form-check-label">
					  <input class="form-check-input" type="radio" name="isn_obrigatorio" checked value="s"/>
					  Sim
					</label>
					<label class="form-check-label">
					  <input class="form-check-input" type="radio" name="isn_obrigatorio" value="n"/>
					  N�o
					</label>
				</div>
			</div>
			<fieldset>
				<div class="row">
					<div class="form-group col-md-5" style="display:inline-block;">
						<label for="matricula">CNPJ</label>
						<div class="input-group">
							<input type="text" class="form-control" name="cnpj" id="cnpj">	
						</div>
					</div>
					<div class="form-group col-md-7" style="display:inline-block;">
						<label for="matricula">Raz�o Social</label>
						<div class="input-group">
							<input type="text" class="form-control" name="razao_social" id="razao_social">	
						</div>
					</div>
				</div>
			</fieldset>
			<hr/>
			<div class="btn-group" id="btn-group" role="group" aria-label="Basic example">
				<button type="button"  class="btn btn-active">Cancelar</button>
				<input type="submit" class="btn btn-primary" name="enviar" value="Enviar">
			</div>
		</form>
	</div>			
    <%@ include file="scripts_imports.jspf" %>
</body>
</html>