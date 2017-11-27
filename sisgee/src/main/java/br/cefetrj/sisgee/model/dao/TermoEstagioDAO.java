package br.cefetrj.sisgee.model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.cefetrj.sisgee.model.entity.TermoEstagio;

public class TermoEstagioDAO {
	public static TermoEstagio buscarTermoPorIdAluno(Long id){
		TermoEstagio termo = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select p from TermoEstagio as p "+"where p.aluno.idAluno = :paramNome and p.datarescisaote is null");
		query.setParameter("paramNome", id);
		List<TermoEstagio> lista = query.getResultList();
		manager.close();
		if(lista.size() == 0 || lista.size() > 1){
			return null;
		}else{
			termo = lista.get(0);
			return termo;
		}
		
	}
	
	public static void AlterarTermoEstagio(TermoEstagio termo, Date data_Rescisao){
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		termo.setDatarescisaote(data_Rescisao);
		manager.merge(termo);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	public static void IncluirTermoEstagio(TermoEstagio termo){
		
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("SisgeePU");
		EntityManager manager = factory.createEntityManager();
	
		manager.getTransaction().begin();
		
		manager.persist(termo);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		System.out.println("terminou");
	}
}