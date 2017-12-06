package br.cefetrj.sisgee.model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.cefetrj.sisgee.model.entity.TermoEstagio;

/**
 * @author Bruno
 * Classe para manipulações no banco relacionadas com a entidade termo estagio
 */

public class TermoEstagioDAO {
	/**
	 * @author Bruno
	 * Buscar termos estagios a partir de id
	 * @param id Long - Id do termo
	 * @return TermoEstagio - Retorna o termo estágio procurado
	 */
	public static TermoEstagio buscarTermoPorIdAluno(Long id){
		TermoEstagio termo = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from TermoEstagio as p "+"where p.aluno.idAluno = :paramNome and p.datarescisaote is null");
		query.setParameter("paramNome", id);
		List<TermoEstagio> lista = query.getResultList();
		manager.close();
		factory.close();
		if(lista.size() == 0 || lista.size() > 1){
			return null;
		}else{
			termo = lista.get(0);
			return termo;
		}
	}
	/**
	 * @author Bruno
	 * Altera o termo estagio para acrescentar a data de rescisão
	 * @param termo TermoEstagio - Entidade termo
	 * @param data_Rescisao Date - Data de rescisão do termo
	 * @return void
	 */
	public static void AlterarTermoEstagio(TermoEstagio termo, Date data_Rescisao){
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		termo.setDatarescisaote(data_Rescisao);
		manager.merge(termo);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	/**
	 * @author Bruno
	 * Incluir termo de estágio no banco
	 * @param termo TermoEstagio - Entidade termo
	 * @return void
	 */
	public static void IncluirTermoEstagio(TermoEstagio termo){
		
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
	
		manager.getTransaction().begin();
		
		manager.persist(termo);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}