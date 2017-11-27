package br.cefetrj.sisgee.control;

import java.util.List;

import br.cefetrj.sisgee.model.dao.ConvenioDAO;
import br.cefetrj.sisgee.model.dao.GenericDAO;
import br.cefetrj.sisgee.model.dao.PersistenceManager;
import br.cefetrj.sisgee.model.entity.Convenio;
import br.cefetrj.sisgee.model.entity.Empresa;

public class ConvenioServices {
	public static void registrarConvenio(Convenio convenio){
		GenericDAO<Convenio> convenioDao = PersistenceManager.createGenericDAO(Convenio.class);
		PersistenceManager.getTransaction().begin();
		try{
			convenioDao.incluir(convenio);
			PersistenceManager.getTransaction().commit();
		}catch(Exception e){
			PersistenceManager.getTransaction().rollback();
		}
	}
	public static List<Convenio> buscarConvenio(String numero_convenio){
		return ConvenioDAO.buscarConvenioPeloNumero(numero_convenio);
	}
}
