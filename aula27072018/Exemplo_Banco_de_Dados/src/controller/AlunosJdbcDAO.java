package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Alunos;

public class AlunosJdbcDAO {
	
	private Connection conn;
	
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into alunos (nome, endereco, bairro, cep) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCep()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
}
