package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.cefetrj.sisgee.control.GerarRelatorioServices;

/**
 * Command para gerar o relatório consolidado
 * @author Thainá
 *
 */
public class GerarRelatorioCommand implements Command{

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dataInicial = req.getParameter("datainicio");
		String dataFinal = req.getParameter("datafim");
		String radioestagio = req.getParameter("radioestagio");
		String msg = "";
		
		if(dataInicial != null && dataInicial.length() != 0 && dataFinal != null && dataFinal.length() != 0 && dataInicial.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")
				 && dataFinal.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
			
			Date dataInicialFormatada = null;
			Date dataFinalFormatada = null;
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dataInicialFormatada = formato.parse(dataInicial);
				dataFinalFormatada = formato.parse(dataFinal);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        Date dataUtil = dataInicialFormatada;
	        Date dataUtil2 = dataFinalFormatada;
	        java.sql.Date dataSql = null;
	        java.sql.Date dataSql2 = null;
	        try {
	            dataUtil = new java.sql.Date(dataUtil.getTime());
	            dataUtil2 = new java.sql.Date(dataUtil2.getTime());
	            dataSql = (java.sql.Date) dataUtil;
	            dataSql2 = (java.sql.Date) dataUtil2;
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Erro ao converte data para sql: " + e.getMessage());
	        }
	        if (!(dataSql.after(dataSql2))){
	        	List<String> listas = GerarRelatorioServices.gerarRelatorio(dataSql, dataSql2, radioestagio);
	        	System.out.println("Valido");
	        }else{
	        	msg+="Data inicial deve ser antes da data final";
	        }
		}else{
			msg+="Datas precisam ser preenchidas";
		}
		
		if(msg != ""){
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/relatorio_consolidado.jsp").forward(req,resp);
		} else {
			req.getRequestDispatcher("/relatorio_consolidado.jsp").forward(req, resp);
		}
	}
}
