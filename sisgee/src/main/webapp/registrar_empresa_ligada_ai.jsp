<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registro de Empresa Ligada ao Agente de Integração</title>
	<%@ include file="head_imports.jspf" %>	
	<meta charset="utf-8">
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form method="post" action="">
			<h2 class="title-func text-center" style="margin-bottom: 20px;">Registro de Empresa Ligada ao Agente de Integração</h2>
			<fieldset>
				<div class="row">
					<div class="form-group col-md-12">
						<label for="agente-integracao">Agente de Integração</label>
						<div class="input-group">
							<input type="text" class="form-control" name="agente-integracao" id="agente-integracao">	
						</div>
					</div>
					<div class="form-group col-md-5">
						<label for="matricula">CNPJ</label>
						<div class="input-group">
							<input type="text" class="form-control" name="cnpj" id="cnpj">	
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button">Buscar</span></button>
							</span>
						</div>
					</div>
					<div class="form-group col-md-7">
						<label for="matricula">Razão Social</label>
						<div class="input-group">
							<input type="text" class="form-control" name="razao_social" id="razao_social" disabled="disabled">	
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