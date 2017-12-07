package br.cefetrj.sisgee.view.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import br.cefetrj.sisgee.control.AgenteIntegracaoServices;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;

/**
 * @author Thainá
 * Tag para buscar todos os agentes de Integracao e disponibilizá-los no combobox do jsp do termo de estágio
 * 
 */

public class AgenteIntegracaoTag extends SimpleTagSupport{
	private String nome; 
	@Override
	public void doTag() throws JspException, IOException {
		
		List<AgenteIntegracao> lista = AgenteIntegracaoServices.listarAgentesIntegracao();
		
		String retorno = "<select style='float:left;' id='razao_social' name='razao_social' class='form-control'>"+
							"<option value=''>Escolha um agente de integração</option>";
		for(AgenteIntegracao agente:lista){
			retorno += "<option value='"+ agente.getNomeAgenteIntegracao() +"' ";
			if(agente.getNomeAgenteIntegracao().equals(nome)){
				retorno += " selected ";
			}
			retorno += ">"+agente.getNomeAgenteIntegracao()+"</option>";
		}
		retorno += "</select>";
		getJspContext().getOut().append(retorno);

	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
		
}
