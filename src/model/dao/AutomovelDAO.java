package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Automovel;

public class AutomovelDAO {

	public static void cadastrarAutomovelDAO(Automovel novoAutomovel) {
		String query = "INSERT INTO carro (modelo, ano, marca, placa) VALUES (?, ?, ? ,?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		
		try {
			pstmt.setString(1, novoAutomovel.getModelo());
			pstmt.setString(2, novoAutomovel.getAno());
			pstmt.setString(3, novoAutomovel.getMarca());
			pstmt.setString(4, novoAutomovel.getPlaca());
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys(); 
			if (resultado.next()) {
				novoAutomovel.setIdAutomovel(resultado.getInt(1));
			}
			
		} catch (SQLException erro){
			System.out.println("Erro ao executar a quarto do médoto cadastrarAutomovelDAO");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		
	}

	

}
