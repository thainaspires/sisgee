<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registro de Rescisão</title>
	<%@ include file="head_imports.jspf" %>	
	<meta charset="utf-8">
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form method="post" action="FrontControllerServlet?action=ValidarRescisao" id="formulario">
			<h2 class="title-func text-center"><fmt:message key="br.cefetrj.sisgee.termo_rescisao.registrorescisao"></fmt:message></h2>
			<c:if test="${ not empty msg }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg }</div>		
	 		</c:if>
			<fieldset>
				<legend><fmt:message key="br.cefetrj.sisgee.termo_rescisao.dadosaluno"></fmt:message></legend>
				<div class="row">
					<div class="form-group col-md-4" style="display:inline-block;">
						<label for="matricula"><fmt:message key="br.cefetrj.sisgee.termo_rescisao.matricula"></fmt:message></label>
						<div class="input-group">
							<input type="text" class="form-control" name="matricula" id="matricula" value="${ param.matricula }">	
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button" onClick="var form = document.getElementById('formulario');var mat = document.getElementById('matricula').value;form.action='FrontControllerServlet?action=BuscarAluno&matricula='+mat+'&ondeEstaVindo=rescisao';form.submit()">Buscar</button>
							</span>
						</div>
					</div>

					<div class="form-group col-md-8">
						<label for="nome_aluno"><fmt:message key="br.cefetrj.sisgee.termo_rescisao.nome"></fmt:message></label>
						<input type="text" class="form-control" name="nome_aluno" id="nome_aluno" disabled="disabled" value="${ aluno.pessoa }">
					</div>							
					<div class="form-group col-md-6">
						<label for="curso"><fmt:message key="br.cefetrj.sisgee.termo_rescisao.curso"></fmt:message></label>
						<input type="text" class="form-control" name="curso" id="curso" disabled="disabled" value="${ aluno.curso }">
					</div>

					<div class="form-group col-md-6">
						<label for="unidade"><fmt:message key="br.cefetrj.sisgee.termo_rescisao.unidade"></fmt:message></label>
						<input type="text" class="form-control" name="unidade" id="unidade" disabled="disabled" value="${ aluno.curso.campus }">
					</div>
				</div>
			</fieldset>
			<hr/>
			<c:if test="${ not empty msg2 }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg2 }</div>		
	 		</c:if>
			<div class="row" id="recisaogrupo">
				<div class="col-md-4"></div>
				<div class="form-group col-md-4">
						<label for="unidade"><fmt:message key="br.cefetrj.sisgee.termo_rescisao.dataRescisao"></fmt:message></label>
						<input type="text" class="form-control" name="datarescisao" id="datarescisao">
				</div>
			</div>
			<br/>
			<input type="submit" id="btn-enviar" class="btn btn-active" name="enviar" value="<fmt:message key="br.cefetrj.sisgee.termo_rescisao.enviar"></fmt:message>">
		</form>
	</div>			
    <%@ include file="scripts_imports.jspf" %>
    <script type="text/javascript">
    $('#datarescisao').datepicker({
    	<c:if test="${ lang eq 'pt_BR' }">
    	language: 'pt-BR'
        </c:if>
    });
    </script>
</body>
</html>