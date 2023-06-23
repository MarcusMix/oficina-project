package model.vo;

import java.time.LocalDate;

public class Cliente extends Pessoa{
	
	private Integer idCliente;
	private String rua;
	private String bairro;
	private String cep;
	private String estado;
	
	public Cliente() {
		super();
	}
	
	public Cliente(int idpessoa, String nome, String cpf, String dtNascimento, String telefone, String email) {
		super(idpessoa, nome, cpf, dtNascimento, telefone, email);
		
	}
	
	public Cliente(Integer idCliente, String rua, String bairro, String cep, String estado) {
		super();
		this.idCliente = idCliente;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
