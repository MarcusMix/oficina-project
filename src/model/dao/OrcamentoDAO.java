package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Orcamento;
import model.vo.Pessoa;
import model.vo.Profissional;

public class OrcamentoDAO {

	public void cadastrarOrcamentoDAO(Orcamento orcamento) {
		String query = "INSERT INTO orcamento (tempo_manutencao, pecas, valor_trabalho, valor_total, situacao) VALUES (?, ?, ? ,? ,?)";
		System.out.println(query);
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		
		try {
			pstmt.setString(1, orcamento.getTempoManutencao());
			pstmt.setString(2, orcamento.getPecas());
			pstmt.setString(3, orcamento.getValorTrabalho());
			pstmt.setString(4, orcamento.getValorTotal());
			pstmt.setString(5, orcamento.getSituacao());

			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys(); 
			if (resultado.next()) {
				orcamento.setIdOrcamento(resultado.getInt(1));;
			}

		} catch (SQLException erro){
			System.out.println("Erro ao executar a quarto do método cadastrarOrcamentoDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		
	}

	public List<Profissional> pegarProfissionaisDAO() {
		List<Profissional> profissionais = new ArrayList<Profissional>();
		Connection conn = Banco.getConnection();
		String query = "SELECT * FROM profissional";
		
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		
		try {
			ResultSet resultado = pstmt.executeQuery(); 
			
			while(resultado.next()) {
				Profissional profissionalBuscado = montarProfissionalComResultadoDoBanco(resultado);
				profissionais.add(profissionalBuscado);
			}

		} catch (SQLException erro){
			System.out.println("Erro ao executar a quarto do método pegarProfissionaisDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		
		return profissionais;
		
	}

	private Profissional montarProfissionalComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Profissional profissionalBuscado = new Profissional();
		profissionalBuscado.setIdProfissional(resultado.getInt("idprofissional"));
//		profissionalBuscado.setPessoa(resultado.getString("nome"));
		profissionalBuscado.setFuncao(resultado.getString("funcao"));

//		Pessoa pessoa = new Pessoa();
		
		
		return profissionalBuscado;
	}

}
