package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.AgenteIntegracaoServices;
import br.cefetrj.sisgee.control.EmpresaServices;
import br.cefetrj.sisgee.control.ProfessorOrientadorServices;
import br.cefetrj.sisgee.model.entity.AgenteIntegracao;
import br.cefetrj.sisgee.model.entity.Empresa;
import br.cefetrj.sisgee.model.entity.ProfessorOrientador;
/**
 * @author Nathalia Gomes
 * Classe para validação da busca de Empresa ligada a agente de integração
 *  
 */
public class BuscarEmpresaLigadaAICommand implements Command {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cnpj_empresa_ligada = req.getParameter("cnpj_empresa_ligada");
		String ai = req.getParameter("razao_social");
		String msg = "";
		if (cnpj_empresa_ligada != null && cnpj_empresa_ligada.trim().length() > 0){
			try {
				Double cnpj_empresA = Double.parseDouble(cnpj_empresa_ligada);
				if(cnpj_empresa_ligada.trim().length() < 14){
					msg+="Cnpj pequeno, o CNPJ precisa ter 14 caracteres";
				}else if(cnpj_empresa_ligada.trim().length() > 14){
					msg+="Cnpj grande, o CNPJ precisa ter 14 caracteres";
				}else{
					List<Empresa> empresa = null;
					empresa = EmpresaServices.buscarEmpresaLigadaAI(cnpj_empresa_ligada, ai);
					if(empresa.isEmpty()){
						msg += "Empresa n�o encontrada ou n�o est� ligada ao agente de integra��o";
					} else {
						Empresa empresaLigadaAIBuscada = empresa.get(0);
						req.setAttribute("empresaligada", empresaLigadaAIBuscada);
					}
				}
			}catch (Exception e) {
				msg += "Cnpj precisa ser composto somente de n�meros";
			}	
		} else {
			msg += "Digite um CNPJ antes de buscar";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	}
}
