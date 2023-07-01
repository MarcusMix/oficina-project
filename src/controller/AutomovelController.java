package controller;

import javax.swing.JOptionPane;

import model.dao.AutomovelDAO;
import model.vo.Automovel;

public class AutomovelController {

	public String verificarCamposObrigatorios(Automovel novoAutomovel) {
		String mensagemValidacao = "";
		if(novoAutomovel.getAno().isBlank()) {
			mensagemValidacao = "Ano em branco! \n";
		} 
		if(novoAutomovel.getMarca().isBlank()) {
			mensagemValidacao = "Marca em branco! \n";
		} 
		if (novoAutomovel.getModelo().isBlank()) {
			mensagemValidacao = "Modelo em branco! \n";
		} 
		if (novoAutomovel.getPlaca().isBlank()) {
			mensagemValidacao = "Placa em branco! \n";
		}
		return mensagemValidacao;
	}

	public void cadastrarAutomovel(Automovel novoAutomovel) {
		AutomovelDAO autoDAO = new AutomovelDAO();
		autoDAO.cadastrarAutomovelDAO(novoAutomovel);
	}

}
