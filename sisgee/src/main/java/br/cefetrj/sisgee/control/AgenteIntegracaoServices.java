package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;

/**
 * Trata servi�os relacionados aoagente de integra��o
 * @author Thain�
 */
public class AgenteIntegracaoServices {
	public static void registrarAgenteIntegracao(AgenteIntegracao ai){
		GenericDAO<AgenteIntegracao> agenteDao = PersistenceManager.createGenericDAO(AgenteIntegracao.class);
		PersistenceManager.getTransaction().begin();
		try{
			agenteDao.incluir(ai);
			PersistenceManager.getTransaction().commit();
		}catch(Exception e){
			PersistenceManager.getTransaction().rollback();
		}
	}
	
	
	public static List<AgenteIntegracao> listarAgentesIntegracao(){
		GenericDAO<AgenteIntegracao> agenteIntegracaoDAO = 
				PersistenceManager.createGenericDAO(AgenteIntegracao.class);
		return agenteIntegracaoDAO.buscarTodos();
	}
	
}
