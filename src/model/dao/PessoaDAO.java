package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Pessoa;

public class PessoaDAO {

	public void cadastrarPessoaDAO(Pessoa novaPessoa) {
		String query = "INSERT INTO pessoa (nome, cpf, dt_nascimento, telefone,"
				+ " email ) VALUES (?, ?, ? ,? ,?)";
		System.out.println(query);
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);

		try {
			pstmt.setString(1, novaPessoa.getNome());
			pstmt.setString(2, novaPessoa.getCpf());
			pstmt.setString(3, novaPessoa.getDtNascimento());
			pstmt.setString(4, novaPessoa.getTelefone());
			pstmt.setString(5, novaPessoa.getEmail());

			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys(); 
			if (resultado.next()) {
				novaPessoa.setIdpessoa(resultado.getInt(1));
			}

		} catch (SQLException erro){
			System.out.println("Erro ao executar a quarto do médoto cadastrarPessoaDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
	}

}


