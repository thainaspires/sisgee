package br.cefetrj.sisgee.view.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import br.cefetrj.sisgee.control.ProfessorOrientadorServices;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.ProfessorOrientador;

public class ProfessorOrientadorTag extends SimpleTagSupport{
	private Long id;
	@Override
	public void doTag() throws JspException, IOException {
		List<ProfessorOrientador> lista = ProfessorOrientadorServices.listarProfessoresOrientadores();
		String retorno = "<select class='form-control' class='form-control' name='professor_orientador' id='professor_orientador'>"+
				"<option value=''>Escolha um professor</option>";
				for(ProfessorOrientador professor:lista){
				retorno += "<option value='"+ professor.getIdpo() +"' ";
				if(professor.getIdpo().equals(id)){
					retorno += " selected ";
				}
				retorno += ">"+professor.getNomepo()+"</option>";
				}
				retorno += "</select>";
				getJspContext().getOut().append(retorno);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
