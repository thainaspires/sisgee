package br.cefetrj.sisgee.view.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AlunoServices;
import br.cefetrj.sisgee.model.entity.Convenio;

public class ValidarTermoEstagioCommand implements Command {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Convenio convenio = new Convenio();
		String numConvenio = null;
		String msg = null;
		if(numConvenio == null || numConvenio.trim().length() == 0){
			msg += "Número do convênio não pode ser null"; 
		}else{
			//convenio = ConvenioServices.BuscarConvenio(numConvenio);
		}
	}

}
