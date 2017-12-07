package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Empresa;

/**
 * Classe para pesquisas no banco relacionadas com a entidade empresa
 * @author Bruno
 */

public class EmpresaDAO  extends GenericDAO<EmpresaDAO>{
	
	public EmpresaDAO(){
		super(EmpresaDAO.class, PersistenceManager.getEntityManager());
	}
	
	/**
	 * Busca uma empresa ligada a um agente de integração a partir de seu cnpj e o agente de integração
	 * @author Bruno
	 * @param agenteintegracao
	 * @param cnpj
	 * @return retorna lista de empresas
	 */
	
	public static List<Empresa> buscarPorAgenteIntegracao(AgenteIntegracao agenteintegracao, String cnpj){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();	
		manager.close();
		factory.close();
		return null;
	}
	
	/**
	 * @author Leticia
	 * busca uma empresa que esteja ligada ao agente de integração
	 * @param agenteintegracao
	 * @param cnpj
	 * @return retorna uma lista contendo a empresa ligada ao cnpj
	 */
	
	public static List<Empresa> buscarPorCNPJ(String cnpj_empresa){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from Empresa as p "+"where p.cnpjEmpresa = :paramNome");
		query.setParameter("paramNome", cnpj_empresa);
		List<Empresa> lista = query.getResultList();
		manager.close();
		factory.close();
		return lista;
	}
	
	/**
	 * @author Leticia
	 * busca uma empresa que esteja ligada ao agente de integração
	 * @param nome_agente
	 * @param cnpj_empresa
	 * @return retorna uma lista de empresas
	 */
	
	public static List<Empresa> buscarEmpresaLigadaAI(String cnpj_empresa, String nome_agente){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from Empresa as p " + "where p.cnpjEmpresa = :paramNome and p.agenteIntegracao.nomeAgenteIntegracao = :paramNome2");
		//Query query2 = manager.createNativeQuery("select * from empresa p JOIN agenteintegracao ai ON p.agenteintegracao_idagenteintegracao = ai.idagenteintegracao where cnpjempresa = :paramNome and ai.nomeagenteintegracao = :paramNome2");
		query.setParameter("paramNome", cnpj_empresa);
		query.setParameter("paramNome2", nome_agente);
		List<Empresa> lista = query.getResultList();
		manager.close();
		factory.close();
		return lista;
	}
	
	/*
	 * EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		//Query query = manager.createQuery("select p from Empresa as p " + "where p.cnpjEmpresa = :paramNome and p.agenteIntegracao = :paramNome2");
		Query query2 = manager.createNativeQuery("select * from empresa p JOIN agenteintegracao ai ON p.agenteintegracao_idagenteintegracao = ai.idagenteintegracao where cnpjempresa = :paramNome and ai.nomeagenteintegracao = :paramNome2");
		query2.setParameter("paramNome", cnpj_empresa);
		query2.setParameter("paramNome2", nome_agente);
		List<Object []> lista = query2.getResultList();
		String retorno = (String) lista.get(0)[0];
		System.out.println("lista TESTE: "+lista.get(0)[0]);
		manager.close();
		return retorno;
	 */

}
