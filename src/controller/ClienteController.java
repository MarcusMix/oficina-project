package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.AutomovelDAO;
import model.dao.ClienteDAO;
import model.dao.PessoaDAO;
import model.vo.Automovel;
import model.vo.Cliente;
import model.vo.Profissional;

public class ClienteController {
	
	public String verificarCamposObrigatorios(Cliente novoCliente) {
		String mensagemValidacao = "";
		if(novoCliente.getNome().isBlank()) {
			mensagemValidacao = "Cliente em branco! \n";
		}
		if(novoCliente.getCpf().isBlank()) {
			mensagemValidacao += "CPF em branco! \n"; 
		} 
		if(novoCliente.getTelefone().isBlank()) {
			mensagemValidacao += "Telefone em branco!\n";
		}
		if(novoCliente.getEmail().isBlank()) {
			mensagemValidacao += "E-mail em branco!\n";
		}
		if(novoCliente.getCpf().length() < 11) {
			mensagemValidacao += "Campo CPF não pode ter menos que onze caracteres!	\n";
		}
		if(novoCliente.getEmail().length() < 10) {
			mensagemValidacao += "Campo E-mail não pode ter menos que dez caracteres!\n";
		}
		if(novoCliente.getNome().length() < 2) {
			mensagemValidacao += "Campo Nome não pode ter menos que dois caracteres!\n";
		}
		if(novoCliente.getTelefone().length() < 11) {
			mensagemValidacao += "Campo Telefone não pode ter menos que onze caracteres!\n";
		}
		if(novoCliente.getRua().isBlank()) {
			mensagemValidacao += "Rua em branco! \n";
		}
		if(novoCliente.getEstado().isBlank()) {
			mensagemValidacao += "Estado em branco! \n";
		}  
		if(novoCliente.getBairro().isBlank()) {
			mensagemValidacao += "Bairro em branco! \n";
		}  
		if(novoCliente.getCep().isBlank()) {
			mensagemValidacao += "CEP em branco! \n";
		} 
		if(novoCliente.getBairro().length() < 3) {
			mensagemValidacao += "Bairro com menos de 3 caracteres! \n";
		} 
		if(novoCliente.getCep().length() < 9) {
			mensagemValidacao += "CEP não pode conter menos que 8 caracteres! \n";
		} 
		if(novoCliente.getRua().length() < 4) {
			mensagemValidacao += "Rua não pode conter menos que 4 caracteres! \n";
		} 
		
		return mensagemValidacao;
		
	}

	public void cadastrarCliente(Cliente novoCliente, Automovel novoAuto) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.cadastrarPessoaDAO(novoCliente);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cadastrarClienteDAO(novoCliente);
		
		AutomovelDAO autoDAO = new AutomovelDAO();
		autoDAO.cadastrarAutomovelDAO(novoAuto);
		
	}
	
	public List<Cliente> consultar(String nome, String cpf, String cidade) {
		List<Cliente> clienteBuscado = null;
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteBuscado = clienteDAO.consultarDAO(nome, cpf, cidade);
	}


	

	

	
	
}
