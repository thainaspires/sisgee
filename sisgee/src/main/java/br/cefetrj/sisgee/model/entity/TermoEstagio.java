package br.cefetrj.sisgee.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TermoEstagio {
	/**
	 * Todos os atributos que se refiram a TermoEstagio serão denominados com o sufixo te
	 * @author: Alexander Hugo
	 */
	@Id
	@GeneratedValue 
	private Long idte;
	private Date datainiciote;
	private Date datafimte;
	private Date datarescisaote;
	private String situacaote;
	private Integer cargahorariate;
	private Float valorbolsa;
	private String enderecote;
	private String numeroenderecote;
	private String complementoenderecote;
	private String bairroenderecote;
	private String cependerecote;
	private String cidadeenderecote;
	private String estadoenderecote;
	private Integer estagioobrigatorio;
	private Long idprofessororientador;
	private Long idaluno;
	private Long idconvenio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Convenio convenio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Aluno aluno;
	
	@OneToMany(mappedBy="termoEstagio")
	private List<TermoAditivo> termosAditivos;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<ProfessorOrientador> professoresOrientadores;
	
	public Long getIdte() {
		return idte;
	}
	public void setIdte(Long idte) {
		this.idte = idte;
	}
	public Date getDatainiciote() {
		return datainiciote;
	}
	public void setDatainiciote(Date datainiciote) {
		this.datainiciote = datainiciote;
	}
	public Date getDatafimte() {
		return datafimte;
	}
	public void setDatafimte(Date datafimte) {
		this.datafimte = datafimte;
	}
	public Date getDatarescisaote() {
		return datarescisaote;
	}
	public void setDatarescisaote(Date datarescisaote) {
		this.datarescisaote = datarescisaote;
	}
	public String getSituacaote() {
		return situacaote;
	}
	public void setSituacaote(String situacaote) {
		this.situacaote = situacaote;
	}
	public Integer getCargahorariate() {
		return cargahorariate;
	}
	public void setCargahorariate(Integer cargahorariate) {
		this.cargahorariate = cargahorariate;
	}
	public Float getValorbolsa() {
		return valorbolsa;
	}
	public void setValorbolsa(Float valorbolsa) {
		this.valorbolsa = valorbolsa;
	}
	public String getEnderecote() {
		return enderecote;
	}
	public void setEnderecote(String enderecote) {
		this.enderecote = enderecote;
	}
	public String getNumeroenderecote() {
		return numeroenderecote;
	}
	public void setNumeroenderecote(String numeroenderecote) {
		this.numeroenderecote = numeroenderecote;
	}
	public String getComplementoenderecote() {
		return complementoenderecote;
	}
	public void setComplementoenderecote(String complementoenderecote) {
		this.complementoenderecote = complementoenderecote;
	}
	public String getBairroenderecote() {
		return bairroenderecote;
	}
	public void setBairroenderecote(String bairroenderecote) {
		this.bairroenderecote = bairroenderecote;
	}
	public String getCependerecote() {
		return cependerecote;
	}
	public void setCependerecote(String cependerecote) {
		this.cependerecote = cependerecote;
	}
	public String getCidadeenderecote() {
		return cidadeenderecote;
	}
	public void setCidadeenderecote(String cidadeenderecote) {
		this.cidadeenderecote = cidadeenderecote;
	}
	public String getEstadoenderecote() {
		return estadoenderecote;
	}
	public void setEstadoenderecote(String estadoenderecote) {
		this.estadoenderecote = estadoenderecote;
	}
	public Integer getEestagioobrigatorio() {
		return estagioobrigatorio;
	}
	public void setEestagioobrigatorio(Integer eestagioobrigatorio) {
		this.estagioobrigatorio = eestagioobrigatorio;
	}
	public Long getIdprofessororientador() {
		return idprofessororientador;
	}
	public void setIdprofessororientador(Long idprofessororientador) {
		this.idprofessororientador = idprofessororientador;
	}
	public Long getIdaluno() {
		return idaluno;
	}
	public void setIdaluno(Long idaluno) {
		this.idaluno = idaluno;
	}
	public Long getIdconvenio() {
		return idconvenio;
	}
	public void setIdconvenio(Long idconvenio) {
		this.idconvenio = idconvenio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idte == null) ? 0 : idte.hashCode());
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
		TermoEstagio other = (TermoEstagio) obj;
		if (idte == null) {
			if (other.idte != null)
				return false;
		} else if (!idte.equals(other.idte))
			return false;
		return true;
	}
	
	
	
	
}
