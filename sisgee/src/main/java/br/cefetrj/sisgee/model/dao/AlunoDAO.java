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

		//Query query = manager.createQuery("SELECT c, p.nome from Pessoa p "+"JOIN c.id p where p.matricula = :paramNome");
		
		/* ALERTA: Query correta -> Comentada para fazer teste
		 * 
		 * Query query = manager.createQuery("select p from Aluno as p "+"where p.matricula = :paramNome");
		query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();
		System.out.println("lista: "+lista);
		*/
		
		/* ALERTA: QUERY PARA SER TESTADA */
		
		Query query = manager.createQuery("select a from Aluno a JOIN a.pessoa");
		//query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();
		System.out.println("lista: "+lista);
		
		/* ALERTA: FIM DA QUERY PARA SER TESTADA */
		/*
		Query query2 = manager.createQuery("select p from Pessoa as p "+"where p.idpessoa = 5");
		//query.setParameter("paramNome2", 5);
		List<Pessoa> lista2 = query2.getResultList();
		System.out.println("Lista2: " + lista2);
		*/
		
		/*Query query2 = manager.createQuery("select p from Aluno as p "+"where p.matricula = :paramNome");
		query2.setParameter("paramNome", matricula);
		List<Aluno> lista = query2.getResultList();
		System.out.println("lista: "+lista);
		
		//Query query = manager.createQuery("SELECT p FROM aluno a JOIN a.pessoa_idpessoa p");
		Query query = manager.createQuery("SELECT aluno, pessoa FROM Aluno aluno"+"LEFT JOIN  aluno.pessoa_idpessoa pessoa.idpessoa");
		query.setParameter("paramNome", matricula);
		List lista2 = query.getResultList();
		System.out.println("lista: "+lista2);*/
		manager.close();
		return lista;
	}

}
