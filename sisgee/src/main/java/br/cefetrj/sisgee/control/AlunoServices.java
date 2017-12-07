package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.AlunoDAO;
import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.Aluno;

/**
 * Trata serviços relacionados ao aluno
 * @author Thainá
 */
public class AlunoServices {
	public static List<Aluno> listarAlunos(){
		GenericDAO<Aluno> alunoDao = PersistenceManager.createGenericDAO(Aluno.class);
		return alunoDao.buscarTodos();
	}
	
	public static List<Aluno> buscarDetermAluno(String matricula){
		
		return AlunoDAO.buscarPorMatricula(matricula);
	}

}
