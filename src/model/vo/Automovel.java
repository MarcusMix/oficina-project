package model.vo;

public class Automovel {
	private Integer idAutomovel;
	private String modelo;
	private String ano;	
	private String marca;
	private String placa;
	
	public Automovel(Integer idAutomovel, String modelo, String ano, String marca, String placa) {
		super();
		this.idAutomovel = idAutomovel;
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
		this.placa = placa;
	}

	public Automovel() {
		super();
	}

	public Integer getIdAutomovel() {
		return idAutomovel;
	}

	public void setIdAutomovel(Integer idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
