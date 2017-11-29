package br.cefetrj.sisgee.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TermoAditivoDAO {
	
	public static List listarTermosAditivos(String matricula){
		List<Object[]> termosaditivos = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query2 = manager.createNativeQuery("select ta.datafimta, e.cnpjempresa,e.nomeempresa, ta.idta from termoaditivo ta JOIN termoestagio te ON ta.termoestagio_idte = te.idte JOIN aluno a ON a.idaluno = te.aluno_idaluno JOIN convenio c ON te.convenio_idconvenio = c.idconvenio JOIN empresa e ON c.empresa_idempresa = e.idempresa where matricula =:matricula");
		query2.setParameter("matricula", matricula);
		termosaditivos = query2.getResultList();
		manager.close();
		factory.close();
		if(termosaditivos.isEmpty()){
			return null;
		}else{
			return termosaditivos;
		}
	}
	
	public static List listarTermoEstagio(String matricula){
		List<Object[]> termoestagio = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNativeQuery("select te.datafimte,e.cnpjempresa,e.nomeempresa, te.idte from aluno a JOIN termoestagio te ON a.idaluno = te.aluno_idaluno JOIN convenio c ON te.convenio_idconvenio = c.idconvenio JOIN empresa e ON c.empresa_idempresa = e.idempresa where matricula =:matricula and datarescisaote is null");
		query.setParameter("matricula", matricula);
		termoestagio = query.getResultList();
		
		if(termoestagio.isEmpty()){
			return null;
		}else{
			return termoestagio;
		}
	}
	/*//Lógica 1 - se retornar vazio, aluno não possui termoestágio
	select te.datafimte,e.cnpjempresa,e.nomeempresa from aluno a JOIN termoestagio te ON a.idaluno = te.aluno_idaluno JOIN convenio c ON te.convenio_idconvenio = c.idconvenio JOIN empresa e ON c.empresa_idempresa = e.idempresa where matricula = '5555123'

	//Lógica 2 -  se retonar vazio, aluno não possui aditivo, porém, da lógica 1, ele possui TermoEstágio
	select ta.datafimta, e.cnpjempresa,e.nomeempresa from termoaditivo ta JOIN termoestagio te ON ta.termoestagio_idte = te.idte JOIN aluno a ON a.idaluno = te.aluno_idaluno JOIN convenio c ON te.convenio_idconvenio = c.idconvenio JOIN empresa e ON c.empresa_idempresa = e.idempresa where matricula = '5555123'
	*/
}
