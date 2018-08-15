package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {

	public static void main(String[] args) {
		Alunos alunos = new Alunos();
		try {
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			alunos.setNome("Zeus");
			alunos.setEndereco("Monte Olimpo, 0");
			alunos.setBairro("Jd. dos Deuses");
			alunos.setCep(01243213);

			//alunosJdbcDao.salvar(alunos);
			//alunosJdbcDao.deletar(alunos);
			//alunosJdbcDao.listar();
			//alunosJdbcDao.alterar(alunos, 5);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
