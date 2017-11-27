package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.ConvenioServices;
import br.cefetrj.sisgee.control.EmpresaServices;
import br.cefetrj.sisgee.model.entity.Aluno;
import br.cefetrj.sisgee.model.entity.Convenio;
import br.cefetrj.sisgee.model.entity.Empresa;

public class ValidarTermoEstagioCommand implements Command {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eagente = req.getParameter("exampleRadios");
		String cnpj_empresa = req.getParameter("cnpj_empresa");
		String nome_empresa = req.getParameter("razao_social_empresa");
		String cnpj_empresa_ligada = req.getParameter("cnpj_empresa_ligada");
		String nome_agente = req.getParameter("razao_social");
		String numConvenio = req.getParameter("numero_convenio");
		String msg = null;
		System.out.println(cnpj_empresa);
		
		if(numConvenio == null || numConvenio.trim().length() == 0){
			msg += "Número do convênio não pode ser null"; 
		}else{
			List<Convenio> resultconvenio = ConvenioServices.buscarConvenio(numConvenio);
			Convenio convenio = new Convenio();
			if(!(resultconvenio.isEmpty())){
				convenio = resultconvenio.get(0); 
			}
			Empresa empresa = new Empresa();
			if(eagente.equals("sim")){
				System.out.println(cnpj_empresa_ligada);
				System.out.println(nome_agente);
				List<Empresa> resultempresa = EmpresaServices.buscarEmpresaLigadaAI(cnpj_empresa_ligada, nome_agente);
				if(!(resultempresa.isEmpty())){
					empresa = resultempresa.get(0);
				} else {
					msg += "Agente de integração não está ligado à esta empresa";
				}
			} else {
				System.out.println("VAI PORAAAA ");
				List<Empresa> resultempresa = EmpresaServices.buscarEmpresa(cnpj_empresa);
				if(!(resultempresa.isEmpty())){
					empresa = resultempresa.get(0);
					System.out.println("EMPRESINHA> "+empresa.getCnpjEmpresa());
				} else {
					msg += "Empresa não encontrada";
				}
			}
			System.out.println(msg);
			System.out.println(resultconvenio.isEmpty());
			System.out.println(resultconvenio.isEmpty() && msg.equals(""));
			if(true){
				//Criar convenio
				System.out.println("ENTROU EM CONVENIO");
				Convenio convincluido = new Convenio();
				convincluido.setNumeroConvenio(numConvenio);
				convincluido.setEmpresa(empresa);
				ConvenioServices.registrarConvenio(convincluido);
				msg += "Convênio cadastrado: Número: "+numConvenio+" Empresa: "+empresa;
			} else {
				/*if(convenio.getEmpresa().getIdEmpresa() == null || convenio.getEmpresa().getIdEmpresa() != empresa.getIdEmpresa()){
					// Mostrar erro
					msg += "Este convênio já existe";
				}*/
				System.out.println("OIEEE");
			}
				
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);

	}

}
