package br.cefetrj.sisgee.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.view.commands.BuscarAlunoCommand;
import br.cefetrj.sisgee.view.commands.BuscarEmpresaCommand;
import br.cefetrj.sisgee.view.commands.BuscarEmpresaLigadaAICommand;
import br.cefetrj.sisgee.view.commands.BuscarTermoCommand;
import br.cefetrj.sisgee.view.commands.CadastrarEmpresaCommand;
import br.cefetrj.sisgee.view.commands.Command;
import br.cefetrj.sisgee.view.commands.GerarRelatorioCommand;
import br.cefetrj.sisgee.view.commands.IncluirTermoEstagioCommand;
import br.cefetrj.sisgee.view.commands.ListarTermosAditivosCommand;
import br.cefetrj.sisgee.view.commands.ValidarRegistroRescisaoCommand;
import br.cefetrj.sisgee.view.commands.ValidarTermoEstagioCommand;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Map<String, Command> comandos = new HashMap<String, Command>();
	
	static{
		comandos.put("IncluirTermoEstagio", new IncluirTermoEstagioCommand());
		comandos.put("CadastrarEmpresa", new CadastrarEmpresaCommand());
		comandos.put("GerarRelatorio", new GerarRelatorioCommand());
		comandos.put("BuscarAluno", new BuscarAlunoCommand());
		comandos.put("BuscarEmpresa", new BuscarEmpresaCommand());
		comandos.put("BuscarEmpresaLigada", new BuscarEmpresaLigadaAICommand());
		comandos.put("ValidarTermoEstagio", new ValidarTermoEstagioCommand());
		comandos.put("ValidarRescisao", new ValidarRegistroRescisaoCommand());
		comandos.put("ListarTermosAditivos", new ListarTermosAditivosCommand());
		comandos.put("BuscarTermo", new BuscarTermoCommand());

	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			String action = req.getParameter("action");
			comandos.get(action).execute(req, resp);
		} catch(Exception e){
			System.out.println(e);
			req.getRequestDispatcher("/erro.jsp").forward(req, resp);
		}
	}

}
