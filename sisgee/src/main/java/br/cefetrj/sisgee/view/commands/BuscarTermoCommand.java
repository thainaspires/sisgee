package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.control.TermoAditivoServices;
import br.cefetrj.sisgee.control.TermoEstagioServices;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.TermoAditivo;
import br.cefetrj.sisgee.model.entity.TermoEstagio;

/**
 * @author Nathalia Gomes
 * Command para validação da busca de Termo e os dados
 *  
 */

public class BuscarTermoCommand implements Command{
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Aluno> aluno = null;
		Aluno alunoBuscado;
		TermoEstagio termoEstagio = null;
		TermoAditivo termoAditivo = null;
		String matricula = "";
		String eEstagio = req.getParameter("eEstagio");
		String idTermo = req.getParameter("idTermo");
		
		/**
		 * Atributos do termo aditivo
		 */
		String numConvenio = "";
		String dataInicio ="";
		String dataTermino = "";
		String horas_dia = "";
		String valor_bolsa ="";
		String endereco ="";
		String complemento="";
		String bairro="";
		String cidade="";
		String estado="";
		String cep="";
		
		
		Long id = null;
		try{
			id = Long.parseLong(idTermo);
			if(eEstagio.equals("n")){
				termoAditivo = TermoAditivoServices.BuscarTermoAditivo(id);
				matricula = termoAditivo.getTermoEstagio().getAluno().getMatricula();
				aluno = AlunoServices.buscarDetermAluno(matricula);
				if(aluno.size() > 0){
					alunoBuscado = aluno.get(0);
					req.setAttribute("aluno", alunoBuscado);
				} 
				numConvenio = termoAditivo.getTermoEstagio().getConvenio().getNumeroConvenio();
				dataInicio = termoAditivo.getTermoEstagio().getDatainiciote().toString();
				dataTermino = termoAditivo.getDataFimta().toString();
				horas_dia = termoAditivo.getCargaHorariata().toString();
				valor_bolsa = termoAditivo.getValorBolsata().toString();
				endereco = termoAditivo.getEnderecota();
				complemento = termoAditivo.getComplementoEnderecota();
				bairro = termoAditivo.getBairroEnderecota();
				cidade = termoAditivo.getCidadeEnderecota();
				estado = termoAditivo.getEstadoEnderecota();
				cep = termoAditivo.getCepEnderecota();
				req.setAttribute("numero_convenio", numConvenio);
				
			}else{
				termoEstagio = TermoEstagioServices.BuscarTermoEstagio(id);
			}
		}catch(Exception e){
			System.out.println("id do termo estï¿½ errado");
		}
		
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
		
		//System.out.println(eEstagio);
		//System.out.println(idTermo);
	}
}
