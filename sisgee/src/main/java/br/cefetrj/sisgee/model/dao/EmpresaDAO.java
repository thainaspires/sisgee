package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Empresa;

public class EmpresaDAO  extends GenericDAO<EmpresaDAO>{
	
	public EmpresaDAO(){
		super(EmpresaDAO.class, PersistenceManager.getEntityManager());
	}
	
	public static List<Empresa> buscarPorAgenteIntegracao(AgenteIntegracao agenteIntegracao, String CNPJ){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		
		//** TODO: Buscar a empresa que está ligada aquele agente de integração **//
		
		manager.close();
		
		return null;
	}
	
	public static List<Empresa> buscarPorCNPJ(String cnpj_empresa){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from Empresa as p "+"where p.cnpjEmpresa = :paramNome");
		query.setParameter("paramNome", cnpj_empresa);
		List<Empresa> lista = query.getResultList();
		System.out.println("lista: "+lista);
		manager.close();
		return lista;
	}
	
	public static List<Empresa> buscarEmpresaLigadaAI(String cnpj_empresa, String nome_agente){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from Empresa as p " + "where p.cnpjEmpresa = :paramNome and p.agenteIntegracao.nomeAgenteIntegracao = :paramNome2");
		query.setParameter("paramNome", cnpj_empresa);
		query.setParameter("paramNome2", nome_agente);
		List<Empresa> lista = query.getResultList();
		System.out.println("lista: "+lista);
		manager.close();
		return lista;
	}

}
