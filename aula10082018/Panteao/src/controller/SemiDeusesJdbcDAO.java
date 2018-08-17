package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SemiDeuses;

public class SemiDeusesJdbcDAO {
    private Connection conn;
	
	public SemiDeusesJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(SemiDeuses sd) throws SQLException {
		String sql = "insert into semideuses (nome, origem, moradia, responsavel) values ('"+sd.getNome()+"','"+sd.getOrigem()+"','"+sd.getMoradia()+"','"+sd.getResponsavel()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(SemiDeuses sd) throws SQLException {
		String sql = "delete from semideuses where nome = '"+sd.getNome()+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "delete from semideuses where id = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(SemiDeuses sd, int id) {
		String sql = "update semideuses set nome='"+sd.getNome()+"',origem='"+sd.getOrigem()+"',moradia='"+sd.getMoradia()+"',responsavel='"+sd.getResponsavel()+"' where id = '"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<SemiDeuses> listar() {
		String sql = "select * from semideuses";
        System.out.println(sql);		
        List<SemiDeuses> semiDeuses = new ArrayList<SemiDeuses>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String origem = rs.getString("origem");
				String moradia = rs.getString("moradia");
				String responsavel = rs.getString("responsavel");
				System.out.println("Id = "+id+", Nome = "+nome+", Origem = "+origem+", Moradia = "+moradia+", Responsável = "+responsavel);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return semiDeuses;
	}
}
