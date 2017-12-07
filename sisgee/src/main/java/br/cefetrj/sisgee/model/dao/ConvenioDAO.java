package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Convenio;
import br.cefetrj.sisgee.model.entity.Empresa;

/**
 * Classe para pesquisas no banco relacionadas com a entidade conv�nio
 * @author Leticia
 */

public class ConvenioDAO extends GenericDAO<ConvenioDAO>{
	public ConvenioDAO(){
		super(ConvenioDAO.class, PersistenceManager.getEntityManager());
	}
	/**
	 * Busca um conv�nio a a partir do n�mero do conv�nio
	 * @author Leticia
	 * @param numero_convenio
	 * @return retorna uma lista contendo o conv�nio correspondente ao n�mero
	 */
	public static List<Convenio> buscarConvenioPeloNumero(String numero_convenio){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select p from Convenio as p "+"where p.numeroConvenio = :paramNome");
		query.setParameter("paramNome", numero_convenio);
		List<Convenio> lista = query.getResultList();

		manager.close();
		factory.close();
		
		return lista;
	}
}
