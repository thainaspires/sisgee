package br.cefetrj.sisgee.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * @author Nathalia Gomes
 * Classe para a entidade campus
 */

@Entity
public class Campus {
	@Id
	@GeneratedValue
	@Column(columnDefinition="integer")
	private Long idCampus;
	@Column(columnDefinition="CHAR(100)", nullable = false)
	private String nomeCampus;
	
	@OneToMany(mappedBy="campus")
	private List<Curso> cursos;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCampus == null) ? 0 : idCampus.hashCode());
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
		Campus other = (Campus) obj;
		if (idCampus == null) {
			if (other.idCampus != null)
				return false;
		} else if (!idCampus.equals(other.idCampus))
			return false;
		return true;
	}

	public Long getIdCampus() {
		return idCampus;
	}

	public void setIdCampus(Long idCampus) {
		this.idCampus = idCampus;
	}

	public String getNomeCampus() {
		return nomeCampus;
	}

	public void setNomeCampus(String nomeCampus) {
		this.nomeCampus = nomeCampus;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
