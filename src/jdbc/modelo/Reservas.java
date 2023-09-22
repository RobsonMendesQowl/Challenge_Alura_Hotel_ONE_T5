package jdbc.modelo;

import java.sql.Date;

public class Reservas {
	
	private Integer Id;
	private Date DataEntrada;
	private Date DataSaida;
	private String Valor;
	private String FormaPagamento;
	
	public Reservas(Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento) {
		super();		
		this.DataEntrada = DataEntrada;
		this.DataSaida = DataSaida;
		this.Valor = Valor;
		this.FormaPagamento = FormaPagamento;
	}
		
	public Reservas(Integer Id, Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento) {
		this.Id = Id;
		this.DataEntrada = DataEntrada;
		this.DataSaida = DataSaida;
		this.Valor = Valor;
		this.FormaPagamento = FormaPagamento;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Date getDataEntrada() {
		return DataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		DataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return DataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		DataSaida = dataSaida;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getFormaPagamento() {
		return FormaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		FormaPagamento = formaPagamento;
	}

	
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return String.format("La reserva generada fue: %d, %s, %s, %s, %s", this.id, this.fechaE, this.fechaS, this.valor, this.formaPago);
//	}
//	
	
	
}