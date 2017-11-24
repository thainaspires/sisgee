package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AgenteIntegracaoServices;
import br.cefetrj.sisgee.control.EmpresaServices;
import br.cefetrj.sisgee.control.ProfessorOrientadorServices;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Empresa;
import br.cefetrj.sisgee.model.entity.ProfessorOrientador;

public class BuscarEmpresaCommand  implements Command {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProfessorOrientador> professoresOrientadores = ProfessorOrientadorServices.listarProfessoresOrientadores();
		req.setAttribute("professoresOrientadores", professoresOrientadores);
		
		List<AgenteIntegracao> agentesIntegracao = AgenteIntegracaoServices.listarAgentesIntegracao();
		req.setAttribute("agentesIntegracao", agentesIntegracao);
		
		String cnpj_empresa = req.getParameter("cnpj_empresa");
		String matricula = req.getParameter("matricula");
		String numero_convenio = req.getParameter("numero_convenio");
		String cnpj_empresa_ligada = req.getParameter("cnpj_empresa_ligada");
		String data_inicio = req.getParameter("data_inicio");
		String data_termino = req.getParameter("data_termino");
		String horas_dia = req.getParameter("horas_dia");
		String valor_bolsa = req.getParameter("valor_bolsa");
		String endereco = req.getParameter("endereco");
		String complemento = req.getParameter("complemento");
		String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String cep = req.getParameter("cep");
		String razao_social_empresa = req.getParameter("razao_social_empresa");
		System.out.println(razao_social_empresa);
		
		if (cnpj_empresa != null && cnpj_empresa.trim().length() > 0){
			List<Empresa> empresa = null;
			empresa = EmpresaServices.buscarEmpresa(cnpj_empresa);
			Empresa empresaBuscada = empresa.get(0);
			razao_social_empresa = (String) empresaBuscada.getNomeEmpresa();
			System.out.println(razao_social_empresa);
			req.setAttribute("razao_social_empresa", razao_social_empresa);
			System.out.println(req.getAttribute("razao_social_empresa"));
		}
		
	
		req.setAttribute("numero_convenio", numero_convenio);
		req.setAttribute("cnpj_empresa_ligada", cnpj_empresa_ligada);
		req.setAttribute("cnpj_empresa", cnpj_empresa);
		req.setAttribute("data_inicio", data_inicio);
		req.setAttribute("data_termino", data_termino);
		req.setAttribute("horas_dia", horas_dia);
		req.setAttribute("valor_bolsa", valor_bolsa);
		req.setAttribute("endereco", endereco);
		req.setAttribute("complemento", complemento);
		req.setAttribute("cidade", cidade);
		req.setAttribute("bairro", bairro);
		req.setAttribute("cep", cep);
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	}

}
