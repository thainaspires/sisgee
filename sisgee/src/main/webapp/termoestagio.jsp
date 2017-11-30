<%@ taglib prefix="cmp" uri="WEB-INF/components.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registro do Termo de Estágio</title>
	<%@ include file="head_imports.jspf" %>	
	<meta charset="utf-8">	
</head>
<body>

	<%@ include file="menu.jspf" %>
		<!-- Declaração das classes que receberão os parâmetros -->
		<c:if test="${ empty aluno }">
			<jsp:useBean id="pessoa" scope="request" class="br.cefetrj.sisgee.model.entity.Pessoa" type="br.cefetrj.sisgee.model.entity.Pessoa"/>		
				<jsp:setProperty name="pessoa" property="nome" value="${param.nome_aluno}" />
			<jsp:useBean id="campus" scope="request" class="br.cefetrj.sisgee.model.entity.Campus" type="br.cefetrj.sisgee.model.entity.Campus"/>		
				<jsp:setProperty name="campus" property="nomeCampus" value="${param.unidade}" />
			<jsp:useBean id="curso" scope="request" class="br.cefetrj.sisgee.model.entity.Curso" type="br.cefetrj.sisgee.model.entity.Curso"/>		
				<jsp:setProperty name="curso" property="campus" value="${ campus }"/>
				<jsp:setProperty name="curso" property="nomeCurso" value="${ param.curso } "/>
			<jsp:useBean id="aluno" scope="request" class="br.cefetrj.sisgee.model.entity.Aluno" type="br.cefetrj.sisgee.model.entity.Aluno"/>		
				<jsp:setProperty name="aluno" property="pessoa" value="${pessoa}" />
				<jsp:setProperty name="aluno" property="matricula" value="${param.matricula}" />
				<jsp:setProperty name="aluno" property="curso" value="${curso}" />
		</c:if>
		<c:if test="${ not empty aluno }">
			<jsp:useBean id="cursoalt" scope="request" class="br.cefetrj.sisgee.model.entity.Curso" type="br.cefetrj.sisgee.model.entity.Curso"/>		
				<jsp:setProperty name="cursoalt" property="campus" value="${ aluno.getCurso().getCampus() }"/>
		</c:if>
		<c:if test="${ empty termoestagio}">	
			<jsp:useBean id="professororientador" scope="request" class="br.cefetrj.sisgee.model.entity.ProfessorOrientador" type="br.cefetrj.sisgee.model.entity.ProfessorOrientador"/>		
				<jsp:setProperty name="professororientador" property="idpo" value="${ param.professor_orientador }"/>
			<jsp:useBean id="agenteintegracao" scope="request" class="br.cefetrj.sisgee.model.entity.AgenteIntegracao" type="br.cefetrj.sisgee.model.entity.AgenteIntegracao"/>		
				<jsp:setProperty name="agenteintegracao" property="nomeAgenteIntegracao" value="${ param.razao_social }"/>
		</c:if>
		<c:if test="${ empty empresaligada }">
			<jsp:useBean id="empresaligada" scope="request" class="br.cefetrj.sisgee.model.entity.Empresa" type="br.cefetrj.sisgee.model.entity.Empresa"/>		
				<jsp:setProperty name="empresaligada" property="cnpjEmpresa" value="${ param.cnpj_empresa_ligada }"/>
				<jsp:setProperty name="empresaligada" property="nomeEmpresa" value="${ param.razao_social_empresa_ligada }"/>
		</c:if>
		<c:if test="${ empty empresa }">
			<jsp:useBean id="empresa" scope="request" class="br.cefetrj.sisgee.model.entity.Empresa" type="br.cefetrj.sisgee.model.entity.Empresa"/>		
				<jsp:setProperty name="empresa" property="cnpjEmpresa" value="${ param.cnpj_empresa }"/>
				<jsp:setProperty name="empresa" property="nomeEmpresa" value="${ param.razao_social_empresa }"/>
		</c:if>		
	
	<div class="container">
		<form method="post" action="FrontControllerServlet?action=ValidarTermoEstagio" id="formulario">
			<div class="container">
				<!-- Variável de mensagem que mostrao o Status do sistema -->
				<c:if test="${ not empty msg }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg }</div>		
	 			</c:if>
				<!--<form>  -->
					<fieldset>
						<legend id="title-te"><fmt:message key="br.cefetrj.sisgee.termo_estagio.titulo"/></legend>
						<legend><fmt:message key="br.cefetrj.sisgee.termo_estagio.dadosempresa"/></legend>
						<div class="row">
							<div class="form-group col-md-12">
								<label for="numero_convenio"><fmt:message key="br.cefetrj.sisgee.termo_estagio.numconvenio"></fmt:message></label>
								<input type="text" class="form-control" name="numero_convenio" id="numero_convenio" value="${ param.numero_convenio }">
							</div>
							<!-- Campo hidden que pega o valor do Radio necessário para o JS -->
							<input type="hidden" id="valorRadio" value="${param.exampleRadios}"/>
							<div class="form-group col-md-12">
								<div>
									<label for="isn_obrigatorio"><fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agente"></fmt:message></label>
									<br/>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" id="exampleRadios1" name="exampleRadios" value="sim"  onclick='eagente("sim");'/>
									  <fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agentesim"></fmt:message>
									</label>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" id="exampleRadios2" name="exampleRadios" value="nao" onclick='eagente("nao");'/>
									  <fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agentenao"></fmt:message>
									</label>
								</div>
							</div>
								<div id="agente1" class="col-md-12">
									<div class="form-group col-md-4">
										<label for="razao_social"><fmt:message key="br.cefetrj.sisgee.termo_estagio.razao"></fmt:message></label>
										
										<!-- Tag para listar os Agentes de Integração -->	
										<cmp:ComboAgente nome="${ agenteintegracao.nomeAgenteIntegracao }"/>
														
										<a href="cadastrar_empresa.jsp" style="float:right;"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cadastro_empresa"></fmt:message></a>							
									</div>									
									<div class="form-group col-md-6" style="display:inline-block;">
										<label for="cnpj_empresa_ligada"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cnpj_empresa_ligada"></fmt:message></label>
										<div class="input-group">
											<input type="text" class="form-control" name="cnpj_empresa_ligada" id="cnpj_empresa_ligada" value="${ empresaligada.cnpjEmpresa }">	
											<span class="input-group-btn">
												<button class="btn btn-primary" type="button" onClick="buscarEmpresaLigada();"><fmt:message key="br.cefetrj.sisgee.termo_estagio.buscar"></fmt:message></button>
											</span>
										</div>
									</div>
									<div class="form-group col-md-6" style="display:inline-block;">
										<label for="razao_social_empresa_ligada"><fmt:message key="br.cefetrj.sisgee.termo_estagio.razao_empresa_ligada"></fmt:message></label>
										<div class="input-group">
											<input type="text" class="form-control" name="razao_social_empresa_ligada" disabled="disabled" id="razao_social_empresa_ligada" value="${ empresaligada.nomeEmpresa }">	
											<span class="input-group-btn">
												<button class="btn btn-primary btn-plus" type="button" onclick="javascript:location.href='registrar_empresa_ligada_ai.jsp'">+</button>
											</span>
										</div>
									</div>
								</div>
								
								<div id="agente2" class="col-md-12" style="display:none;">									
									<div class="form-group col-md-6">
										<label for="cnpj_empresa"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cnpj"></fmt:message></label>
										<div class="input-group">
											<input type="text" class="form-control" name="cnpj_empresa" id="cnpj_empresa" value="${ empresa.cnpjEmpresa }">	
											<span class="input-group-btn">
												<button class="btn btn-primary" type="button" onClick="buscarEmpresa();"><fmt:message key="br.cefetrj.sisgee.termo_estagio.buscar"></fmt:message></button>
											</span>
										</div>
									</div>
									<div class="form-group col-md-6">
										<label for="razao_social_empresa"><fmt:message key="br.cefetrj.sisgee.termo_estagio.razao"></fmt:message></label>
										<div class="input-group">
											<input type="text" class="form-control" name="razao_social_empresa" id="razao_social_empresa" disabled="disabled" value="${ empresa.nomeEmpresa }">	
											<span class="input-group-btn">
												<button class="btn btn-primary btn-plus" type="button">+</button>
											</span>
										</div>
									</div>	
								</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend><fmt:message key="br.cefetrj.sisgee.termo_estagio.dadosaluno"></fmt:message></legend>
						<div class="row">
							<div class="form-group col-md-4" style="display:inline-block;">
								<label for="matricula"><fmt:message key="br.cefetrj.sisgee.termo_estagio.matricula"></fmt:message></label>
								<input type="hidden" id="idAluno" name="idAluno" value="${ idAluno }"/>
								
								<div class="input-group">
									<input type="text" class="form-control" name="matricula" id="matricula" value="${ aluno.matricula }">	
									<span class="input-group-btn"> <!-- javascript:location.href='FrontControllerServlet?action=ConsultasTermoEst&matricula='+mat+'&form='+form+'&ondeEstaVindo=termoestagio'-->
										<button class="btn btn-primary" type="button" onClick="buscarAluno();">
											<span><fmt:message key="br.cefetrj.sisgee.termo_estagio.buscar"></fmt:message></span>
										</button>
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
								<input type="text" class="form-control" name="unidade" id="unidade" disabled="disabled" value="${ not empty aluno ? cursoalt.campus : curso.campus}">
							</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend><fmt:message key="br.cefetrj.sisgee.termo_estagio.vigencia_estagio"></fmt:message></legend>
						<div class="row">
							<div class="form-group col-md-3">
								<label for="data_inicio"><fmt:message key="br.cefetrj.sisgee.termo_estagio.data_inicio"></fmt:message></label>
								<input type="text" class="form-control" name="data_inicio" id="data_inicio" value="${ param.data_inicio }">
							</div>

							<div class="form-group col-md-3">
								<label for="data_termino"><fmt:message key="br.cefetrj.sisgee.termo_estagio.data_fim" ></fmt:message></label>
								<input type="text" class="form-control" name="data_termino" id="data_termino" value="${ param.data_termino }">
							</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend><fmt:message key="br.cefetrj.sisgee.termo_estagio.ch_aluno"></fmt:message></legend>
						<div class="row">		
							<div class="form-group col-md-3">
								<label for="horas_dia"><fmt:message key="br.cefetrj.sisgee.termo_estagio.horas_por_dia"></fmt:message></label>
								<input type="number" class="form-control" name="horas_dia" id="horas_dia" min="0" value="${ param.horas_dia }">
							</div>
						</div>
					</fieldset>
					<hr />	
					<fieldset>
						<legend><fmt:message>br.cefetrj.sisgee.termo_estagio.valor_estagio</fmt:message></legend>
						<div class="row">			
							<div class="form-group col-md-3">
								<label for="valor_bolsa"><fmt:message key="br.cefetrj.sisgee.termo_estagio.valor"></fmt:message></label>
								<input type="text" class="form-control" name="valor_bolsa" id="valor_bolsa" min="0" value="${ param.valor_bolsa }"/>
							</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend><fmt:message key="br.cefetrj.sisgee.termo_estagio.local_estagio"></fmt:message></legend>
						<div class="row">						
							<div class="form-group col-md-9">
								<label for="endereco"><fmt:message key="br.cefetrj.sisgee.termo_estagio.endereco"></fmt:message></label>
								<input type="text" class="form-control" name="endereco" id="endereco" value="${ param.endereco }">
							</div>

							<div class="form-group col-md-3">
								<label for="compelemento"><fmt:message key="br.cefetrj.sisgee.termo_estagio.complemento"></fmt:message></label>
								<input type="text" class="form-control" name="complemento" id="complemento" value="${ param.complemento }">
							</div>

							<div class="form-group col-md-3">
								<label for="bairro"><fmt:message key="br.cefetrj.sisgee.termo_estagio.bairro"></fmt:message></label>
								<input type="text" class="form-control" name="bairro" id="bairro" value="${ param.bairro }">
							</div>

							<div class="form-group col-md-3">
								<label for="cidade"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cidade"></fmt:message></label>
								<input type="text" class="form-control" name="cidade" id="cidade" value="${ param.cidade }">
							</div>

							<div class="form-group col-md-4">
								<label for="estado"><fmt:message key="br.cefetrj.sisgee.termo_estagio.estado"></fmt:message></label>
								<select class="form-control" class="form-control" name="estado" id="estado">
									<option ${ param.estado eq "AC" ? "selected" : "" } value="AC">Acre</option>
									<option ${ param.estado eq "AL" ? "selected" : "" } value="AL">Alagoas</option>
									<option ${ param.estado eq "AP" ? "selected" : "" } value="AP">Amapá</option>
									<option ${ param.estado eq "AM" ? "selected" : "" } value="AM">Amazonas</option>
									<option ${ param.estado eq "BA" ? "selected" : "" } value="BA">Bahia</option>
									<option ${ param.estado eq "CE" ? "selected" : "" } value="CE">Ceará</option>
									<option ${ param.estado eq "DF" ? "selected" : "" } value="DF">Distrito Federal</option>
									<option ${ param.estado eq "ES" ? "selected" : "" } value="ES">Espírito Santo</option>
									<option ${ param.estado eq "GO" ? "selected" : "" } value="GO">Goiás</option>
									<option ${ param.estado eq "MA" ? "selected" : "" } value="MA">Maranhão</option>
									<option ${ param.estado eq "MT" ? "selected" : "" } value="MT">Mato Grosso</option>
									<option ${ param.estado eq "MS" ? "selected" : "" } value="MS">Mato Grosso do Sul</option>
									<option ${ param.estado eq "MG" ? "selected" : "" } value="MG">Minas Gerais</option>
									<option ${ param.estado eq "PA" ? "selected" : "" } value="PA">Pará</option>
									<option ${ param.estado eq "PB" ? "selected" : "" } value="PB">Paraíba</option>
									<option ${ param.estado eq "PR" ? "selected" : "" } value="PR">Paraná</option>
									<option ${ param.estado eq "PE" ? "selected" : "" } value="PE">Pernambuco</option>
									<option ${ param.estado eq "PI" ? "selected" : "" } value="PI">Piauí</option>
									<option ${ param.estado eq "RJ" ? "selected" : "" } value="RJ">Rio de Janeiro</option>
									<option ${ param.estado eq "RN" ? "selected" : "" } value="RN">Rio Grande do Norte</option>
									<option ${ param.estado eq "RS" ? "selected" : "" } value="RS">Rio Grande do Sul</option>
									<option ${ param.estado eq "RO" ? "selected" : "" } value="RO">Rondônia</option>
									<option ${ param.estado eq "RR" ? "selected" : "" } value="RR">Roraima</option>
									<option ${ param.estado eq "SC" ? "selected" : "" } value="SC">Santa Catarina</option>
									<option ${ param.estado eq "SP" ? "selected" : "" } value="SP">São Paulo</option>
									<option ${ param.estado eq "SE" ? "selected" : "" } value="SE">Sergipe</option>
									<option ${ param.estado eq "TO" ? "selected" : "" } value="TO">Tocantins</option>
								</select>
							</div>

							<div class="form-group col-md-2">
								<label for="cep"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cep"></fmt:message></label>
								<input type="text" class="form-control" name="cep" id="cep" value="${ param.cep }">
							</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend></legend>
						<div class="row">
							<div class="form-group col-md-12">
							<input type="hidden" id="valorprof" value="${param.isn_obrigatorio}"/>
								<div>
									<label for="isn_obrigatorio"><fmt:message key="br.cefetrj.sisgee.termo_estagio.prof_orientador"></fmt:message></label>
									<br/>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="isn_obrigatorio" id="temProfessor" value="s"/>
									  <fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agentesim"></fmt:message>
									</label>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="isn_obrigatorio" id="naoTemProfessor" value="n"/>
									  <fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agentenao"></fmt:message>
									</label>
								</div>
							</div>

							<div class="form-group col-md-9">
								<label for="professor_orientador"><fmt:message key="br.cefetrj.sisgee.termo_estagio.prof_orientador"></fmt:message></label>
								<cmp:ComboProfessor id="${ professororientador.idpo }"/>
							</div>
						</div>
					</fieldset>
						<div class="btn-group" id="btn-group" role="group" aria-label="Basic example">
							<button type="submit" class="btn btn-active" name="cancelar"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cancelar"></fmt:message></button>
							<input type="submit" id="btn-enviar" class="btn btn-primary" name="enviar" value="<fmt:message key='br.cefetrj.sisgee.termo_estagio.enviar'></fmt:message>" >
						</div>
				<!-- </form> -->
			</div>			
		</form>
	</div>
    <%@ include file="scripts_imports.jspf" %>
 	<script src="js/termoestagio.js"></script>
 	
 	<script type="text/javascript">
	 	$('#data_termino').datepicker({
	 		<c:if test="${ lang eq 'pt_BR' }">
	 		language: 'pt-BR'
	 	    </c:if>
	 	});
	
	 	$('#data_inicio').datepicker({
	 		<c:if test="${ lang eq 'pt_BR' }">
	 		language: 'pt-BR'
	 	    </c:if>
	 	});
 	</script>
</body>
</html>