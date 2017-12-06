package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.control.ConvenioServices;
import br.cefetrj.sisgee.control.EmpresaServices;
import br.cefetrj.sisgee.control.ProfessorOrientadorServices;
import br.cefetrj.sisgee.control.TermoEstagioServices;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Convenio;
import br.cefetrj.sisgee.model.entity.Empresa;
import br.cefetrj.sisgee.model.entity.ProfessorOrientador;
import br.cefetrj.sisgee.model.entity.TermoEstagio;
/**
 * 
 * @author Thain�
 * Command para cadastrar o termo de estágio e realizar validação de seus dados
 * 
 */

public class ValidarTermoEstagioCommand implements Command {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Convenio convincluido = new Convenio();
		List<Convenio> resultconvenio= null;
		Aluno aluno = null;
		String numConvenio = req.getParameter("numero_convenio");
		Convenio convenio = null;
		String matricula = req.getParameter("matricula");
		ProfessorOrientador professor = null;
		Empresa empresa = new Empresa();
		String msg = "";
		String isn_obrigatorio = req.getParameter("isn_obrigatorio");
		String professor_orientador = "";
		
		professor_orientador = req.getParameter("professor_orientador");
		if (matricula != null && matricula.trim().length() > 0){
			List<Aluno> alunoList = null;
			alunoList = AlunoServices.buscarDetermAluno(matricula);
			if(!(alunoList.isEmpty())){
				aluno = alunoList.get(0);
			} else {
				msg += "Matr�cula n�o encontrada.";
			}	
		}else{
			msg += " � necess�rio digitar uma matr�cula.";
		}
		
		String eagente = req.getParameter("exampleRadios");
		String cnpj_empresa = req.getParameter("cnpj_empresa");
		String nome_empresa = req.getParameter("razao_social_empresa");
		String cnpj_empresa_ligada = req.getParameter("cnpj_empresa_ligada");
		String nome_agente = req.getParameter("razao_social");
	
		
		
		String dataInicio = req.getParameter("data_inicio");
		String dataTermino = req.getParameter("data_termino");
		java.sql.Date dataSql = null;
	    java.sql.Date dataSql2 = null;
		
		//valida��o das datas de vigencia
		if(dataInicio != null && dataInicio.length() != 0 && dataTermino != null && dataTermino.length() != 0 && 
		dataInicio.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d") && dataTermino.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date dataInicioFormatada = null;
			Date dataTerminoFormatada = null;
			try {
				dataInicioFormatada = formato.parse(dataInicio);
				dataTerminoFormatada = formato.parse(dataTermino);
			} catch (ParseException e) {
				/**TODO: **/
			}
			Date dataUtil = dataInicioFormatada;
	        Date dataUtil2 = dataTerminoFormatada;
	        
	        try {
	            dataUtil = new java.sql.Date(dataUtil.getTime());
	            dataUtil2 = new java.sql.Date(dataUtil2.getTime());
	            dataSql = (java.sql.Date) dataUtil;
	            dataSql2 = (java.sql.Date) dataUtil2;
	        } catch (Exception e) {
	            /**TODO: **/
	        }
	        
	        if (dataSql.after(dataSql2)){
		        msg+=" Data inicial deve ser antes da data final.";
		    }
			
		}else{
			if(dataInicio == null || dataInicio.length() == 0){
				msg+=" Data inicio n�o pode estar vazia. ";
			}
			if(dataTermino == null || dataTermino.length() == 0){
				msg+=" Data final n�o pode estar vazia. ";
			}
			if(!dataTermino.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
				msg+=" Data Termino precisa estar no formato DD/MM/AAAA.";
			}
			if(!dataInicio.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
				msg+=" Data Inicio precisa estar no formato DD/MM/AAAA. ";
			}
		}
		
		String horas_dia = req.getParameter("horas_dia");
		
		//valida��o das horas
		if(horas_dia == null || horas_dia.trim().length() == 0){
			msg+=" Por favor digite a carga hor�ria do aluno.";
		}else{
			try {
				Integer horas_dia_ = Integer.parseInt(horas_dia);
				if(horas_dia_ < 0 || horas_dia_ > 6){
					msg += " Carga hor�ria do aluno precisa ser maior que 0 e menor que 6.";
				}
			} catch (Exception e) {
				msg += " Carga hor�ria precisa ser digito.";
			}
		}
		
