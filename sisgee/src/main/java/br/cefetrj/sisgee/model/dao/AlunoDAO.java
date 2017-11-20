package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Pessoa;

public class AlunoDAO  extends GenericDAO<Aluno> {
	
	public AlunoDAO(){
		super(Aluno.class, PersistenceManager.getEntityManager());
	}
	
	public static List<Aluno> buscarPorMatricula(String matricula){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();

		/* ALERTA: QUERY ANTIGAS
		 * 
		 * 
		Query query = manager.createQuery("select p from Aluno as p "+"where p.matricula = :paramNome");
		query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();
		System.out.println("lista: "+lista);
		*/
		
		/* ALERTA: QUERY FUNCIONANDO */
		
		Query query = manager.createQuery("select a from Aluno a JOIN a.pessoa JOIN a.curso WHERE matricula = :paramNome");
		query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();
		
		manager.close();
		
		return lista;
	}

}
