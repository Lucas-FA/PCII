package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Deuses;

public class DeusesJdbcDAO {
private Connection conn;
	
	public DeusesJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Deuses d) throws SQLException {
		String sql = "insert into deuses (nome, origem, atributos, moradia) values ('"+d.getNome()+"','"+d.getOrigem()+"','"+d.getMoradia()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(Deuses d) throws SQLException {
		String sql = "delete from deuses where nome = '"+d.getNome()+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "delete from deuses where id = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Deuses d, int id) {
		String sql = "update deuses set nome='"+d.getNome()+"',origem='"+d.getOrigem()+"',atributos='"+d.getAtributos()+"',moradia='"+d.getMoradia()+"' where id = '"+id+"';";
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
	
	public List<Deuses> listar() {
		String sql = "select * from deuses";
        System.out.println(sql);		
        List<Deuses> deuses = new ArrayList<Deuses>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String origem = rs.getString("origem");
				String atributos = rs.getString("atributos");
				String moradia = rs.getString("moradia");
				System.out.println("Id = "+id+", Nome = "+nome+", Origem = "+origem+", Atributos = "+atributos+", Moradia = "+moradia);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deuses;
	}
}
