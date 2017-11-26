package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AgenteIntegracaoServices;
import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.control.ProfessorOrientadorServices;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.ProfessorOrientador;

public class BuscarAlunoCommand implements Command{
		
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*List<ProfessorOrientador> professoresOrientadores = ProfessorOrientadorServices.listarProfessoresOrientadores();
		req.setAttribute("professoresOrientadores", professoresOrientadores);
		
		List<AgenteIntegracao> agentesIntegracao = AgenteIntegracaoServices.listarAgentesIntegracao();
		req.setAttribute("agentesIntegracao", agentesIntegracao);*/
		
		String matricula = req.getParameter("matricula");
		/*String numero_convenio = req.getParameter("numero_convenio");
		String cnpj_empresa_ligada = req.getParameter("cnpj_empresa_ligada");
		String cnpj_empresa = req.getParameter("cnpj_empresa");
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
		*/
		
		String msg = null;
		if (matricula != null && matricula.trim().length() > 0){
			List<Aluno> alunos = null;
			alunos = AlunoServices.buscarDetermAluno(matricula);
			if(alunos.size() > 0){
				Aluno aluno = alunos.get(0);
				msg += "Matrícula retornada com sucesso";
				req.setAttribute("aluno", aluno);
				System.out.println("TIPO: "+ aluno.getCurso().getCampus());
				req.setAttribute("teste",aluno.getCurso().getCampus());
			} else {
				msg += "Matrícula não encontrada";
			}	
		}else{
			msg += "É necessário digitar uma matrícula antes de buscar";
		}
		/*
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
		System.out.println(razao_social_empresa);
		req.setAttribute("razao_social_empresa", razao_social_empresa);*/
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	}
	
}
