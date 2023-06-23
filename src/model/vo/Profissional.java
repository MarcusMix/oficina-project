package model.vo;

public class Profissional extends Pessoa{
	private String funcao;
	private String dtAdimissao;
	
	public Profissional() {
		super();
	}
	
	public Profissional(String funcao, String dtAdimissao) {
		super();
		this.funcao = funcao;
		this.dtAdimissao = dtAdimissao;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getDtAdimissao() {
		return dtAdimissao;
	}
	
	public void setDtAdimissao(String dtAdimissao) {
		this.dtAdimissao = dtAdimissao;
	}
	

	
}
