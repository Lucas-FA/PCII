package view;

import java.sql.Connection;

import controller.*;
import model.*;

public class Execucao {
	public static void main(String[] args) {
		Criaturas criaturas = new Criaturas();
		try {
			Connection connection = JdbUtil.getConnection();
			CriaturasJdbcDAO criaturasJdbcDao = new CriaturasJdbcDAO(connection);
			
			criaturas.setNome("Minotauro");
			criaturas.setOrigem("Grega");
			criaturas.setMoradia("Labirinto do Minotauro");

			//criaturasJdbcDao.salvar(criaturas);
			//criaturasJdbcDao.deletar(criaturas);
			//criaturasJdbcDao.listar();
			//criaturasJdbcDao.alterar(criaturas, 1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Deuses deuses = new Deuses();
		try {
			Connection connection = JdbUtil.getConnection();
			DeusesJdbcDAO deusesJdbcDao = new DeusesJdbcDAO(connection);
			
			deuses.setNome("Zeus");
			deuses.setOrigem("Grega");
			deuses.setAtributos("Raios");
			deuses.setMoradia("Monte Olimpo");

			//criaturasJdbcDao.salvar(deuses);
			//criaturasJdbcDao.deletar(deuses);
			//criaturasJdbcDao.listar();
			//criaturasJdbcDao.alterar(deuses, 1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
