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
 * Classe para valida��o da rescis�o e inclus�o no banco
 * @author Thain� Pires
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
		
		
		//Transformando data para formato necess�rio
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data_Rescisao = formato.parse(datarescisao);
		} catch (ParseException e) {
			/** TODO: **/
		}
		
		//Buscando o aluno atrav�s da matricula
		
		if (matricula != null && matricula.trim().length() > 0){
			List<Aluno> aluno = null;
			aluno = AlunoServices.buscarDetermAluno(matricula);
			if(aluno.size() > 0){
				alunoBuscado = aluno.get(0);
			} else {
				msg2 += "Matr�cula n�o encontrada";
			}	
		}else{
			msg2 += "� necess�rio digitar uma matr�cula antes de buscar";
		}
		
		//Se o aluno Buscado n�o for null ent�o � possivel pegar o termo de est�gio que tem data de rescis�o nula
		if(alunoBuscado != null){
			termoEstagio = TermoEstagioServices.buscarTermoPorIdAluno(alunoBuscado.getIdAluno());
			System.out.println("Termo: "+termoEstagio);
		}
		
		//Se o termo de est�gio � null, � porque n�o existe termo de est�gio com rescis�o nula para o determinado aluno
		if(termoEstagio == null){
			msg2+="N�o foi poss�vel achar termo de estagio para este aluno que n�o tenha data de rescis�o";
		//Se n�o for null, � porque existe termo est�gio com rescis�o nula
		}else{
			//Se a data que a pessoa selecionou n�o for nula e se o formato for correto
			if(datarescisao != null && datarescisao.length() != 0 && datarescisao.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
				//Se a data for antes da data de inicio do termo ou se for depois da data final do termo, � inv�lida
				if(data_Rescisao.before(termoEstagio.getDatainiciote()) || data_Rescisao.after(termoEstagio.getDatafimte())){
					msg2+="Data de rescis�o precisa estar entre os intervalos de data inicio e final";
				//Se a data estiver dentro das datasa de inicio e fim, ent�o � uma data v�lida e o termoEstagio � alterado
				}else{
					TermoEstagioServices.AlterarTermoEstagio(termoEstagio, data_Rescisao);
					sucesso = "Rescis�o registrada com sucesso";
				}
			//Se a pessoa n�o selecionou a data ou se a data n�o estiver no formato correto
			}else{
				msg2+="Data de rescis�o n�o pode ser vazia e precisa ter o formato correto";
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
