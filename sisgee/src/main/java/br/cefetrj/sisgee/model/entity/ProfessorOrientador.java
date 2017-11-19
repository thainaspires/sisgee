package br.cefetrj.sisgee.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProfessorOrientador {
	/**
	 * Todos os atributos que se refiram a ProfessorOrientador ser�o denominados com o sufixo po
	 * @author: Alexander Hugo
	 */
	@Id
	@GeneratedValue
	private Long idpo;
	private String nomepo;
	
	@ManyToMany(mappedBy="TermoEstagio") 
	private List<TermoEstagio> termosEstagio;
	
	public Long getIdpo() {
		return idpo;
	}
	public void setIdpo(Long idpo) {
		this.idpo = idpo;
	}
	public String getNomepo() {
		return nomepo;
	}
	public void setNomepo(String nomepo) {
		this.nomepo = nomepo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpo == null) ? 0 : idpo.hashCode());
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
		ProfessorOrientador other = (ProfessorOrientador) obj;
		if (idpo == null) {
			if (other.idpo != null)
				return false;
		} else if (!idpo.equals(other.idpo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProfessorOrientador [nomepo=" + nomepo + "]";
	}
	
	
}
