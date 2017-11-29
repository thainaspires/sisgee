package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Convenio;
import br.cefetrj.sisgee.model.entity.Empresa;

public class ConvenioDAO extends GenericDAO<ConvenioDAO>{
	public ConvenioDAO(){
		super(ConvenioDAO.class, PersistenceManager.getEntityManager());
	}
	
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
