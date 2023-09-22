package jdbc.controller;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import jdb.factory.ConnectionFactory;
import jdbc.dao.HospedesDAO;
import jdbc.modelo.Hospedes;


public class HospedesController {
	 private HospedesDAO hospedesDAO;

	 public HospedesController() {
			Connection connection = new ConnectionFactory().recuperarConexao();
			this.hospedesDAO = new HospedesDAO(connection);
		}
	 
		public void salvar(Hospedes hospedes) {
			this.hospedesDAO.salvar(hospedes);
		}
		public List<Hospedes> listarHospedes() {
			return this.hospedesDAO.listarHospedes();
		}
		
		public List<Hospedes> listarHospedesId(String id) {
			return this.hospedesDAO.buscarId(id);
		}

	public void atualizar(String Nome, String Sobrenome, Date DataNascimento, String Nacionalidade, String Telefone, Integer IdReserva, Integer Id) {
		this.hospedesDAO.atualizar(Nome, Sobrenome, DataNascimento, Nacionalidade, Telefone, IdReserva, Id);
	}
		public void deletar(Integer id) {
			this.hospedesDAO.deletar(id);
		}
}