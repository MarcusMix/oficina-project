package controller;

import javax.swing.JOptionPane;

import model.dao.AutomovelDAO;
import model.vo.Automovel;

public class AutomovelController {

	public boolean verificarCamposObrigatorios(Automovel novoAutomovel) {
		
		if(novoAutomovel.getAno().isBlank()) {
			JOptionPane.showMessageDialog(null, "Ano em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoAutomovel.getMarca().isBlank()) {
			JOptionPane.showMessageDialog(null, "Marca em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (novoAutomovel.getModelo().isBlank()) {
			JOptionPane.showMessageDialog(null, "Modelo em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (novoAutomovel.getPlaca().isBlank()) {
			JOptionPane.showMessageDialog(null, "Placa em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public void cadastrarAutomovel(Automovel novoAutomovel) {
		AutomovelDAO.cadastrarAutomovelDAO(novoAutomovel);
		
	}

}
