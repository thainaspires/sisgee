package br.cefetrj.sisgee.view.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AgenteIntegracaoServices;
import br.cefetrj.sisgee.control.EmpresaServices;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Curso;
import br.cefetrj.sisgee.model.entity.Empresa;

/**
 * Servlet implementation class CadastrarEmpresaCommmand
 * @author Alexander Hugo
 */
public class CadastrarEmpresaCommand implements Command {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String agente = req.getParameter("agente");
		String cnpj = req.getParameter("cnpj");
		String razaosocial = req.getParameter("razaosocial");
		String msg = "";
		boolean sucesso = false;
		
		if(!(cnpj != null && cnpj.trim().length() > 0)){
			msg += "CNPJ n�o pode ser vazio ";
		}
		if(cnpj.trim().length() > 14){
			msg += "CNPJ n�o pode ser maior que 14 caracteres.";
		}
		if(cnpj.trim().length() > 0 && cnpj.trim().length() < 14){
			msg += "CNPJ n�o pode ser menor que 14 caracteres.";
		}
		if(!(razaosocial != null && razaosocial.trim().length() > 0)){
			msg += "Raz�o Social n�o pode ser vazio.";
		}
		if(!(razaosocial.trim().length() <= 100)){
			msg += "Raz�o Social deve ter at� 100 caracteres.";
		}
		if(agente.equals("")){
			//Agente deve ser sim ou n�o
			msg += "A Op��o de Agente de Integra��o precisa ser sim ou n�o.";
		}
		
		if(agente.equals("s")){
			// utilizar AgenteIntegracaoServices
			if(msg.equals("")){
				AgenteIntegracao agenteintegracao = new AgenteIntegracao();
				agenteintegracao.setCnpjAgenteIntegracao(cnpj);
				agenteintegracao.setNomeAgenteIntegracao(razaosocial);
				AgenteIntegracaoServices.registrarAgenteIntegracao(agenteintegracao);
			}
		}else if(agente.equals("n")){
			// utilizar EmpresaServices
			if(msg.equals("")){		
				Empresa empresa = new Empresa();
				empresa.setCnpjEmpresa(cnpj);
				empresa.setNomeEmpresa(razaosocial);
				EmpresaServices.registrarEmpresa(empresa);
			}
		}
		if(msg != ""){
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/cadastrar_empresa.jsp").forward(req,resp);
		} else {
			sucesso = true;
			msg += "Cadastro de empresa realizado com sucesso";
			req.setAttribute("msg", msg);
			req.setAttribute("sucesso", sucesso);
			req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
		}
	}

}
