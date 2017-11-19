<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Registro do Termo de Est�gio</title>
	<%@ include file="head_imports.jspf" %>	
	<meta charset="utf-8">
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form method="post" action="">
			<div class="container">
				<form>
					<fieldset>
						<legend id="title-te">Dados da Empresa Conveniada</legend>
						<div class="row">
							<div class="form-group col-md-12">
								<label for="numero_convenio">N�mero do Conv�nio</label>
								<input type="text" class="form-control" name="numero_convenio" id="numero_convenio">
							</div>
							<div class="form-group col-md-12">
								<div>
									<label for="isn_obrigatorio">� agente de integra��o?</label>
									<br/>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="exampleRadios" checked onclick='eagente("sim");'/>
									  Sim
									</label>
									<label class="form-check-label">
									  <input class="form-check-input" type="radio" name="exampleRadios" onclick='eagente("nao");'/>
									  N�o
									</label>
								</div>
							</div>
								<div id="agente1" class="col-md-12">
									<div class="form-group col-md-4">
										<label for="razao_social">Raz�o Social</label>
										<select style="float:left;" id="razao_social" class="form-control">
							  				<option value="" selected>Valor A</option>
									  		<option value="">Valor B</option>
									  		<option value="">Valor C</option>						  
										</select>	
										<a href="#" style="float:right;">Cadastrar empresa</a>							
									</div>									
									<div class="form-group col-md-6" style="display:inline-block;">
										<label for="cnpj_empresa_ligada">CNPJ da Empresa Ligada ao Agente de Integra��o</label>
										<div class="input-group">
											<input type="text" class="form-control" name="cnpj_empresa_ligada" id="cnpj_empresa_ligada">	
											<span class="input-group-btn">
												<button class="btn btn-primary" type="button">Buscar</span></button>
											</span>
										</div>
									</div>
									<div class="form-group col-md-6" style="display:inline-block;">
										<label for="razao_social_empresa_ligada">Raz�o Social da Empresa Ligada ao Agente de Integra��o</label>
										<!--<input class="form-control" name="razao_social_empresa_ligada" id="razao_social_empresa_ligada"/>-->
										<div class="input-group">
											<input type="text" class="form-control" name="razao_social_empresa_ligada" id="razao_social_empresa_ligada" disabled="disabled">	
											<span class="input-group-btn">
												<button class="btn btn-primary btn-plus" type="button" onclick="javascript:location.href='registrar_empresa_ligada_ai.jsp'">+</button>
											</span>
										</div>
									</div>
								</div>
								
								<div id="agente2" class="col-md-12" style="display:none;">									
									<div class="form-group col-md-6">
										<label for="cnpj_empresa_ligada">CNPJ</label>
										<div class="input-group">
											<input type="text" class="form-control" name="cnpj_empresa" id="cnpj_empresa">	
											<span class="input-group-btn">
												<button class="btn btn-primary" type="button">Buscar</span></button>
											</span>
										</div>
									</div>
									<div class="form-group col-md-6">
										<label for="razao_social_empresa_ligada">Raz�o Social</label>
										<div class="input-group">
											<input type="text" class="form-control" name="razao_social_empresa" id="razao_social_empresa" disabled="disabled">	
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
						<legend>Dados do Aluno</legend>
						<div class="row">
							<div class="form-group col-md-4" style="display:inline-block;">
								<label for="matricula">Matr�cula</label>
								<div class="input-group">
									<input type="text" class="form-control" name="matricula" id="matricula">	
									<span class="input-group-btn">
										<button class="btn btn-primary" type="button">Buscar</span></button>
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
					<hr />
					<fieldset>
						<legend>Vig�ncia do Est�gio</legend>
						<div class="row">
							<div class="form-group col-md-3">
								<label for="data_inicio">Data de In�cio</label>
								<input type="date" class="form-control" name="data_inicio" id="data_inicio">
							</div>

							<div class="form-group col-md-3">
								<label for="data_termino">Data de T�rmino</label>
								<input type="date" class="form-control" name="data_termino" id="data_termino">
							</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend>Carga Hor�ria do Aluno</legend>
						<div class="row">		
							<div class="form-group col-md-3">
								<label for="horas_dia">Horas por dia</label>
								<input type="number" class="form-control" name="horas_dia" id="horas_dia" min="0">
							</div>
						</div>
					</fieldset>
					<hr />	
					<fieldset>
						<legend>Valor da Bolsa de Est�gio</legend>
						<div class="row">			
							<div class="form-group col-md-3">
								<label for="valor_bolsa">Valor</label>
								<input type="number" class="form-control" name="valor_bolsa" id="valor_bolsa" min="0">
							</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend>Local do Est�gio</legend>
						<div class="row">						
							<div class="form-group col-md-9">
								<label for="endereco">Endere�o</label>
								<input type="text" class="form-control" name="endereco" id="endereco">
							</div>

							<div class="form-group col-md-3">
								<label for="compelemento">Complemento</label>
								<input type="text" class="form-control" name="compelemento" id="compelemento">
							</div>

							<div class="form-group col-md-3">
								<label for="bairro">Bairro</label>
								<input type="text" class="form-control" name="bairro" id="bairro">
							</div>

							<div class="form-group col-md-3">
								<label for="cidade">Cidade</label>
								<input type="text" class="form-control" name="cidade" id="cidade">
							</div>

							<div class="form-group col-md-4">
								<label for="estado">Estado</label>
								<select class="form-control" class="form-control" name="estado" id="estado">
									<option value="AC">Acre</option>
									<option value="AL">Alagoas</option>
									<option value="AP">Amap�</option>
									<option value="AM">Amazonas</option>
									<option value="BA">Bahia</option>
									<option value="CE">Cear�</option>
									<option value="DF">Distrito Federal</option>
									<option value="ES">Esp�rito Santo</option>
									<option value="GO">Goi�s</option>
									<option value="MA">Maranh�o</option>
									<option value="MT">Mato Grosso</option>
									<option value="MS">Mato Grosso do Sul</option>
									<option value="MG">Minas Gerais</option>
									<option value="PA">Par�</option>
									<option value="PB">Para�ba</option>
									<option value="PR">Paran�</option>
									<option value="PE">Pernambuco</option>
									<option value="PI">Piau�</option>
									<option value="RJ">Rio de Janeiro</option>
									<option value="RN">Rio Grande do Norte</option>
									<option value="RS">Rio Grande do Sul</option>
									<option value="RO">Rond�nia</option>
									<option value="RR">Roraima</option>
									<option value="SC">Santa Catarina</option>
									<option value="SP">S�o Paulo</option>
									<option value="SE">Sergipe</option>
									<option value="TO">Tocantins</option>
								</select>
							</div>

							<div class="form-group col-md-2">
								<label for="cep">CEP</label>
								<input type="text" class="form-control" name="cep" id="cep">
							</div>
						</div>
					</fieldset>
					<hr />
					<fieldset>
						<legend></legend>
						<div class="row">
							<div class="form-group col-md-12">
								<div>
									<label for="isn_obrigatorio">O Est�gio � Obrigat�rio</label>
									<br/>
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

							<div class="form-group col-md-9">
								<label for="professor_orientador">Professor Orientador</label>
								<select class="form-control" class="form-control" name="professor_orientador" id="professor_orientador">
									<option value="ba">Eduardo Bezerra</option>
									<option value="pa">Diogo Mendon�a</option>
								</select>
							</div>
						</div>
					</fieldset>
					<input type="submit" id="btn-enviar" class="btn btn-active" name="enviar" value="Enviar">
				</form>
			</div>			
		</form>
	</div>
    <%@ include file="scripts_imports.jspf" %>
</body>
</html>