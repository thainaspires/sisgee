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

	List<Aluno> aluno = null;
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProfessorOrientador> professoresOrientadores = ProfessorOrientadorServices.listarProfessoresOrientadores();
		req.setAttribute("professoresOrientadores", professoresOrientadores);
		
		List<AgenteIntegracao> agentesIntegracao = AgenteIntegracaoServices.listarAgentesIntegracao();
		req.setAttribute("agentesIntegracao", agentesIntegracao);
		
		String matricula = req.getParameter("matricula");
		
		if (matricula != null && matricula.trim().length() > 0){
			aluno = AlunoServices.buscarDetermAluno(matricula);
			System.out.println(aluno);
			Aluno alunoBuscado = aluno.get(0);
			System.out.println(alunoBuscado.getMatricula());
			req.setAttribute("alunoBuscado", alunoBuscado);	
			
		}else{
			System.out.println("erro");
		}
		
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	
	}
	

}
