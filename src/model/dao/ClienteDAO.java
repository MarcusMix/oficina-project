package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Automovel;
import model.vo.Cliente;

public class ClienteDAO {

	public static void cadastrarClienteDAO(Cliente novoCliente) {
		String query = "INSERT INTO clientes (nome, cpf, dataNascimento, email, telefone, "
				+ "rua, bairro, cep, estado) VALUES (?, ?, ? ,? ,? ,? ,? ,?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		
		try {
			pstmt.setString(1, novoCliente.getNome());
			pstmt.setString(2, novoCliente.getCpf());
			pstmt.setString(3, novoCliente.getDataNascimento());
			pstmt.setString(4, novoCliente.getEmail());
			pstmt.setString(5, novoCliente.getRua());
			pstmt.setString(6, novoCliente.getBairro());
			pstmt.setString(7, novoCliente.getCep());
			pstmt.setString(8, novoCliente.getEstado());
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys(); 
			if (resultado.next()) {
				novoCliente.setId(resultado.getInt(1));
			}
			
		} catch (SQLException erro){
			System.out.println("Erro ao executar a quarto do médoto cadastrarClienteDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
	}

}
