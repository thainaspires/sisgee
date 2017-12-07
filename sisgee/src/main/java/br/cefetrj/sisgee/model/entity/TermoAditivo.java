package br.cefetrj.sisgee.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe para entidade Termo Aditivo
 * @author Nathalia Gomes
 */

@Entity
public class TermoAditivo {
	
	@Id
	@GeneratedValue
	@Column(columnDefinition="integer")
	private Long idta;
	
	@Column(columnDefinition="date")
	private Date dataFimta;
	@Column(columnDefinition="integer",nullable=false)
	private Integer cargaHorariata;
	@Column(columnDefinition="float",nullable=false)
	private Float valorBolsata;
	@Column(columnDefinition="VARCHAR(255)",nullable=false)
	private String enderecota;
	@Column(columnDefinition="VARCHAR(10)",nullable=false)
	private String numeroEnderecota;
	@Column(columnDefinition="VARCHAR(150)",nullable=false)
	private String complementoEnderecota;
	@Column(columnDefinition="VARCHAR(150)",nullable=false)
	private String bairroEnderecota;
	@Column(columnDefinition="VARCHAR(15)",nullable=false)
	private String cepEnderecota;
	@Column(columnDefinition="VARCHAR(150)",nullable=false)
	private String cidadeEnderecota;
	@Column(columnDefinition="VARCHAR(2)",nullable=false)
	private String estadoEnderecota;

	
	@ManyToOne(fetch=FetchType.EAGER)
	private TermoEstagio termoEstagio;
	
	public TermoEstagio getTermoEstagio(){
		return termoEstagio;
	}
	
	public Long getIdta() {
		return idta;
	}
	public void setIdta(Long idta) {
		this.idta = idta;
	}
	public Date getDataFimta() {
		return dataFimta;
	}
	public void setDataFimta(Date dataFimta) {
		this.dataFimta = dataFimta;
	}
	public Integer getCargaHorariata() {
		return cargaHorariata;
	}
	public void setCargaHorariata(Integer cargaHorariata) {
		this.cargaHorariata = cargaHorariata;
	}
	public Float getValorBolsata() {
		return valorBolsata;
	}
	public void setValorBolsata(Float valorBolsata) {
		this.valorBolsata = valorBolsata;
	}
	public String getEnderecota() {
		return enderecota;
	}
	public void setEnderecota(String enderecota) {
		this.enderecota = enderecota;
	}
	public String getNumeroEnderecota() {
		return numeroEnderecota;
	}
	public void setNumeroEnderecota(String numeroEnderecota) {
		this.numeroEnderecota = numeroEnderecota;
	}
	public String getComplementoEnderecota() {
		return complementoEnderecota;
	}
	public void setComplementoEnderecota(String complementoEnderecota) {
		this.complementoEnderecota = complementoEnderecota;
	}
	public String getBairroEnderecota() {
		return bairroEnderecota;
	}
	public void setBairroEnderecota(String bairroEnderecota) {
		this.bairroEnderecota = bairroEnderecota;
	}
	public String getCepEnderecota() {
		return cepEnderecota;
	}
	public void setCepEnderecota(String cepEnderecota) {
		this.cepEnderecota = cepEnderecota;
	}
	public String getCidadeEnderecota() {
		return cidadeEnderecota;
	}
	public void setCidadeEnderecota(String cidadeEnderecota) {
		this.cidadeEnderecota = cidadeEnderecota;
	}
	public String getEstadoEnderecota() {
		return estadoEnderecota;
	}
	public void setEstadoEnderecota(String estadoEnderecota) {
		this.estadoEnderecota = estadoEnderecota;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idta == null) ? 0 : idta.hashCode());
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
		if (idta == null) {
			if (other.idta != null)
				return false;
		} else if (!idta.equals(other.idta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TermoAditivo [idta=" + idta + "]";
	}
	
	
	
}
