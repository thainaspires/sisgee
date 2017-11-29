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
		String matricula = req.getParameter("matricula");
		String ondeEstaVindo = req.getParameter("ondeEstaVindo");
		String msg = "";
		if (ondeEstaVindo != null && ondeEstaVindo.equals("rescisao") ){
			if (matricula != null && matricula.trim().length() > 0){
				List<Aluno> aluno = null;
				aluno = AlunoServices.buscarDetermAluno(matricula);
				if(aluno.size() > 0){
					Aluno alunoBuscado = aluno.get(0);
					msg += "Matrícula retornada com sucesso";
					req.setAttribute("aluno", alunoBuscado);
				} else {
					msg += "Matrícula não encontrada";
				}	
			}else{
				msg += "É necessário digitar uma matrícula antes de buscar";
			}
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/termorescisao.jsp").forward(req, resp);
			
		}else{		
			if (matricula != null && matricula.trim().length() > 0){
				List<Aluno> alunos = null;
				alunos = AlunoServices.buscarDetermAluno(matricula);
				if(alunos.size() > 0){
					Aluno aluno = alunos.get(0);
					String idAluno = aluno.getIdAluno().toString();
					msg += "Matrícula retornada com sucesso";
					req.setAttribute("idAluno", idAluno);
					req.setAttribute("aluno", aluno);
				} else {
					msg += "Matrícula não encontrada";
				}	
			} else if(!(matricula.trim().length() <= 100)){ 
				msg += "O tamanho da matrícula excede o limite permitido";
			} else{
				msg += "É necessário digitar uma matrícula antes de buscar";
			}
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
		}
	}
	
}
