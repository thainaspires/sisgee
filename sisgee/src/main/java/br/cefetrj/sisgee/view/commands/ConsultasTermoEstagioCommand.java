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
		
		String msg = "";
		/*Vari�vel para indicar se a mensagem � um erro ou n�o.
		 *Utilizada para mostrar um alert verde (sucesso) ou vermelho (erro). 
		 * */
		boolean sucesso = false;
		String matricula = req.getParameter("matricula");
		
		if (matricula != null && matricula.trim().length() > 0){
			aluno = AlunoServices.buscarDetermAluno(matricula);
			System.out.println(aluno);
			/*TODO Ap�s constatar sucesso do m�todo, lembrar de tirar teste*/
			/*Avalia se a lista retornada est� vazia*/
			if(aluno.size() > 0){
				Aluno alunoBuscado = aluno.get(0);
				System.out.println(alunoBuscado.getCurso().getNomeCurso());
				//req.setAttribute("alunoBuscado", alunoBuscado);	
				req.setAttribute("matricula", matricula);
				String nomedoAluno = alunoBuscado.getPessoa().getNome();
				String cursoAluno = alunoBuscado.getCurso().getNomeCurso();
				req.setAttribute("nomeAluno", nomedoAluno);	
				req.setAttribute("cursoAluno", cursoAluno);	
				
			} else {
				msg += "Matr�cula n�o encontrada";
			}	
		}else{
			msg += "� necess�rio digitar uma matr�cula antes de buscar";
		}
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	
	}
	

}
