package controller;

import javax.swing.JOptionPane;

import model.vo.Cliente;

public class ClienteController {
	
	public static boolean verificarCamposObrigatorios(Cliente novoCliente) {
		if(novoCliente.getNome().isBlank()) {
			JOptionPane.showMessageDialog(null, "Cliente em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getCpf().isBlank()) {
			JOptionPane.showMessageDialog(null, "CPF em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getDataNascimento().isBlank()) {
			JOptionPane.showMessageDialog(null, "Data de Nascimento em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getTelefone().isBlank()) {
			JOptionPane.showMessageDialog(null, "Telefone em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getEmail().isBlank()) {
			JOptionPane.showMessageDialog(null, "E-mail em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(novoCliente.getRua().isBlank()) {
			JOptionPane.showMessageDialog(null, "Rua em branco!", 
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
		} else if(novoCliente.getEstado().isBlank()) {
			JOptionPane.showMessageDialog(null, "Estado em branco!", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	public static void cadastrarCliente(Cliente novoCliente) {
		
		
	}

	

	
	
}
