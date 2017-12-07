package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.ProfessorOrientador;

/**
 * Trata servi�os relacionados ao professor orientador
 * @author Thain�
 */
public class ProfessorOrientadorServices {
	public static List<ProfessorOrientador> listarProfessoresOrientadores(){
		GenericDAO<ProfessorOrientador> professorOrientadorDAO = 
				PersistenceManager.createGenericDAO(ProfessorOrientador.class);
		return professorOrientadorDAO.buscarTodos();
	}
	public static ProfessorOrientador buscarProfessorOrientador(Long id){
		GenericDAO<ProfessorOrientador> professorOrientadorDAO = 
				PersistenceManager.createGenericDAO(ProfessorOrientador.class);
		return professorOrientadorDAO.buscar(id);
	}
}
