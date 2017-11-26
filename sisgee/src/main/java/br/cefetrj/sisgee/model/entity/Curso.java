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
 * @author Thaina Pires
 * Classe para a entidade curso
 */

@Entity
public class Curso {
	
	@Id
	@GeneratedValue
	@Column(columnDefinition="integer")
	private Long idCurso;
	@Column(columnDefinition="VARCHAR(50)", nullable = false)
	private String codigoCurso;
	@Column(columnDefinition="VARCHAR(255)", nullable = false)
	private String nomeCurso;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Campus campus;
	
	@OneToMany(mappedBy="curso")
	private List<Aluno> alunos;
	
	public Campus getCampus() {
		return campus;
	}
	
	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nomeCurso;
	}
	
	
}
