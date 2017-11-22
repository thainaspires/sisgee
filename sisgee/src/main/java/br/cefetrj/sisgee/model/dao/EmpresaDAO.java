package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Empresa;

public class EmpresaDAO  extends GenericDAO<EmpresaDAO>{
	
	public EmpresaDAO(){
		super(EmpresaDAO.class, PersistenceManager.getEntityManager());
	}
	
	public static List<Empresa> buscarPorAgenteIntegracao(AgenteIntegracao agenteintegracao, String cnpj){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		
		//** TODO: Buscar a empresa que está ligada aquele agente de integração **//
		
		manager.close();
		
		return null;
	}

}
