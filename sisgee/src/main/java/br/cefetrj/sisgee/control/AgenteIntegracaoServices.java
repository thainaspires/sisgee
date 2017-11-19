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
	public static String validaCnpjAgente(String cnpj){
		String msg = "";
		if(!(cnpj != null && cnpj.trim().length() > 0)){
			msg += "CNPJ é um campo obrigatório.";
		}
		return msg;
	}
	public static String validaRazaoSocialAgente(String razaosocial){
		String msg = "";
		if(!(razaosocial != null && razaosocial.trim().length() > 0)){
			msg += "Razão Social é um campo obrigatório.";
		}
		return msg;
	}
}
