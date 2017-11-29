package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.control.TermoEstagioServices;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.TermoEstagio;
/**
 * Classe para validação da rescisão e inclusão no banco
 * @author Thainá Pires
 *
 */
public class ValidarRegistroRescisaoCommand implements Command {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricula = req.getParameter("matricula");
		String datarescisao = req.getParameter("datarescisao");
		TermoEstagio termoEstagio = null;
		Date data_Rescisao = null;
		Aluno alunoBuscado = null;
		String sucesso ="";
		String msg2 = "";
		
		
		//Transformando data para formato necessário
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data_Rescisao = formato.parse(datarescisao);
		} catch (ParseException e) {
			/** TODO: **/
		}
		
		//Buscando o aluno através da matricula
		
		if (matricula != null && matricula.trim().length() > 0){
			List<Aluno> aluno = null;
			aluno = AlunoServices.buscarDetermAluno(matricula);
			if(aluno.size() > 0){
				alunoBuscado = aluno.get(0);
			} else {
				msg2 += "Matrícula não encontrada";
			}	
		}else{
			msg2 += "É necessário digitar uma matrícula antes de buscar";
		}
		
		//Se o aluno Buscado não for null então é possivel pegar o termo de estágio que tem data de rescisão nula
		if(alunoBuscado != null){
			termoEstagio = TermoEstagioServices.buscarTermoPorIdAluno(alunoBuscado.getIdAluno());
		}
		
		//Se o termo de estágio é null, é porque não existe termo de estágio com rescisão nula para o determinado aluno
		if(termoEstagio == null){
			msg2+="Não foi possível achar termo de estagio para este aluno que não tenha data de rescisão";
		//Se não for null, é porque existe termo estágio com rescisão nula
		}else{
			//Se a data que a pessoa selecionou não for nula e se o formato for correto
			if(datarescisao != null && datarescisao.length() != 0 && datarescisao.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
				//Se a data for antes da data de inicio do termo ou se for depois da data final do termo, é inválida
				if(data_Rescisao.before(termoEstagio.getDatainiciote()) || data_Rescisao.after(termoEstagio.getDatafimte())){
					msg2+="Data de rescisão precisa estar entre os intervalos de data inicio e final";
				//Se a data estiver dentro das datasa de inicio e fim, então é uma data válida e o termoEstagio é alterado
				}else{
					TermoEstagioServices.AlterarTermoEstagio(termoEstagio, data_Rescisao);
					sucesso = "Rescisão registrada com sucesso";
				}
			//Se a pessoa não selecionou a data ou se a data não estiver no formato correto
			}else{
				msg2+="Data de rescisão não pode ser vazia e precisa ter o formato correto";
			}
		}
		
		if(msg2 != ""){
			req.setAttribute("msg2", msg2);
			req.getRequestDispatcher("/termorescisao.jsp").forward(req,resp);
		} else {
			req.setAttribute("sucesso", sucesso);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}
