package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.dao.TermoAditivoDAO;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.TermoAditivo;

public class TermoAditivoServices {
	public static List listarTermosAditivos(String matricula){
		return TermoAditivoDAO.listarTermosAditivos(matricula);
	}
	public static List listarTermoEstagio(String matricula){
		return TermoAditivoDAO.listarTermoEstagio(matricula);
	}
	public static TermoAditivo BuscarTermoAditivo(Long id){
		GenericDAO<TermoAditivo> termoAditivoDAO = PersistenceManager.createGenericDAO(TermoAditivo.class);
		return termoAditivoDAO.buscar(id);
	}
}
