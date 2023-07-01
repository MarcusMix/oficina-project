package controller;

import javax.swing.JOptionPane;

import model.dao.PessoaDAO;
import model.dao.ProfissionalDAO;
import model.vo.Pessoa;
import model.vo.Profissional;

public class ProfissionalController {

	public String validarDadosProfissional(Profissional novoProfissional) {
		String mensagemValidacao = "";
		if(novoProfissional.getFuncao().isBlank()) {
			mensagemValidacao += "Função inválida!";
		} 
		return mensagemValidacao;
	}

	public void cadastrarProfissional(Profissional novoProfissional) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.cadastrarPessoaDAO(novoProfissional);
		
		ProfissionalDAO profissionalDAO = new ProfissionalDAO();
		profissionalDAO.cadastrarProfissionalDAO(novoProfissional);
	}

	

}
