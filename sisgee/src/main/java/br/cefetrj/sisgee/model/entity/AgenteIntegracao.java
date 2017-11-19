package br.cefetrj.sisgee.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Thaina Pires
 * Classe para a entidade Agente de Integração
 */

@Entity
public class AgenteIntegracao {
	@Id
	@GeneratedValue
	private Long idAgenteIntegracao;
	private String cnpjAgenteIntegracao;
	private String nomeAgenteIntegracao;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Empresa> empresas;
	
	public Long getIdAgenteIntegracao() {
		return idAgenteIntegracao;
	}
	public void setIdAgenteIntegracao(Long idAgenteIntegracao) {
		this.idAgenteIntegracao = idAgenteIntegracao;
	}
	public String getCnpjAgenteIntegracao() {
		return cnpjAgenteIntegracao;
	}
	public void setCnpjAgenteIntegracao(String cnpjAgenteIntegracao) {
		this.cnpjAgenteIntegracao = cnpjAgenteIntegracao;
	}
	public String getNomeAgenteIntegracao() {
		return nomeAgenteIntegracao;
	}
	public void setNomeAgenteIntegracao(String nomeAgenteIntegracao) {
		this.nomeAgenteIntegracao = nomeAgenteIntegracao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAgenteIntegracao == null) ? 0 : idAgenteIntegracao.hashCode());
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
		AgenteIntegracao other = (AgenteIntegracao) obj;
		if (idAgenteIntegracao == null) {
			if (other.idAgenteIntegracao != null)
				return false;
		} else if (!idAgenteIntegracao.equals(other.idAgenteIntegracao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return nomeAgenteIntegracao;
	}
}
