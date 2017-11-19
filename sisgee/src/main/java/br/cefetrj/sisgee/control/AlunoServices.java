package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.Aluno;

/**
 * Exemplo de como utilizar a busca
 * 
 * @author Alexander Hugo
 * 
 */
public class AlunoServices {
	
	/**
	 * Recupera todos os alunos e retorna em uma lista.
	 * 
	 * @return lista com todos os alunos
	 */
	public static List<Aluno> listarAlunos(){
		GenericDAO<Aluno> alunoDao = PersistenceManager.createGenericDAO(Aluno.class);
		return alunoDao.buscarTodos();
	}
	
	
	public static void incluirAluno(Aluno aluno){
		GenericDAO<Aluno> alunoDao = PersistenceManager.createGenericDAO(Aluno.class);
		PersistenceManager.getTransaction().begin();
		try{
			alunoDao.incluir(aluno);
			PersistenceManager.getTransaction().commit();
		}catch(Exception e){
			PersistenceManager.getTransaction().rollback();
		}
	}
	

}
