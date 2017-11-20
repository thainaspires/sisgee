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
		<form method="post" action="FrontControllerServlet?action=CadastrarEmpresa">
			<h2 class="title-func text-center" style="margin-bottom: 20px;">Registro de Empresas (ou Agente de Integração)</h2>
			<c:if test="${ not empty msg }">
				<h2></h2>
				<div class="alert alert-danger">
				  ${ msg }
				</div>
			</c:if>
			<div class="form-group col-md-12" id="radioestagio">
				<label style="float: left; margin-right: 25px;">É Agente de Integração?</label>
				<div>
					<label class="form-check-label">
					  <input class="form-check-input" type="radio" name="agente" checked ${ param.agente eq "s" ? "checked" : "" } value="s"/>
					  Sim
					</label>
					<label class="form-check-label">
					  <input class="form-check-input" type="radio" name="agente" ${ param.agente eq "n" ? "checked" : "" } value="n"/>
					  Não
					</label>
				</div>
			</div>
			<fieldset>
				<div class="row">
					<div class="form-group col-md-5" style="display:inline-block;">
						<label for="cnpj">CNPJ</label>
						<div class="input-group">
							<input type="text" class="form-control" name="cnpj" value="${ param.cnpj }" id="cnpj">	
						</div>
					</div>
					<div class="form-group col-md-7" style="display:inline-block;">
						<label for="razao_social">Razão Social</label>
						<div class="input-group">
							<input type="text" class="form-control" name="razaosocial" value="${ param.razaosocial }" id="razaosocial">	
						</div>
					</div>
				</div>
			</fieldset>
			<hr/>
			<div class="btn-group" id="btn-group" role="group" aria-label="Basic example">
				<button type="button" class="btn btn-active" onClick="history.back()">Cancelar</button>
				<input type="submit" class="btn btn-primary" name="enviar" value="Enviar">
			</div>
		</form>
	</div>			
    <%@ include file="scripts_imports.jspf" %>
</body>
</html>