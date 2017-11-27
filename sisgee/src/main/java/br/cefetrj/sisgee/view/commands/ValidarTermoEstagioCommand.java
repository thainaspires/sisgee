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
import br.cefetrj.sisgee.control.GerarRelatorioServices;
import br.cefetrj.sisgee.model.entity.Convenio;

public class ValidarTermoEstagioCommand implements Command {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Convenio convenio = new Convenio();
		String numConvenio = req.getParameter("numero_convenio");
		String idAluno = req.getParameter("idAluno");
		System.out.println("idaluno: "+idAluno);
		String msg = "";
		String nome_aluno = req.getParameter("nome_aluno");
		System.out.println("nome: "+ nome_aluno);
		
		
		if(idAluno == null || idAluno.trim().length() == 0){
			msg+="Aluno precisa ser pesquisado";
		}else{
			try {
				Long nIdAluno = Long.parseLong(idAluno);
			} catch (Exception e) {
				msg += "Id do aluno inv�lido";
			}
		}
		
		//Valida��o do conv�nio
		if(numConvenio == null || numConvenio.trim().length() == 0){
			msg += "N�mero do conv�nio n�o pode ser vazio"; 
		}else{
			try {
				Long nConvenio = Long.parseLong(numConvenio);
				if(numConvenio.trim().length() < 10 || numConvenio.trim().length() > 10){
					msg += "N�mero do conv�nio precisa ter 10 digitos";
				}else{
					//convenio = ConvenioServices.BuscarConvenio(numConvenio);
					System.out.println("convenio valido");
				}
			} catch (Exception e) {
				msg += "N�mero do conv�nio s� pode ter n�meros";
			}
		}
		
		String dataInicio = req.getParameter("data_inicio");
		String dataTermino = req.getParameter("data_termino");
		
		//valida��o das datas de vigencia
		if(dataInicio != null && dataInicio.length() != 0 && dataTermino != null && dataTermino.length() != 0 && 
		dataInicio.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d") && dataTermino.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
			/**TODO: valida��o de datas no sentido de ser uma data no formato certo mas n�o ser v�lida **/
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
	        java.sql.Date dataSql = null;
	        java.sql.Date dataSql2 = null;
	        
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
		
		//valida��o das horas
		if(horas_dia == null || horas_dia.trim().length() == 0){
			msg+="Por favor digite a carga hor�ria do aluno";
		}else{
			try {
				Integer horas_dia_ = Integer.parseInt(horas_dia);
				if(horas_dia_ < 0 || horas_dia_ > 6){
					msg += "Carga hor�ria do aluno precisa ser maior que 0 e menor que 6";
				}
			} catch (Exception e) {
				msg += "Carga hor�ria precisa ser digito";
			}
		}
		
		String valor_bolsa = req.getParameter("valor_bolsa");
		
		//Valida��o do valor da bolsa
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
				msg += "Valor da bolsa precisa ser d�gito (com ponto se necess�rio para n�mero quebrado)";
			}
		}
		
		String endereco = req.getParameter("endereco");
		
		//Valida��o do endere�o
		if(endereco == null || endereco.trim().length() == 0){
			msg+="Por favor digite o endere�o do aluno";
		}else{
			if (endereco.length() > 255){
				msg+="Endere�o s� pode ter at� 255 caracteres";
			}
		}
		
		String complemento = req.getParameter("complemento");
		//Valida��o do complemento
		if(complemento == null || complemento.trim().length() == 0){
			msg+="Por favor digite o complemento do aluno";
		}else{
			if (complemento.length() > 150){
				msg+="Complemento s� pode ter at� 150 caracteres";
			}
		}
		
		String bairro = req.getParameter("bairro");
		//Valida��o do bairro
		if(bairro == null || bairro.trim().length() == 0){
			msg+="Por favor digite o bairro do aluno";
		}else{
			if (bairro.length() > 150){
				msg+="Bairro s� pode ter at� 150 caracteres";
			}
		}
		
		String cidade = req.getParameter("cidade");
		//Valida��o do cidade
		if(cidade == null || cidade.trim().length() == 0){
			msg+="Por favor digite o cidade do aluno";
		}else{
			if (cidade.length() > 150){
				msg+="Cidade s� pode ter at� 150 caracteres";
			}
		} 
		
		String estado = req.getParameter("estado");
		//Valida��o do estado
		if(estado == null || estado.trim().length() == 0 ){
			msg+="Por favor selecione o estado do aluno";
		}else{
			if (estado.length() != 2){
				msg+="Por favor selecione um estado v�lido";
			}
		}
		
		String cep = req.getParameter("cep");
		//Valida��o do cep
		if(cep == null || cep.trim().length() == 0 ){
			msg+="Por favor digite o cep do aluno";
		}else{
			try {
				Integer cep_ = Integer.parseInt(cep);
				if (cep.length() <0 || cep.length() > 15){
					msg += "Cep precisa ter at� 15 caracteres";
				}
			} catch (Exception e) {
				msg += "Cep precisa ter somente d�gitos";
			}
		}
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	}

}
