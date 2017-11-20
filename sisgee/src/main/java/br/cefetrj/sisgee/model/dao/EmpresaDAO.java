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
	
	public static List<Empresa> buscarPorAgenteIntegracao(AgenteIntegracao agenteIntegracao, String CNPJ){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		
		//** TODO: Buscar a empresa que est� ligada aquele agente de integra��o **//
		
		manager.close();
		
		return null;
	}

}
