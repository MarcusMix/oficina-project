package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Automovel;
import model.vo.Cliente;

public class ClienteDAO {

	public void cadastrarClienteDAO(Cliente novoCliente) {
		String query = "INSERT INTO cliente (rua, bairro, cep, estado) VALUES (?, ?, ? ,?)";
		System.out.println(query);
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		
		try {
			pstmt.setString(1, novoCliente.getRua());
			pstmt.setString(2, novoCliente.getBairro());
			pstmt.setString(3, novoCliente.getCep());
			pstmt.setString(4, novoCliente.getEstado());
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys(); 
			if (resultado.next()) {
				novoCliente.setIdpessoa(resultado.getInt(1));
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

}
