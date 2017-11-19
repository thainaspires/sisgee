package br.cefetrj.sisgee.control;

import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;

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
}
