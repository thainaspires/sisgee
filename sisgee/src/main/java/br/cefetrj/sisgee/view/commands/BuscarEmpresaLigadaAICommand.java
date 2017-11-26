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

public class BuscarEmpresaLigadaAICommand implements Command {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cnpj_empresa_ligada = req.getParameter("cnpj_empresa_ligada");
		/*String matricula = req.getParameter("matricula");
		String numero_convenio = req.getParameter("numero_convenio");
		String cnpj_empresa = req.getParameter("cnpj_empresa");
		String data_inicio = req.getParameter("data_inicio");
		String data_termino = req.getParameter("data_termino");
		String horas_dia = req.getParameter("horas_dia");
		String valor_bolsa = req.getParameter("valor_bolsa");
		String endereco = req.getParameter("endereco");
		String complemento = req.getParameter("complemento");
		String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String cep = req.getParameter("cep");*/
		//String nome_agente = req.getParameter("nome_agente");
		if (cnpj_empresa_ligada != null && cnpj_empresa_ligada.trim().length() > 0){
			List<Empresa> empresa = null;
			empresa = EmpresaServices.buscarEmpresaLigadaAI(cnpj_empresa_ligada, "CIEE");
			Empresa empresaLigadaAIBuscada = empresa.get(0);
			req.setAttribute("empresaligada", empresaLigadaAIBuscada);
		}/*
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
		req.setAttribute("cep", cep);*/
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	}
}
