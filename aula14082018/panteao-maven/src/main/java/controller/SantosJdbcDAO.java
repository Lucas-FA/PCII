package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Santos;

public class SantosJdbcDAO {
private Connection conn;
	
	public SantosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Santos s) throws SQLException {
		String sql = "insert into santos (nome, nacionalidade) values ('"+s.getNome()+"','"+s.getNacionalidade()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(Santos s) throws SQLException {
		String sql = "delete from santos where nome = '"+s.getNome()+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "delete from santos where id = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Santos s, int id) {
		String sql = "update santos set nome='"+s.getNome()+"',nacionalidade='"+s.getNacionalidade()+"' where id = '"+id+"';";
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
	
	public List<Santos> listar() {
		String sql = "select * from santos";
        System.out.println(sql);		
        List<Santos> santos = new ArrayList<Santos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String nacionalidade = rs.getString("nacionalidade");
				System.out.println("Id = "+id+", Nome = "+nome+", Nacionalidade = "+nacionalidade);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return santos;
	}
}
