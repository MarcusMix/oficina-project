package controller;

import javax.swing.JOptionPane;

import model.dao.PessoaDAO;
import model.vo.Pessoa;

public class PessoaController {

	public void cadastrarPessoa(Pessoa novaPessoa) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.cadastrarPessoaDAO(novaPessoa);

	}

	public boolean verificarCamposObrigatorios(Pessoa novaPessoa) {
		if(novaPessoa.getNome().isBlank()) {
			JOptionPane.showMessageDialog(null, "Cliente em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novaPessoa.getCpf().isBlank()) {
			JOptionPane.showMessageDialog(null, "CPF em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novaPessoa.getDtNascimento().isBlank()) {
			JOptionPane.showMessageDialog(null, "Data de Nascimento em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novaPessoa.getTelefone().isBlank()) {
			JOptionPane.showMessageDialog(null, "Telefone em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novaPessoa.getEmail().isBlank()) {
			JOptionPane.showMessageDialog(null, "E-mail em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(novaPessoa.getCpf().length() < 11) {
			JOptionPane.showMessageDialog(null, "Campo CPF não pode ter menos que onze caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(novaPessoa.getEmail().length() < 10) {
			JOptionPane.showMessageDialog(null, "Campo E-mail não pode ter menos que dez caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(novaPessoa.getNome().length() < 2) {
			JOptionPane.showMessageDialog(null, "Campo Nome não pode ter menos que dois caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(novaPessoa.getTelefone().length() < 11) {
			JOptionPane.showMessageDialog(null, "Campo Telefone não pode ter menos que onze caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(novaPessoa.getDtNascimento().length() < 10) {
			JOptionPane.showMessageDialog(null, "Campo Data de Nascimento não pode ter menos que dez caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;

		}
		return true;
	}
}
