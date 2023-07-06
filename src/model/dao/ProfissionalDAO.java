package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.vo.Profissional;

public class ProfissionalDAO {

	public void cadastrarProfissionalDAO(Profissional novoProfissional) {
		String query = "INSERT INTO profissional (idpessoa, funcao, dt_admissao) VALUES (?, ?, ?)";
		System.out.println(query);
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		
		if(novoProfissional.getPessoa().getIdpessoa() == null) {
			//todo chamar o pessoadao para inserir uma nova pessoa
			PessoaDAO dao = new PessoaDAO();
			dao.cadastrarPessoaDAO(novoProfissional.getPessoa());
		}
		try {
			//TODO preencher a coluna idPessoa
			pstmt.setString(1, novoProfissional.getPessoa().getIdpessoa());
			pstmt.setString(2, novoProfissional.getFuncao());
			pstmt.setString(3, LocalDate.now().toString());

			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys(); 
			if (resultado.next()) {
				novoProfissional.setIdProfissional(resultado.getInt(1));;
			}

		} catch (SQLException erro){
			System.out.println("Erro ao executar o método cadastrarProfissionalDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
	
		
	}

}
