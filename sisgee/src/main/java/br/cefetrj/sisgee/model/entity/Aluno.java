package br.cefetrj.sisgee.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Classe para a entidade aluno
 * @author Thaina Pires
 */

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	@Column(columnDefinition="integer")
	private Long idAluno;
	@Column(columnDefinition="VARCHAR(100)", nullable = false)
	private String matricula;
	
	@OneToMany(mappedBy="aluno")
	private List<TermoEstagio> termosEstagios;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Pessoa pessoa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Curso curso;
	
	public List<TermoEstagio> getTermoEstagio(){
		return termosEstagios;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return matricula;
	}
}
