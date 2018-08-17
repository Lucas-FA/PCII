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
			//criaturasJdbcDao.deletar(2);
			//criaturasJdbcDao.listar();
			//criaturasJdbcDao.alterar(criaturas, 2);
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
			deuses.setAtributos("Rei dos Deuses, Deus do Céu, Trovão, Relâmpago, Lei, Ordem e Justiça");
			deuses.setMoradia("Monte Olimpo");

			//deusesJdbcDao.salvar(deuses);
			//deusesJdbcDao.deletar(1);
			//deusesJdbcDao.listar();
			//deusesJdbcDao.alterar(deuses, 1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Santos santos = new Santos();
		try {
			Connection connection = JdbUtil.getConnection();
			SantosJdbcDAO santosJdbcDao = new SantosJdbcDAO(connection);
			
			santos.setNome("Joana dArc");
			santos.setNacionalidade("Francesa");

			//santosJdbcDao.salvar(santos);
			//santosJdbcDao.deletar(1);
			//santosJdbcDao.listar();
			//santosJdbcDao.alterar(santos, 1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SemiDeuses semideuses = new SemiDeuses();
		try {
			Connection connection = JdbUtil.getConnection();
			SemiDeusesJdbcDAO semideusesJdbcDao = new SemiDeusesJdbcDAO(connection);
			
			semideuses.setNome("Árion");
			semideuses.setOrigem("Grega");
			semideuses.setMoradia("Desconhecida");
			semideuses.setResponsavel("Poseidon e Deméter");

			//semideusesJdbcDao.salvar(semideuses);
			//semideusesJdbcDao.deletar(1);
			//semideusesJdbcDao.listar();
			//semideusesJdbcDao.alterar(semideuses, 1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