		String valor_bolsa = req.getParameter("valor_bolsa");
		
		//Valida��o do valor da bolsa
		if(valor_bolsa == null || valor_bolsa.trim().length() == 0){
			msg+=" Por favor digite o valor da bolsa do aluno.";
		}else{
			try {
				Float valor_bolsa_ = Float.parseFloat(valor_bolsa);
				if(valor_bolsa_ < 0){
					msg += " Valor da bolsa do aluno precisa ser maior que 0.";
				}
			} catch (Exception e) {
				msg += " Valor da bolsa precisa ser d�gito (com ponto se necess�rio para n�mero quebrado).";
			}
		}
		
		String endereco = req.getParameter("endereco");
		
		//Valida��o do endere�o
		if(endereco == null || endereco.trim().length() == 0){
			msg+=" Por favor digite o endere�o do aluno.";
		}else{
			if (endereco.length() > 255){
				msg+=" Endere�o s� pode ter at� 255 caracteres.";
			}
		}
		
		String complemento = req.getParameter("complemento");
		//Valida��o do complemento
		if(complemento == null || complemento.trim().length() == 0){
			msg+=" Por favor digite o complemento do aluno.";
		}else{
			if (complemento.length() > 150){
				msg+=" Complemento s� pode ter at� 150 caracteres.";
			}
		}
		
		String bairro = req.getParameter("bairro");
		//Valida��o do bairro
		if(bairro == null || bairro.trim().length() == 0){
			msg+=" Por favor digite o bairro do aluno.";
		}else{
			if (bairro.length() > 150){
				msg+=" Bairro s� pode ter at� 150 caracteres.";
			}
		}
		
		String cidade = req.getParameter("cidade");
		//Valida��o do cidade
		if(cidade == null || cidade.trim().length() == 0){
			msg+=" Por favor digite o cidade do aluno.";
		}else{
			if (cidade.length() > 150){
				msg+=" Cidade s� pode ter at� 150 caracteres.";
			}
		} 
		
		String estado = req.getParameter("estado");
		//Valida��o do estado
		if(estado == null || estado.trim().length() == 0 ){
			msg+=" Por favor selecione o estado do aluno.";
		}else{
			if (estado.length() != 2){
				msg+=" Por favor selecione um estado v�lido.";
			}
		}
		
		String cep = req.getParameter("cep");
		//Valida��o do cep
		if(cep == null || cep.trim().length() == 0 ){
			msg+=" Por favor digite o cep do aluno.";
		}else{
			try {
				Integer cep_ = Integer.parseInt(cep);
				if (cep.length() <0 || cep.length() > 15){
					msg += " Cep precisa ter at� 15 caracteres.";
				}
			} catch (Exception e) {
				msg += " Cep precisa ter somente d�gitos.";
			}
		}
		boolean cnpjinvalido = false;
		
		if(eagente.equals("sim") && (cnpj_empresa_ligada == null || cnpj_empresa_ligada.trim().length() == 0)){
			msg+=" Cnpj n�o pode estar vazio. ";
			cnpjinvalido = true; 
		}
		if((nome_empresa == null || nome_empresa.trim().length() == 0)){
			msg+=" Raz�o social n�o pode estar vazio. ";
			cnpjinvalido = true; 
		}else{
			if((nome_empresa.trim().length() > 0 && nome_empresa.trim().length() > 100)){
				msg+=" Raz�o social n�o pode utrapassar 100 caracteres. ";
				cnpjinvalido = true; 
			}
		}
		
		if(eagente.equals("sim") && cnpj_empresa_ligada.trim().length() > 0 && cnpj_empresa_ligada.trim().length() < 14){
			msg+=" Cnpj precisa ter 14 caracteres. ";
			cnpjinvalido = true;
		}
		
		if(!(eagente.equals("sim")) && cnpj_empresa_ligada.trim().length() > 0 && cnpj_empresa_ligada.trim().length() < 14){
			msg+=" Cnpj precisa ter 14 caracteres. ";
			cnpjinvalido = true;
		}
		
		if(eagente.equals("sim") && cnpj_empresa_ligada.trim().length() > 0 && cnpj_empresa_ligada.trim().length() > 14){
			msg+=" Cnpj precisa ter 14 caracteres. ";
			cnpjinvalido = true;
		}
		
