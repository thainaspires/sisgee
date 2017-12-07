package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Pessoa;

/**
 * Classe para pesquisas no banco relacionadas com a entidade aluno
 * @author Leticia
 */

public class AlunoDAO  extends GenericDAO<Aluno> {
	
	public AlunoDAO(){
		super(Aluno.class, PersistenceManager.getEntityManager());
	}
	
	/**
	 * Busca um aluno a partir da matr�cula
	 * @author Leticia
	 * @param matricula
	 * @return retorna uma lista com o aluno correspondente a matr�cula
	 */
	
	public static List<Aluno> buscarPorMatricula(String matricula){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from Aluno as p "+"where p.matricula = :paramNome");
		query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();
		manager.close();
		factory.close();
		
		return lista;
	}

}
