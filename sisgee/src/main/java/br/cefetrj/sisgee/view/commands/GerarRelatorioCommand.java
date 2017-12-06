package br.cefetrj.sisgee.view.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.cefetrj.sisgee.control.GerarRelatorioServices;
import br.cefetrj.sisgee.model.entity.TermoEstagio;

/**
 * Command para gerar o relat�rio consolidado e realizar a validação dos dados
 * @author Thain�
 *
 */
public class GerarRelatorioCommand implements Command{

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dataInicial = req.getParameter("datainicio");
		String dataFinal = req.getParameter("datafim");
		String radioestagio = req.getParameter("radioestagio");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicialFormatada = null;
		Date dataFinalFormatada = null;
		String msg = "";
		
		//Se as datas n�o forem vazias e estiverem no formato correto
		if(dataInicial != null && dataInicial.length() != 0 && dataFinal != null && dataFinal.length() != 0 && 
		dataInicial.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d") && dataFinal.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")){
			
			//Transformando as datas para Date em sql
			try {
				dataInicialFormatada = formato.parse(dataInicial);
				dataFinalFormatada = formato.parse(dataFinal);
			} catch (ParseException e) {
				/**TODO: **/
			}
			
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
	            /**TODO: **/
	        }
	        
	        //Se a data inicial n�o depois da final
	        if (!(dataSql.after(dataSql2))){
	        	//Recupera a lista com a consulta do relat�rio
	        	List<Object[]> lista = GerarRelatorioServices.gerarRelatorio(dataSql, dataSql2, radioestagio);
	        	req.setAttribute("listaRelatorio", lista);
	        	//Se a lista for v�zia, n�o h� resultados para estas datas e seta a mensagem de erro
	        	if (lista.isEmpty()){
	        		req.setAttribute("msg2", "A consulta n�o retornou resultados");
	        	}
	        //Se a data inicial for depois da final, mensagem de erro
	        }else{
	        	msg+="Data inicial deve ser antes da data final";
	        }
	    //Se alguma data n�o tiver sido preenchida ou n�o estiver no formato correto
		}else{
			if (!(dataInicial != null && dataInicial.length() != 0)){
				msg+="Data de inicio precisa ser preenchida";
			}
			if (!(dataFinal != null && dataFinal.length() != 0)){
				msg+="Data final precisa ser preenchida";
			}
		
		}
		
		if(msg != ""){
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/relatorio_consolidado.jsp").forward(req,resp);
		} else {
			req.getRequestDispatcher("/relatorio_consolidado.jsp").forward(req, resp);
		}
	}
}
