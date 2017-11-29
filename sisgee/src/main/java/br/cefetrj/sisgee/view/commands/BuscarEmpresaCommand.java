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

public class BuscarEmpresaCommand  implements Command {
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String cnpj_empresa = req.getParameter("cnpj_empresa");
			String msg = "";
			if (cnpj_empresa != null && cnpj_empresa.trim().length() > 0){
				List<Empresa> empresa = null;
				empresa = EmpresaServices.buscarEmpresa(cnpj_empresa);
				if(empresa.isEmpty()){
					msg += "Empresa não encontrada";
				} else {
					Empresa empresaBuscada = empresa.get(0);
					req.setAttribute("empresa", empresaBuscada);
				}
			} else {
				msg += "Digite um CNPJ antes de buscar";
			}
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/termoestagio.jsp").forward(req, resp);
	}
}
