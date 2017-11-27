package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.control.TermoEstagioServices;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Convenio;
import br.cefetrj.sisgee.model.entity.TermoEstagio;

public class ValidarTermoEstagioCommand implements Command {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Aluno aluno = null;
		
		String numConvenio = req.getParameter("numero_convenio");
		String matricula = req.getParameter("matricula");
		String msg = "";
		
		if (matricula != null && matricula.trim().length() > 0){
			List<Aluno> alunoList = null;
			alunoList = AlunoServices.buscarDetermAluno(matricula);
			if(!(alunoList.isEmpty())){
				aluno = alunoList.get(0);
			} else {
				msg += "Matrícula não encontrada";
			}	
		}else{
			msg += "É necessário digitar uma matrícula.";
		}
		
		//Validação do convênio
		if(numConvenio == null || numConvenio.trim().length() == 0){
			msg += "Número do convênio não pode ser vazio"; 
		}else{
			try {
				Long nConvenio = Long.parseLong(numConvenio);
				if(numConvenio.trim().length() < 10 || numConvenio.trim().length() > 10){
					msg += "Número do convênio precisa ter 10 digitos";
				}else{
					//convenio = ConvenioServices.BuscarConvenio(numConvenio);
					System.out.println("convenio valido");
				}
			} catch (Exception e) {
				msg += "Número do convênio só pode ter números";
			}
		}
		
		String dataInicio = req.getParameter("data_inicio");
		String dataTermino = req.getParameter("data_termino");
		java.sql.Date dataSql = null;
	    java.sql.Date dataSql2 = null;
		
		//validação das datas de vigencia
		if(dataInicio != null && dataInicio.length() != 0 && dataTermino != null && dataTermino.length() != 0 && 
		dataInicio.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d") && dataTermino.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
			/**TODO: validação de datas no sentido de ser uma data no formato certo mas não ser válida **/
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
		        msg+="Data inicial deve ser antes da data final";
		    }
			
		}else{
			msg+="Datas precisam ser preenchidas e precisam estar no formato correto";
		}
		
		String horas_dia = req.getParameter("horas_dia");
		
		//validação das horas
		if(horas_dia == null || horas_dia.trim().length() == 0){
			msg+="Por favor digite a carga horária do aluno";
		}else{
			try {
				Integer horas_dia_ = Integer.parseInt(horas_dia);
				if(horas_dia_ < 0 || horas_dia_ > 6){
					msg += "Carga horária do aluno precisa ser maior que 0 e menor que 6";
				}
			} catch (Exception e) {
				msg += "Carga horária precisa ser digito";
			}
		}
		
		String valor_bolsa = req.getParameter("valor_bolsa");
		
		//Validação do valor da bolsa
		if(valor_bolsa == null || valor_bolsa.trim().length() == 0){
			msg+="Por favor digite o valor da bolsa do aluno";
		}else{
			try {
				Float valor_bolsa_ = Float.parseFloat(valor_bolsa);
				System.out.println("ola: "+valor_bolsa);
				if(valor_bolsa_ < 0){
					msg += "Valor da bolsa do aluno precisa ser maior que 0";
				}
			} catch (Exception e) {
				msg += "Valor da bolsa precisa ser dígito (com ponto se necessário para número quebrado)";
			}
		}
		
		String endereco = req.getParameter("endereco");
		
		//Validação do endereço
		if(endereco == null || endereco.trim().length() == 0){
			msg+="Por favor digite o endereço do aluno";
		}else{
			if (endereco.length() > 255){
				msg+="Endereço só pode ter até 255 caracteres";
			}
		}
		
		String complemento = req.getParameter("complemento");
		//Validação do complemento
		if(complemento == null || complemento.trim().length() == 0){
			msg+="Por favor digite o complemento do aluno";
		}else{
			if (complemento.length() > 150){
				msg+="Complemento só pode ter até 150 caracteres";
			}
		}
		
		String bairro = req.getParameter("bairro");
		//Validação do bairro
		if(bairro == null || bairro.trim().length() == 0){
			msg+="Por favor digite o bairro do aluno";
		}else{
			if (bairro.length() > 150){
				msg+="Bairro só pode ter até 150 caracteres";
			}
		}
		
		String cidade = req.getParameter("cidade");
		//Validação do cidade
		if(cidade == null || cidade.trim().length() == 0){
			msg+="Por favor digite o cidade do aluno";
		}else{
			if (cidade.length() > 150){
				msg+="Cidade só pode ter até 150 caracteres";
			}
		} 
		
		String estado = req.getParameter("estado");
		//Validação do estado
		if(estado == null || estado.trim().length() == 0 ){
			msg+="Por favor selecione o estado do aluno";
		}else{
			if (estado.length() != 2){
				msg+="Por favor selecione um estado válido";
			}
		}
		
		String cep = req.getParameter("cep");
		//Validação do cep
		if(cep == null || cep.trim().length() == 0 ){
			msg+="Por favor digite o cep do aluno";
		}else{
			try {
				Integer cep_ = Integer.parseInt(cep);
				if (cep.length() <0 || cep.length() > 15){
					msg += "Cep precisa ter até 15 caracteres";
				}
			} catch (Exception e) {
				msg += "Cep precisa ter somente dígitos";
			}
		}
	
		
		if(!msg.equals("")){
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
		}else{
			System.out.println("comeco do convenio");
			TermoEstagio termoNovo = new TermoEstagio();
			termoNovo.setDatainiciote(dataSql);
			termoNovo.setDatafimte(dataSql2);
			termoNovo.setAluno(aluno);
			termoNovo.setBairroenderecote(bairro);
			termoNovo.setCargahorariate(Integer.parseInt(horas_dia));
			termoNovo.setCependerecote(cep);
			termoNovo.setCidadeenderecote(cidade);
			termoNovo.setComplementoenderecote(complemento);
			//termoNovo.setConvenio(convenio);
			termoNovo.setEestagioobrigatorio(1);
			termoNovo.setEnderecote(endereco);
			termoNovo.setNumeroenderecote("22");
			termoNovo.setValorbolsa(Float.parseFloat(valor_bolsa));
			termoNovo.setEstadoenderecote(estado);
			Convenio convenio = new Convenio();
			convenio.setNumeroConvenio("1234555533");
			
			/**
			 * Primeiro é preciso criar ou pegar o convênio existente.
			 * Parte do Alexander
			 */
			EntityManagerFactory factory =
					Persistence.createEntityManagerFactory("SisgeePU");
			EntityManager manager = factory.createEntityManager();
		
			manager.getTransaction().begin();
			
			manager.persist(convenio);
			
			manager.getTransaction().commit();
			manager.close();
			factory.close();
			System.out.println("termin!");
			/**
			 * Parte do Alexander
			 */
			
			termoNovo.setConvenio(convenio);
			TermoEstagioServices.IncluirTermoEstagio(termoNovo);
			req.setAttribute("sucesso", "Termo cadastrado com sucesso");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
	}

}
