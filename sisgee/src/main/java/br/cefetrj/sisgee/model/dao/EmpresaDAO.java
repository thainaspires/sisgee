package br.cefetrj.sisgee.model.dao;

import br.cefetrj.sisgee.model.entity.Aluno;

public class EmpresaDAO  extends GenericDAO<EmpresaDAO>{
	
	public EmpresaDAO(){
		super(EmpresaDAO.class, PersistenceManager.getEntityManager());
	}

}