		if(!(eagente.equals("sim")) && cnpj_empresa_ligada.trim().length() > 0 && cnpj_empresa_ligada.trim().length() > 14){
			msg+=" Cnpj precisa ter 14 caracteres. ";
			cnpjinvalido = true;
		}
		
		if(!(eagente.equals("sim")) && (cnpj_empresa == null || cnpj_empresa.trim().length() == 0)){
			msg+=" Cnpj n�o pode estar vazio. ";
			cnpjinvalido = true;
		}
		
		//Valida��o do conv�nio
		if(numConvenio == null || numConvenio.trim().length() == 0){
			msg += " N�mero do conv�nio n�o pode ser vazio."; 
		}else{
			try {
				Double nConvenio = Double.parseDouble(numConvenio);
				if(numConvenio.trim().length() < 10 || numConvenio.trim().length() > 10){
					msg += " N�mero do conv�nio precisa ter 10 digitos.";
				}else{
					resultconvenio = ConvenioServices.buscarConvenio(numConvenio);
					if(!(resultconvenio.isEmpty())){
						convenio = resultconvenio.get(0);
					}
					if(eagente.equals("sim")){
						if(cnpjinvalido == false){
							List<Empresa> resultempresa = EmpresaServices.buscarEmpresaLigadaAI(cnpj_empresa_ligada, nome_agente);
							if(!(resultempresa.isEmpty())){
								empresa = resultempresa.get(0);
							} else {
								msg += " Agente de integra��o n�o est� ligado � esta empresa.";
							}
						}
					} else {
						if(cnpj_empresa == null || cnpj_empresa.trim().length() == 0){
							msg+=" Cnpj n�o pode estar vazio.";
						}else{
							if(cnpjinvalido == false){
								List<Empresa> resultempresa = EmpresaServices.buscarEmpresa(cnpj_empresa);
								if(!(resultempresa.isEmpty())){
									empresa = resultempresa.get(0);
								} else {
									msg += " Empresa n�o encontrada.";
								}
							}
						}
					}
					if(resultconvenio.isEmpty() && msg.equals("")){
						convincluido.setNumeroConvenio(numConvenio);
						convincluido.setEmpresa(empresa);
						ConvenioServices.registrarConvenio(convincluido);
					} else {
						if(convenio.getEmpresa().getIdEmpresa() == null || convenio.getEmpresa().getIdEmpresa() != empresa.getIdEmpresa()){
							msg+=" Convenio n�o est� ligado com empresa selecionada.";
						}
					}
						
				}
			} catch (Exception e) {
				msg += " N�mero do conv�nio s� pode ter n�meros.";
			}
		}
		
		
		if(!msg.equals("")){
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
		}else{
			TermoEstagio termoNovo = new TermoEstagio();
			termoNovo.setDatainiciote(dataSql);
			termoNovo.setDatafimte(dataSql2);
			termoNovo.setAluno(aluno);
			termoNovo.setBairroenderecote(bairro);
			termoNovo.setCargahorariate(Integer.parseInt(horas_dia));
			termoNovo.setCependerecote(cep);
			termoNovo.setCidadeenderecote(cidade);
			termoNovo.setComplementoenderecote(complemento);
			termoNovo.setEnderecote(endereco);
			termoNovo.setNumeroenderecote("22");
			termoNovo.setValorbolsa(Float.parseFloat(valor_bolsa));
			termoNovo.setEstadoenderecote(estado);
			termoNovo.setEestagioobrigatorio(1);
			if(isn_obrigatorio.equals("s")){
				termoNovo.setEestagioobrigatorio(1);
			}else{
				termoNovo.setEestagioobrigatorio(0);
			}
			if(!professor_orientador.equals("")){
				professor = ProfessorOrientadorServices.buscarProfessorOrientador(Long.parseLong(professor_orientador));
				termoNovo.setProfessorOrientador(professor);
			}
			if(resultconvenio.isEmpty()){
				termoNovo.setConvenio(convincluido);	
			}else{
				termoNovo.setConvenio(convenio);
			}
			TermoEstagioServices.IncluirTermoEstagio(termoNovo);
			req.setAttribute("sucesso", "Termo cadastrado com sucesso");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}

	}

}
