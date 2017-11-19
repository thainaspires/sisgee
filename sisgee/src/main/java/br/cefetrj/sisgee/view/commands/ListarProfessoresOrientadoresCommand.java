package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.sisgee.control.ProfessorOrientadorServices;
import br.cefetrj.sisgee.model.entity.ProfessorOrientador;

/** 
 * Recupera a lista de professores orientadores
 * @author Thainá Pires
 *
 */

public class ListarProfessoresOrientadoresCommand implements Command{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProfessorOrientador> professoresOrientadores = ProfessorOrientadorServices.listarProfessoresOrientadores();
		request.setAttribute("professoresOrientadores", professoresOrientadores);
	}

}
