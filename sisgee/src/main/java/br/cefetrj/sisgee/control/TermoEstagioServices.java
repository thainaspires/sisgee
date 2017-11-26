package br.cefetrj.sisgee.control;

import java.util.Date;

import br.cefetrj.sisgee.model.dao.TermoEstagioDAO;
import br.cefetrj.sisgee.model.entity.TermoEstagio;

/**
 * Trata serviços relacionados ao TermoEstagio
 * 
 * @author Alexander Hugo
 */
public class TermoEstagioServices {
	public static TermoEstagio buscarTermoPorIdAluno(Long id){
		return TermoEstagioDAO.buscarTermoPorIdAluno(id);
	}
	public static void AlterarTermoEstagio(TermoEstagio termo, Date data_Rescisao){
		TermoEstagioDAO.AlterarTermoEstagio(termo, data_Rescisao);
	}
}
