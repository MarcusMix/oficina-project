package controller;

import java.util.ArrayList;
import java.util.List;

import model.dao.OrcamentoDAO;
import model.vo.Orcamento;
import model.vo.Profissional;

public class OrcamentoController {
	OrcamentoDAO orcamentoDAO = new OrcamentoDAO();

	public String verificarCamposObrigatorios(Orcamento orcamento) {
		String mensagemValidacao = "";
		
		if(orcamento.getSituacao().isBlank()) {
			mensagemValidacao = "Situação em branco! \n";
		}
		if(orcamento.getTempoManutencao().isBlank()) {
			mensagemValidacao = "Tempo de manutenção em branco! \n";
		}
		if(orcamento.getValorTotal().isBlank()) {
			mensagemValidacao = "Valor total em branco! \n";
		}
		if(orcamento.getValorTrabalho().isBlank()) {
			mensagemValidacao = "Valor da mão de obra em branco! \n";
		}
		return mensagemValidacao;
	}

	public void cadastrarOrcamento(Orcamento orcamento) {
		orcamentoDAO.cadastrarOrcamentoDAO(orcamento);
		
	}

	public ArrayList<Profissional> pegarProfissionais() {
		return (ArrayList<Profissional>) orcamentoDAO.pegarProfissionaisDAO();
	}

}
