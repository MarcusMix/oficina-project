package controller;

import javax.swing.JOptionPane;

import model.dao.ClienteDAO;
import model.vo.Automovel;
import model.vo.Cliente;

public class ClienteController {
	
	public boolean verificarCamposObrigatorios(Cliente novoCliente) {
		
		if(novoCliente.getRua().isBlank()) {
			JOptionPane.showMessageDialog(null, "Rua em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getEstado().isBlank()) {
			JOptionPane.showMessageDialog(null, "Estado em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getBairro().isBlank()) {
			JOptionPane.showMessageDialog(null, "Bairro em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getCep().isBlank()) {
			JOptionPane.showMessageDialog(null, "CEP em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(novoCliente.getBairro().length() < 3) {
			JOptionPane.showMessageDialog(null, "Campo Bairro não pode ter menos que três caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(novoCliente.getCep().length() < 9) {
			JOptionPane.showMessageDialog(null, "Campo Cep não pode ter menos que oito caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
//		else if(novoCliente.getCpf().length() < 14) {
//			JOptionPane.showMessageDialog(null, "Campo CPF não pode ter menos que onze caracteres!", 
//					"Erro", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}else if(novoCliente.getEmail().length() < 10) {
//			JOptionPane.showMessageDialog(null, "Campo E-mail não pode ter menos que dez caracteres!", 
//					"Erro", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}
		
//		else if(novoCliente.getNome().length() < 2) {
//			JOptionPane.showMessageDialog(null, "Campo Nome não pode ter menos que dois caracteres!", 
//					"Erro", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}else if(novoCliente.getTelefone().length() < 11) {
//			JOptionPane.showMessageDialog(null, "Campo Telefone não pode ter menos que onze caracteres!", 
//					"Erro", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}else if(novoCliente.getDtNascimento().length() < 11) {
//			JOptionPane.showMessageDialog(null, "Campo Data de Nascimento não pode ter menos que onze caracteres!", 
//					"Erro", JOptionPane.ERROR_MESSAGE);
//			return false;
		
		else if(novoCliente.getRua().length() < 4) {
			JOptionPane.showMessageDialog(null, "Campo Rua não pode ter menos que quatro caracteres!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
		
	}

	public void cadastrarCliente(Cliente novoCliente) {
		ClienteDAO.cadastrarClienteDAO(novoCliente);
		
	}

	

	
	
}
