package controller;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.dao.PessoaDAO;
import model.vo.Pessoa;

public class PessoaController {

	public void cadastrarPessoa(Pessoa novaPessoa) {
		PessoaDAO pessoaDAO = new PessoaDAO();
//		pessoaDAO.cadastrarPessoaDAO(novaPessoa);
	}

	public String verificarCamposObrigatorios(Pessoa novaPessoa) {
		String mensagemValidacao = "";
		if(novaPessoa.getNome().isBlank()) {
			mensagemValidacao = "Cliente em branco! \n";
		}
		if(novaPessoa.getCpf().isBlank()) {
			mensagemValidacao += "CPF em branco! \n"; 
		} 
		if(novaPessoa.getTelefone().isBlank()) {
			mensagemValidacao += "Telefone em branco!\n";
		}
		if(novaPessoa.getEmail().isBlank()) {
			mensagemValidacao += "E-mail em branco!\n";
		}
		if(novaPessoa.getCpf().length() < 11) {
			mensagemValidacao += "Campo CPF não pode ter menos que onze caracteres!	\n";
		}
		if(novaPessoa.getEmail().length() < 10) {
			mensagemValidacao += "Campo E-mail não pode ter menos que dez caracteres!\n";
		}
		if(novaPessoa.getNome().length() < 2) {
			mensagemValidacao += "Campo Nome não pode ter menos que dois caracteres!\n";
		}
		if(novaPessoa.getTelefone().length() < 11) {
			mensagemValidacao += "Campo Telefone não pode ter menos que onze caracteres!\n";
		}
		return mensagemValidacao;
	}
}
