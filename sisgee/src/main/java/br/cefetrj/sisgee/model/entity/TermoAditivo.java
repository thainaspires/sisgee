package br.cefetrj.sisgee.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Nathalia Gomes
 * Classe para entidade Termo Aditivo
 */

@Entity
public class TermoAditivo {
	
	@Id
	@GeneratedValue
	private Long idTA;
	private Date dataFimTA;
	private Integer cargaHorariaTA;
	private Float valorBolsaTA;
	private String enderecoTA;
	private String numeroEnderecoTA;
	private String complementoEnderecoTA;
	private String bairroEnderecoTA;
	private String cepEnderecoTA;
	private String cidadeEnderecoTA;
	private String estadoEnderecoTA;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private TermoEstagio termoEstagio;
	
	public Long getIdTA() {
		return idTA;
	}
	public void setIdTA(Long idTA) {
		this.idTA = idTA;
	}
	public Date getDataFimTA() {
		return dataFimTA;
	}
	public void setDataFimTA(Date dataFimTA) {
		this.dataFimTA = dataFimTA;
	}
	public Integer getCargaHorariaTA() {
		return cargaHorariaTA;
	}
	public void setCargaHorariaTA(Integer cargaHorariaTA) {
		this.cargaHorariaTA = cargaHorariaTA;
	}
	public Float getValorBolsaTA() {
		return valorBolsaTA;
	}
	public void setValorBolsaTA(Float valorBolsaTA) {
		this.valorBolsaTA = valorBolsaTA;
	}
	public String getEnderecoTA() {
		return enderecoTA;
	}
	public void setEnderecoTA(String enderecoTA) {
		this.enderecoTA = enderecoTA;
	}
	public String getNumeroEnderecoTA() {
		return numeroEnderecoTA;
	}
	public void setNumeroEnderecoTA(String numeroEnderecoTA) {
		this.numeroEnderecoTA = numeroEnderecoTA;
	}
	public String getComplementoEnderecoTA() {
		return complementoEnderecoTA;
	}
	public void setComplementoEnderecoTA(String complementoEnderecoTA) {
		this.complementoEnderecoTA = complementoEnderecoTA;
	}
	public String getBairroEnderecoTA() {
		return bairroEnderecoTA;
	}
	public void setBairroEnderecoTA(String bairroEnderecoTA) {
		this.bairroEnderecoTA = bairroEnderecoTA;
	}
	public String getCepEnderecoTA() {
		return cepEnderecoTA;
	}
	public void setCepEnderecoTA(String cepEnderecoTA) {
		this.cepEnderecoTA = cepEnderecoTA;
	}
	public String getCidadeEnderecoTA() {
		return cidadeEnderecoTA;
	}
	public void setCidadeEnderecoTA(String cidadeEnderecoTA) {
		this.cidadeEnderecoTA = cidadeEnderecoTA;
	}
	public String getEstadoEnderecoTA() {
		return estadoEnderecoTA;
	}
	public void setEstadoEnderecoTA(String estadoEnderecoTA) {
		this.estadoEnderecoTA = estadoEnderecoTA;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairroEnderecoTA == null) ? 0 : bairroEnderecoTA.hashCode());
		result = prime * result + ((cargaHorariaTA == null) ? 0 : cargaHorariaTA.hashCode());
		result = prime * result + ((cepEnderecoTA == null) ? 0 : cepEnderecoTA.hashCode());
		result = prime * result + ((cidadeEnderecoTA == null) ? 0 : cidadeEnderecoTA.hashCode());
		result = prime * result + ((complementoEnderecoTA == null) ? 0 : complementoEnderecoTA.hashCode());
		result = prime * result + ((dataFimTA == null) ? 0 : dataFimTA.hashCode());
		result = prime * result + ((enderecoTA == null) ? 0 : enderecoTA.hashCode());
		result = prime * result + ((estadoEnderecoTA == null) ? 0 : estadoEnderecoTA.hashCode());
		result = prime * result + ((idTA == null) ? 0 : idTA.hashCode());
		result = prime * result + ((numeroEnderecoTA == null) ? 0 : numeroEnderecoTA.hashCode());
		result = prime * result + ((valorBolsaTA == null) ? 0 : valorBolsaTA.hashCode());
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
		TermoAditivo other = (TermoAditivo) obj;
		if (bairroEnderecoTA == null) {
			if (other.bairroEnderecoTA != null)
				return false;
		} else if (!bairroEnderecoTA.equals(other.bairroEnderecoTA))
			return false;
		if (cargaHorariaTA == null) {
			if (other.cargaHorariaTA != null)
				return false;
		} else if (!cargaHorariaTA.equals(other.cargaHorariaTA))
			return false;
		if (cepEnderecoTA == null) {
			if (other.cepEnderecoTA != null)
				return false;
		} else if (!cepEnderecoTA.equals(other.cepEnderecoTA))
			return false;
		if (cidadeEnderecoTA == null) {
			if (other.cidadeEnderecoTA != null)
				return false;
		} else if (!cidadeEnderecoTA.equals(other.cidadeEnderecoTA))
			return false;
		if (complementoEnderecoTA == null) {
			if (other.complementoEnderecoTA != null)
				return false;
		} else if (!complementoEnderecoTA.equals(other.complementoEnderecoTA))
			return false;
		if (dataFimTA == null) {
			if (other.dataFimTA != null)
				return false;
		} else if (!dataFimTA.equals(other.dataFimTA))
			return false;
		if (enderecoTA == null) {
			if (other.enderecoTA != null)
				return false;
		} else if (!enderecoTA.equals(other.enderecoTA))
			return false;
		if (estadoEnderecoTA == null) {
			if (other.estadoEnderecoTA != null)
				return false;
		} else if (!estadoEnderecoTA.equals(other.estadoEnderecoTA))
			return false;
		if (idTA == null) {
			if (other.idTA != null)
				return false;
		} else if (!idTA.equals(other.idTA))
			return false;
		if (numeroEnderecoTA == null) {
			if (other.numeroEnderecoTA != null)
				return false;
		} else if (!numeroEnderecoTA.equals(other.numeroEnderecoTA))
			return false;
		if (valorBolsaTA == null) {
			if (other.valorBolsaTA != null)
				return false;
		} else if (!valorBolsaTA.equals(other.valorBolsaTA))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TermoAditivo [idTA=" + idTA + ", dataFimTA=" + dataFimTA + ", cargaHorariaTA=" + cargaHorariaTA
				+ ", valorBolsaTA=" + valorBolsaTA + ", enderecoTA=" + enderecoTA + ", numeroEnderecoTA="
				+ numeroEnderecoTA + ", complementoEnderecoTA=" + complementoEnderecoTA + ", bairroEnderecoTA="
				+ bairroEnderecoTA + ", cepEnderecoTA=" + cepEnderecoTA + ", cidadeEnderecoTA=" + cidadeEnderecoTA
				+ ", estadoEnderecoTA=" + estadoEnderecoTA + "]";
	}
	
}
