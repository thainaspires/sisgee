package br.cefetrj.sisgee.model.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.TermoEstagio;

/**
 * @author Bruno
 * Classe para manipulações no banco relacionadas com o relatório de termos
 */

public class RelatorioDAO {
	
	/**
	 * @author Bruno
	 * Busca de termos no banco de dados entre as datas escolhidas 
	 * @param dataInicial
	 * @param dataFinal
	 * @param estagioObr
	 * @return retorna uma lista de objetos
	 */
	
	public static List<Object[]> relatorioTermos(Date dataInicial, Date dataFinal, String estagioObr){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNativeQuery("select c.nomecurso as NomeCurso, count(te.idte) as NumTermoEstagio, count(ta.idta) as " + 
				"NumTermoAditivo, count(te.datarescisaote) as NumRescisao from curso c JOIN aluno a ON "+
				"a.curso_idcurso = c.idcurso JOIN termoestagio te ON te.aluno_idaluno = a.idaluno LEFT JOIN "+
				"termoaditivo ta ON ta.termoestagio_idte = te.idte where te.estagioobrigatorio = :estagObr and "+
				"te.datainiciote >= :dataInicial and te.datainiciote <= :dataFinal  group by c.nomecurso");
		Integer estagObr = Integer.parseInt(estagioObr);
		query.setParameter("estagObr", estagObr);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
		List<Object[]> relatorio = query.getResultList();
		
		manager.close();
		factory.close();
		return relatorio;
	
	}
		
}
