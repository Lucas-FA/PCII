package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Criaturas;

public class CriaturasJdbcDAO {
    private Connection conn;
	
	public CriaturasJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Criaturas c) throws SQLException {
		String sql = "insert into criaturas (nome, endereco, bairro, cep) values ('"+c.getNome()+"','"+c.getOrigem()+"','"+c.getMoradia()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(Criaturas c) throws SQLException {
		String sql = "delete from criaturas where nome = '"+c.getNome()+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "delete from criaturas where id = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Criaturas c, int id) {
		String sql = "update criaturas set nome='"+c.getNome()+"',origem='"+c.getOrigem()+"',moradia='"+c.getMoradia()+"' where id = '"+id+"';";
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
	
	public List<Criaturas> listar() {
		String sql = "select * from criaturas";
        System.out.println(sql);		
        List<Criaturas> criaturas = new ArrayList<Criaturas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String origem = rs.getString("origem");
				String moradia = rs.getString("moradia");
				System.out.println("Id = "+id+", Nome = "+nome+", Origem = "+origem+", Moradia = "+moradia);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return criaturas;
	}
}
