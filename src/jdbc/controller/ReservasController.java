package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import jdb.factory.ConnectionFactory;
import jdbc.dao.ReservasDAO;
import jdbc.modelo.Reservas;

public class ReservasController {
 private ReservasDAO reservasDAO;
 
 public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.reservasDAO = new ReservasDAO(connection);
	}
 
	public void salvar(Reservas reservas) {
		this.reservasDAO.salvar(reservas);
	}
		
	public List<Reservas> buscar() {
		return this.reservasDAO.buscar();
	}
	
	public List<Reservas> buscarId(String id) {
		return this.reservasDAO.buscarId(id);
	}
	
	public void atualizar(Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento, Integer id) {
		this.reservasDAO.atualizar(DataEntrada, DataSaida, Valor, FormaPagamento, id);
	}
	
	public void deletar(Integer id) {
		this.reservasDAO.deletar(id);
	}
}