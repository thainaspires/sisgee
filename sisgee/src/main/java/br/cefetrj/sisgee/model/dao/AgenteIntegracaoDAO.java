package br.cefetrj.sisgee.model.dao;

import br.cefetrj.sisgee.model.entity.AgenteIntegracao;

public class AgenteIntegracaoDAO  extends GenericDAO<AgenteIntegracao> {
	
	public AgenteIntegracaoDAO(){
		super(AgenteIntegracao.class, PersistenceManager.getEntityManager());
	}

}
