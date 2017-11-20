package br.cefetrj.sisgee.model.dao;

import java.sql.Date;
import java.util.List;

public class GerarRelatorioDAO {
	
	public static List<String> relatorioTermos(Date dataInicial, Date dataFinal, String estagioObr){
		
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from Aluno as p "+"where p.matricula = :paramNome");
		query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();
		System.out.println("lista: "+lista);*/
		
		/** TODO: COnsulta no banco **/
		
		/* ALERTA: QUERY FUNCIONANDO */
		
		/*Query query = manager.createQuery("select a from Aluno a JOIN a.pessoa JOIN a.curso JOIN a.campus WHERE matricula = :paramNome");
		query.setParameter("paramNome", matricula);
		List<Aluno> lista = query.getResultList();*/
		
		System.out.println(dataInicial + " " + dataFinal + " " + estagioObr);
		
		return null;
	}
		
}
