package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.modelo.Reservas;

public class ReservasDAO {
	
	private Connection connection;
	
	public ReservasDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Reservas reservas) {
		try {
			String sql = "INSERT INTO reservas (dataEntrada, dataSaida, valor, formaPagamento) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setDate(1, reservas.getDataEntrada());
				pstm.setDate(2, reservas.getDataSaida());
				pstm.setString(3, reservas.getValor());
				pstm.setString(4, reservas.getFormaPagamento());

				pstm.executeUpdate();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						reservas.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<Reservas> buscar() {
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {
			String sql = "SELECT id, dataEntrada, dataSaida, valor, formaPagamento FROM reservas";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEmReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reservas> buscarId(String Id) {
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {

			String sql = "SELECT Id, DataEntrada, DataSaida, Valor, FormaPagamento FROM reservas WHERE Id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, Id);
				pstm.execute();

				transformarResultSetEmReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer Id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE Id = ?")) {
			stm.setInt(1, Id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento, Integer Id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE reservas SET DataEntrada = ?, DataSaida = ?, Valor = ?, FormaPagamento = ? WHERE Id = ?")) {
			stm.setDate(1, DataEntrada);
			stm.setDate(2, DataSaida);
			stm.setString(3, Valor);
			stm.setString(4, FormaPagamento);
			stm.setInt(5, Id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

						
	private void transformarResultSetEmReserva(List<Reservas> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reservas reserva = new Reservas(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

				reservas.add(reserva);
			}
		}
	}
}