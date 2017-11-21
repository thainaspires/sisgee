package br.cefetrj.sisgee.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	@Column(columnDefinition="integer")
	private Long idte;
	@Column(columnDefinition="date", nullable = false)
	private Date datainiciote;
	@Column(columnDefinition="date")
	private Date datafimte;
	@Column(columnDefinition="date")
	private Date datarescisaote;
	@Column(columnDefinition="integer", nullable = false)
	private Integer cargahorariate;
	@Column(columnDefinition="float", nullable = false)
	private Float valorbolsa;
	@Column(columnDefinition="VARCHAR(255)", nullable = false)
	private String enderecote;
	@Column(columnDefinition="VARCHAR(10)", nullable = false)
	private String numeroenderecote;
	@Column(columnDefinition="VARCHAR(150)", nullable = false)
	private String complementoenderecote;
	@Column(columnDefinition="VARCHAR(150)", nullable = false)
	private String bairroenderecote;
	@Column(columnDefinition="VARCHAR(15)", nullable = false)
	private String cependerecote;
	@Column(columnDefinition="VARCHAR(150)", nullable = false)
	private String cidadeenderecote;
	@Column(columnDefinition="CHAR(2)", nullable = false)
	private String estadoenderecote;
	@Column(columnDefinition="integer", nullable = false)
	private Integer estagioobrigatorio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Convenio convenio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Aluno aluno;
	
	@OneToMany(mappedBy="termoEstagio")
	private List<TermoAditivo> termosAditivos;
	
	@OneToMany(mappedBy="termoestagio")
	private List<ProfessorOrientador> professoresOrientadores;
	
	public Aluno getAluno(){
		return aluno;
	}
	public Long getIdte() {
		return idte;
	}
	public void setIdte(Long idte) {
		this.idte = idte;
	}
	public List<TermoAditivo> getTermosAditivos(){
		return termosAditivos;
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
	@Override
	public String toString() {
		return idte.toString();
	}
	
	
}
