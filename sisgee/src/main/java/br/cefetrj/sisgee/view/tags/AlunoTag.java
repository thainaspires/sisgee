package br.cefetrj.sisgee.view.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.model.entity.Aluno;

public class AlunoTag extends SimpleTagSupport{
	private String matricula;
	@Override
	public void doTag() throws JspException, IOException {
		String msg;
		getJspContext().getOut().append("chamou a matricula: "+matricula);
		List<Aluno> aluno = AlunoServices.buscarDetermAluno(matricula);
		
		/*JspWriter out = pageContext.getOut();
		out.print(dateFormatter.format(today));
		JspWriter out = getJspContext().getOut();
	    out.println(aluno.get(0).getPessoa());*/
			
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
