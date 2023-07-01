package controller;

import javax.swing.JOptionPane;

import model.dao.ProfissionalDAO;
import model.vo.Pessoa;
import model.vo.Profissional;

public class ProfissionalController {

	public String validarDadosProfissional(Profissional novoProfissional) {
		//TODO
		if(novoProfissional.getFuncao().isBlank()) {
			JOptionPane.showMessageDialog(null, "Campo função é obrigatório!", 
					"Erro", JOptionPane.ERROR);
		} else {
			ProfissionalDAO profissionalDAO = new ProfissionalDAO();
//			profissionalDAO.cadastrarProfissional(novoProfissional);
		}
		return null;
	}

}
