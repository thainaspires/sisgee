package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.EmpresaDAO;
import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Empresa;

/** 
 * @author Alexander Hugo
 */
public class EmpresaServices {
	public static void registrarEmpresa(Empresa empresa){
		GenericDAO<Empresa> empresaDao = PersistenceManager.createGenericDAO(Empresa.class);
		PersistenceManager.getTransaction().begin();
		try{
			empresaDao.incluir(empresa);
			PersistenceManager.getTransaction().commit();
		}catch(Exception e){
			PersistenceManager.getTransaction().rollback();
		}
	}
	
	public static List<Empresa> buscarPorAgentInt(AgenteIntegracao agenteIntegracao, String CNPJ){
		return EmpresaDAO.buscarPorAgenteIntegracao(agenteIntegracao, CNPJ);
	}
	
	public static List<Empresa> buscarEmpresa(String cnpj_empresa){
		return EmpresaDAO.buscarPorCNPJ(cnpj_empresa);
	}
	
	public static List<Empresa> buscarEmpresaLigadaAI(String cnpj_empresa, String nome_agente){
		return EmpresaDAO.buscarEmpresaLigadaAI(cnpj_empresa, nome_agente);
	}
}
