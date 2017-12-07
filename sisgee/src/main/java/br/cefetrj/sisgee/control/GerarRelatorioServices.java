package br.cefetrj.sisgee.control;

import java.sql.Date;
import java.util.List;

import br.cefetrj.sisgee.model.dao.RelatorioDAO;
import br.cefetrj.sisgee.model.entity.TermoEstagio;

/**
 * Trata serviços relacionados ao relatório
 * @author Thainá
 */
public class GerarRelatorioServices {

	public static List<Object[]> gerarRelatorio (Date dataInicial, Date dataFinal, String estagioObr){
		return RelatorioDAO.relatorioTermos(dataInicial, dataFinal, estagioObr);
	}
}
