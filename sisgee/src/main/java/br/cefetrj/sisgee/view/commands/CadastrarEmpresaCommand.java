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
			msg += "CNPJ é um campo obrigatório.";
		}
		if(!(razaosocial != null && razaosocial.trim().length() > 0)){
			msg += "Razão Social é um campo obrigatório.";
		}
		if(agente.equals("")){
			//Agente deve ser sim ou não
			msg += "A Opção de Agente de Integração precisa ser sim ou não.";
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
			msg += "Cadastro realizado com sucesso";
			req.setAttribute("msg", msg);
			req.setAttribute("sucesso", sucesso);
			req.getRequestDispatcher("/FrontControllerServlet?action=ConsultasTermoEst").forward(req, resp);
		}
	}

}
