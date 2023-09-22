package jdbc.modelo;

import java.sql.Date;

public class Hospedes {
	private Integer Id;
	private String Nome;
	private String Sobrenome;
	private Date DataNascimento;
	private String Nacionalidade;
	private String Telefone;
	private Integer IdReserva;
	
	public Hospedes(String Nome, String Sobrenome, Date DataNascimento, String Nacionalidade, String Telefone,
					Integer idReserva) {
		super();
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.DataNascimento = DataNascimento;
		this.Nacionalidade = Nacionalidade;
		this.Telefone = Telefone;
		this.IdReserva = idReserva;
	}
	
	public Hospedes(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade,
					String telefone, Integer idReserva) {
		super();
		Id = id;
		this.Nome = nome;
		this.Sobrenome = sobrenome;
		this.DataNascimento = dataNascimento;
		this.Nacionalidade = nacionalidade;
		this.Telefone = telefone;
		this.IdReserva = idReserva;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.Sobrenome = sobrenome;
	}

	public String getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.Nacionalidade = nacionalidade;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.DataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}

	public Integer getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.IdReserva = idReserva;
	}
	
}