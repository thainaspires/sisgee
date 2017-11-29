package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.Iterator;
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

/**
 * Servlet implementation class IncluirAlunoServlet
 */
public class ConsultasTermoEstagioCommand implements Command {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProfessorOrientador> professoresOrientadores = ProfessorOrientadorServices.listarProfessoresOrientadores();
		req.setAttribute("professoresOrientadores", professoresOrientadores);
		
		List<AgenteIntegracao> agentesIntegracao = AgenteIntegracaoServices.listarAgentesIntegracao();
		req.setAttribute("agentesIntegracao", agentesIntegracao);
		
		String msg = "";
		String matricula = req.getParameter("matricula");
		
		if (matricula != null && matricula.trim().length() > 0){
			List<Aluno> aluno = null;
			aluno = AlunoServices.buscarDetermAluno(matricula);
			if(aluno.size() > 0){
				Aluno alunoBuscado = aluno.get(0);
				msg += "Matrícula retornada com sucesso";
				req.setAttribute("alunoBuscado", alunoBuscado);
			} else {
				msg += "Matrícula não encontrada";
			}	
		}else{
			msg += "É necessário digitar uma matrícula antes de buscar";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	
	}
	

}
