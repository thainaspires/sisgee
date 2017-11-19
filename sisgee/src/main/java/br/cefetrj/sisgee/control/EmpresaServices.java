package br.cefetrj.sisgee.control;

import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
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
	public static String validaCnpj(String cnpj){
		String msg = "";
		if(!(cnpj != null && cnpj.trim().length() > 0)){
			msg += "CNPJ é um campo obrigatório.";
		}
		return msg;
	}
	public static String validaRazaoSocial(String razaosocial){
		String msg = "";
		if(!(razaosocial != null && razaosocial.trim().length() > 0)){
			msg += "Razão Social é um campo obrigatório.";
		}
		return msg;
	}
}
