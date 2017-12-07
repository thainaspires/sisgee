package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.control.TermoAditivoServices;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.TermoAditivo;
/**
 * @author Thainá
 * Command para Listar os termos aditivos e realizar sua validação
 * 
 */
public class ListarTermosAditivosCommand implements Command{
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricula = req.getParameter("matricula");
		List<Object []> termosAditivos = null;
		List<Object []> termoEstagio = null;
		List<Object []> termo = null;
		List<Aluno> aluno = null;
		String msg = "";
		String msg2 = "";
		Boolean eEstagio = true;
		if (matricula != null && matricula.trim().length() > 0){
			aluno = AlunoServices.buscarDetermAluno(matricula);
			if(aluno.size() > 0){
				
				Aluno alunoBuscado = aluno.get(0);
				msg += "Matrícula retornada com sucesso. ";
				req.setAttribute("aluno", alunoBuscado);

				termoEstagio = TermoAditivoServices.listarTermoEstagio(matricula);
				if (termoEstagio == null){
					msg2+="Não foi possível encontrar termo estágios aditivos para o aluno atualmente. ";
				}else{
					termosAditivos = TermoAditivoServices.listarTermosAditivos(matricula);
					if(termosAditivos == null){
						termo = termoEstagio;
						msg+="Termos retornados com sucesso.";
						System.out.println(termo);
					}else{
						msg+="Termos retornados com sucesso.";
						termo = termosAditivos;
						eEstagio = false;
						System.out.println(termo);
					}
				}
				
				if(eEstagio == false){
					req.setAttribute("eEstagio", "n");
				}else{
					req.setAttribute("eEstagio", "s");
				}
				
				req.setAttribute("listaTermos", termo);	
				
			} else {
				msg += "Matrícula não encontrada";
				msg2+= "Pesquisa invï¿½lida";
			}	
		}else{
			msg += "É necessário digitar uma matrícula antes de buscar";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("msg2", msg2);
		req.setAttribute("matricula", matricula);
		req.getRequestDispatcher("/termoaditivo.jsp").forward(req, resp);
	}
}
