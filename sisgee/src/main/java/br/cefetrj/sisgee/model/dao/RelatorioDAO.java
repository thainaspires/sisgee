package br.cefetrj.sisgee.model.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefetrj.sisgee.model.entity.TermoEstagio;

public class RelatorioDAO {
	
	public static List<TermoEstagio> relatorioTermos(Date dataInicial, Date dataFinal, String estagioObr){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from TermoEstagio as p "+"where p.estagioobrigatorio = :paramNome and p.datainiciote >= :datainicial and p.datainiciote <= :datafinal");
		query.setParameter("paramNome", Integer.parseInt(estagioObr));
		query.setParameter("datainicial", dataInicial);
		query.setParameter("datafinal", dataFinal);
		List<TermoEstagio> lista = query.getResultList();
		System.out.println(lista);
		
		return lista;
		
		/*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("SELECT c.nomeCurso, count(te.idte), count(ta.idta), count(te.datarescisaote) FROM Curso c JOIN a.curso Aluno a JOIN te.aluno TermoEstagio te LEFT JOIN ta.termoEstagio TermoAditivo ta WHERE te.estagioobrigatorio = :estagioobr and te.datainiciote >= :datainicial and te.datainiciote <= datafinal  GROUP BY c.nomeCurso");
		query.setParameter("datainicial", dataInicial);
		query.setParameter("datafinal", dataFinal);
		query.setParameter("estagioobr", estagioObr);

		/*
		 * Tentativa dois
		 * select c.nomecurso as NomeCurso, count(te.idte) as NumTermoEstagio, count(ta.idta) as NumTermoAditivo, count(te.datarescisaote) as NumRescisao from Curso c JOIN Aluno a a.curso JOIN TermoEstagio termoestagio te ON te.aluno_idaluno = a.idaluno LEFT JOIN termoaditivo ta ON ta.termoestagio_idte = te.idte where te.estagioobrigatorio = 1 and te.datainiciote >= '1960-02-01' and te.datainiciote <= '2017-08-01'  group by c.nomecurso
		 */
		
/*
		SELECT sum(price) AS Income, count(*) AS Passages, Station.Name 
		FROM Passage
		INNER JOIN station ON passage.stationId = station.id
		GROUP BY Station.Name
		
		SELECT SUM(s.price) Income, COUNT(p) Passages, s.Name
		FROM Passage p, Station s
		WHERE p.stationId = s.id
		GROUP BY s.Name
		
		SELECT c.nomeCurso, count(te.idte), count(ta.idta), count(te.datarescisaote)
		FROM Curso c, TermoEstagio te, TermoAditivo ta 
		JOIN a.curso a JOIN te.aluno te LEFT JOIN ta.termoestagio ta 
		WHERE te.estagioobrigatorio = :estagioobr and te.datainiciote >= :datainicial and te.datainiciote <= datafinal  
		GROUP BY c.nomeCurso
		
select c.nomecurso as NomeCurso, count(te.idte) as NumTermoEstagio, count(ta.idta) as 
NumTermoAditivo, count(te.datarescisaote) as NumRescisao from curso c JOIN aluno a ON 
a.curso_idcurso = c.idcurso JOIN termoestagio te ON te.aluno_idaluno = a.idaluno LEFT JOIN 
termoaditivo ta ON ta.termoestagio_idte = te.idte where te.estagioobrigatorio = 1 and 
te.datainiciote >= '1960-02-01' and te.datainiciote <= '2017-08-01'  group by c.nomecurso


		
	*/	
		/*
		List<Curso> lista = query.getResultList();
		System.out.println("lista: "+lista);
		*/
		/** TODO: COnsulta no banco **/
		
		/* ALERTA: QUERY FUNCIONANDO */
		
		/*Query query = manager.createQuery("select a from Aluno a JOIN a.pessoa JOIN a.curso JOIN a.campus WHERE matricula = :paramNome");
		query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();*/
		
		/*System.out.println(dataInicial + " " + dataFinal + " " + estagioObr);
		manager.close();*/
		
	}
		
}
