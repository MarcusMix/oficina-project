package model.vo;

public class Profissional extends Pessoa{
	private int idProfissional;
	private String funcao;
	private String dtAdimissao;

	public int getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}


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
