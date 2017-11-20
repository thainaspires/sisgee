package br.cefetrj.sisgee.control;

import java.sql.Date;
import java.util.List;

import br.cefetrj.sisgee.model.dao.GerarRelatorioDAO;

public class GerarRelatorioServices {

	public static List<String> gerarRelatorio (Date dataInicial, Date dataFinal, String estagioObr){
		return GerarRelatorioDAO.relatorioTermos(dataInicial, dataFinal, estagioObr);
	}
}
