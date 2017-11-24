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
	
	<div class="container">
		num = ${ param.numero_convenio }
		razao = ${ param.razao_social_empresa }
		<form method="post" action="FrontControllerServlet?action=ValidarTermoEstagio" id="formulario">
			<div class="container">
				<c:if test="${ not empty msg }">
	 				<div class="alert" style="margin-top: 20px; background: #B8B3CC;">${ msg }</div>		
	 			</c:if>
				<!--<form>  -->
					<fieldset>
						<legend id="title-te"><fmt:message key="br.cefetrj.sisgee.termo_estagio.titulo"/></legend>
						<div class="row">
							<div class="form-group col-md-12">
								<label for="numero_convenio"><fmt:message key="br.cefetrj.sisgee.termo_estagio.numconvenio"></fmt:message></label>
								<input type="text" class="form-control" name="numero_convenio" id="numero_convenio" value="${ param.numero_convenio }">
							</div>
							<div class="form-group col-md-12">
								<div>
									<label for="isn_obrigatorio"><fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agente"></fmt:message></label>
									<br/>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="exampleRadios" ${ param.exampleRadios eq "sim" ? "checked" : "" } onclick='eagente("sim");'/>
									  <fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agentesim"></fmt:message>
									</label>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="exampleRadios" ${ param.exampleRadios eq "nao" ? "checked" : "" } onclick='eagente("nao");'/>
									  <fmt:message key="br.cefetrj.sisgee.termo_estagio.is_agentenao"></fmt:message>
									</label>
								</div>
							</div>
								<div id="agente1" class="col-md-12">
									<div class="form-group col-md-4">
										<label for="razao_social"><fmt:message key="br.cefetrj.sisgee.termo_estagio.razao"></fmt:message></label>
										<select style="float:left;" id="razao_social" name="razao_social" class="form-control">
									  		<c:forEach items="${ agentesIntegracao }" var="agentesIntegracao">
												<option value="${ agentesIntegracao.idAgenteIntegracao }" ${ param.agentesIntegracao eq agentesIntegracao.idAgenteIntegracao ? "selected" : "" } > ${ agentesIntegracao.nomeAgenteIntegracao }</option>
											</c:forEach>						  
										</select>	

										<a href="cadastrar_empresa.jsp" style="float:right;"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cadastro_empresa"></fmt:message></a>							
									</div>									
									<div class="form-group col-md-6" style="display:inline-block;">
										<label for="cnpj_empresa_ligada"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cnpj_empresa_ligada"></fmt:message></label>
										<div class="input-group">
											<input type="text" class="form-control" name="cnpj_empresa_ligada" id="cnpj_empresa_ligada" value="${ param.cnpj_empresa_ligada }">	
											<span class="input-group-btn">
												<button class="btn btn-primary" type="button" onClick="var form = document.getElementById('formulario');var cnpj = document.getElementById('cnpj_empresa_ligada').value;form.action='FrontControllerServlet?action=BuscarEmpresaLigada&cnpj_empresa_ligada='+cnpj;form.submit()""><fmt:message key="br.cefetrj.sisgee.termo_estagio.buscar"></fmt:message></button>
											</span>
										</div>
									</div>
									<div class="form-group col-md-6" style="display:inline-block;">
										<label for="razao_social_empresa_ligada"><fmt:message key="br.cefetrj.sisgee.termo_estagio.razao_empresa_ligada"></fmt:message></label>
										<!--<input class="form-control" name="razao_social_empresa_ligada" id="razao_social_empresa_ligada"/>-->
										<div class="input-group">
											<input type="text" class="form-control" name="razao_social_empresa_ligada" id="razao_social_empresa_ligada" disabled="disabled" value="${ empresaLigadaAIBuscada.nomeEmpresa }">	
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
											<input type="text" class="form-control" name="cnpj_empresa" id="cnpj_empresa" value="${ param.cnpj_empresa }">	
											<span class="input-group-btn">
												<button class="btn btn-primary" type="button" onClick="var form = document.getElementById('formulario');var cnpj = document.getElementById('cnpj_empresa').value;form.action='FrontControllerServlet?action=BuscarEmpresa&cnpj_empresa='+cnpj;form.submit()"><fmt:message key="br.cefetrj.sisgee.termo_estagio.buscar"></fmt:message></button>
											</span>
										</div>
									</div>
									<div class="form-group col-md-6">
										<label for="razao_social_empresa_ligada"><fmt:message key="br.cefetrj.sisgee.termo_estagio.razao"></fmt:message></label>
										<div class="input-group">
											<input type="text" class="form-control" name="razao_social_empresa" id="razao_social_empresa" disabled="disabled" value="${ param.razao_social_empresa }">	
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
								<div class="input-group">
									<input type="text" class="form-control" name="matricula" id="matricula" value="${ param.matricula }">	
									<span class="input-group-btn"> <!-- javascript:location.href='FrontControllerServlet?action=ConsultasTermoEst&matricula='+mat+'&form='+form"-->
										<button class="btn btn-primary" type="button" onClick="var form = document.getElementById('formulario');var mat = document.getElementById('matricula').value;form.action='FrontControllerServlet?action=BuscarAluno&matricula='+mat;form.submit()">
											<span><fmt:message key="br.cefetrj.sisgee.termo_estagio.buscar"></fmt:message></span>
										</button>
									</span>
								</div>
							</div>
							

							<div class="form-group col-md-8">
								<label for="nome_aluno"><fmt:message key="br.cefetrj.sisgee.termo_estagio.nomealuno"></fmt:message></label>
								<input type="text" class="form-control" name="nome_aluno" id="nome_aluno" disabled="disabled" value="${ alunoBuscado.pessoa }">
							</div>							
							<div class="form-group col-md-6">
								<label for="curso"><fmt:message key="br.cefetrj.sisgee.termo_estagio.cursoaluno"></fmt:message></label>
								<input type="text" class="form-control" name="curso" id="curso" disabled="disabled" value="${ alunoBuscado.curso }">
							</div>

							<div class="form-group col-md-6">
								<label for="unidade"><fmt:message key="br.cefetrj.sisgee.termo_estagio.unidadealuno"></fmt:message></label>
								<input type="text" class="form-control" name="unidade" id="unidade" disabled="disabled" value="${ alunoBuscado.curso.campus }">
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
									<option value="AC">Acre</option>
									<option value="AL">Alagoas</option>
									<option value="AP">Amapá</option>
									<option value="AM">Amazonas</option>
									<option value="BA">Bahia</option>
									<option value="CE">Ceará</option>
									<option value="DF">Distrito Federal</option>
									<option value="ES">Espírito Santo</option>
									<option value="GO">Goiás</option>
									<option value="MA">Maranhão</option>
									<option value="MT">Mato Grosso</option>
									<option value="MS">Mato Grosso do Sul</option>
									<option value="MG">Minas Gerais</option>
									<option value="PA">Pará</option>
									<option value="PB">Paraíba</option>
									<option value="PR">Paraná</option>
									<option value="PE">Pernambuco</option>
									<option value="PI">Piauí</option>
									<option value="RJ">Rio de Janeiro</option>
									<option value="RN">Rio Grande do Norte</option>
									<option value="RS">Rio Grande do Sul</option>
									<option value="RO">Rondônia</option>
									<option value="RR">Roraima</option>
									<option value="SC">Santa Catarina</option>
									<option value="SP">São Paulo</option>
									<option value="SE">Sergipe</option>
									<option value="TO">Tocantins</option>
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
								<div>
									<label for="isn_obrigatorio"><fmt:message key="br.cefetrj.sisgee.termo_estagio.prof_orientador"></fmt:message></label>
									<br/>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="isn_obrigatorio" checked value="s"/>
									  Sim
									</label>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="isn_obrigatorio" value="n"/>
									  Não
									</label>
								</div>
							</div>

							<div class="form-group col-md-9">
								<label for="professor_orientador"><fmt:message key="br.cefetrj.sisgee.termo_estagio.prof_orientador"></fmt:message></label>
								<select class="form-control" class="form-control" name="professor_orientador" id="professor_orientador">
									<c:forEach items="${professoresOrientadores}" var="professoresOrientadores">
										<option value="${ professoresOrientadores.idpo }" ${ param.professoresOrientadores eq professoresOrientadores.idpo ? "selected" : "" } > ${ professoresOrientadores.nomepo }</option>
									</c:forEach>
								</select>
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
    <script type="text/javascript">
		function eagente(tipo){
			if(tipo=="sim"){
				document.getElementById("agente1").style.display="block";
				document.getElementById("agente2").style.display="none";
				
				document.getElementById("cnpj_empresa").setAttribute("disabled","disabled");
				
				document.getElementById("cnpj_empresa_ligada").removeAttribute("disabled");
				document.getElementById("razao_social_empresa_ligada").removeAttribute("disabled");
				
			} else {
				document.getElementById("agente1").style.display="none";
				document.getElementById("agente2").style.display="inherit";
				
				document.getElementById("cnpj_empresa_ligada").setAttribute("disabled","disabled");
				
				document.getElementById("cnpj_empresa").removeAttribute("disabled");
				
			}
		}
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