package br.cefetrj.sisgee.model.dao;

import br.cefetrj.sisgee.model.entity.AgenteIntegracao;

/**
 * @author Leticia
 * Classe para pesquisas no banco relacionadas com a entidade Agente de integração
 */

public class AgenteIntegracaoDAO  extends GenericDAO<AgenteIntegracao> {
	
	public AgenteIntegracaoDAO(){
		super(AgenteIntegracao.class, PersistenceManager.getEntityManager());
	}

}
