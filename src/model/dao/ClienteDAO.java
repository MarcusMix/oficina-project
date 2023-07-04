package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Automovel;
import model.vo.Cliente;

public class ClienteDAO {

	public void cadastrarClienteDAO(Cliente novoCliente) {
		String query = "INSERT INTO cliente (rua, bairro, cep, estado) VALUES (?, ? ,?, ?)";
		System.out.println(query);
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		
		try {
			pstmt.setString(1, novoCliente.getRua());
			pstmt.setString(2, novoCliente.getBairro());
			pstmt.setString(3, novoCliente.getCep());
			pstmt.setString(4, novoCliente.getEstado());
//			pstmt.setInt(5, novoCliente.getPessoa().getIdpessoa());
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys(); 
			if (resultado.next()) {
				novoCliente.setIdCliente(resultado.getInt(1));
			}
			
		} catch (SQLException erro){
			System.out.println("Erro ao executar a quarto do médoto cadastrarClienteDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
	}

	public List<Cliente> consultarDAO(String nome, String cpf, String cidade) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection conexao = Banco.getConnection();
		String sql = null;
		
		//buscar todos
		if(nome.isBlank() && cpf.isBlank() && cidade.isBlank()) {
			sql = "SELECT * FROM cliente";
		}
		
		//buscar por nome
		if(!nome.isBlank() && cpf.isBlank() && cidade.isBlank()) {
			//TODO arrumar cpf (estado para testes)
			sql = "SELECT * FROM cliente WHERE estado LIKE '" + nome + "%'";
		}
		
		//buscar por cpf
		if(nome.isBlank() && !cpf.isBlank() && cidade.isBlank()) {
			sql = "SELECT * FROM cliente WHERE cpf LIKE '" + cpf + "%'";
		}
		
		//buscar por cidade
		if(nome.isBlank() && cpf.isBlank() && !cidade.isBlank()) {
			sql = "SELECT * FROM cliente WHERE cidade LIKE '" + cidade + "%'";
		}
		
		//buscar por nome e cpf
		if(!nome.isBlank() && !cpf.isBlank() && cidade.isBlank()) {
			sql = "SELECT * FROM cliente WHERE nome LIKE '" + nome + "%' AND cpf LIKE '" + cpf + "%'";
		}
		
		//buscar por nome e cidade
		if(!nome.isBlank() && cpf.isBlank() && !cidade.isBlank()) {
			sql = "SELECT * FROM cliente WHERE nome LIKE '" + nome + "%' AND cidade LIKE '" + cidade + "%'";
		}
		
		//buscar por cpf e cidade
		if(nome.isBlank() && !cpf.isBlank() && !cidade.isBlank()) {
			sql = "SELECT * FROM cliente WHERE cpf cidade '" + cidade + "%' AND cpf LIKE '" + cpf + "%'";
		}
		
		System.out.println(sql);
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Cliente clienteConsultado = converterDeResultSetParaEntidade(resultado);
				clientes.add(clienteConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar cliente pelo nome: " + e.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return clientes;
	}
	
	private Cliente converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Cliente clienteConsultado = new Cliente(); 
//		clienteConsultado.setNome(resultado.getString("nome"));
		clienteConsultado.setCep(resultado.getString("cep"));
		clienteConsultado.setEstado(resultado.getString("estado"));
		clienteConsultado.setBairro(resultado.getString("bairro"));
		return clienteConsultado;
	}

}
