package br.cefetrj.sisgee.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Thaina Pires
 * Classe para a entidade Agente de Integracao
 */

@Entity
public class AgenteIntegracao {
	@Id
	@GeneratedValue
	@Column(columnDefinition="integer")
	private Long idAgenteIntegracao;
	@Column(columnDefinition="CHAR(14)",nullable=false)
	private String cnpjAgenteIntegracao;
	@Column(columnDefinition="VARCHAR(100)",nullable=false)
	private String nomeAgenteIntegracao;
	
	@OneToMany(mappedBy="agenteIntegracao")
	private List<Empresa> empresa;
	
	
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
	/**
	 * @author Thaina Pires
	 * Compara se dois objetos Agente de Integração sao o mesmo objeto
	 * @param obj Object
	 * @return boolean
	 */
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
	/**
	 * @author Thaina Pires
	 * Sobrescreve o toString padrão
	 * @return void
	 */
	
	@Override
	public String toString() {
		return nomeAgenteIntegracao;
	}
}
