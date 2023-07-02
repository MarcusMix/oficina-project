package model.vo;

public class Profissional extends Pessoa {
	private int idProfissional;
	private Pessoa pessoa;
	private String funcao;
	private String dtAdimissao;

	public int getIdProfissional() {
		return idProfissional;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}


	public String getFuncao() {
		return funcao;
	}

	public Profissional() {
		super();
	}

	public Profissional(int idProfissional, Pessoa pessoa, String funcao, String dtAdimissao) {
		super();
		this.idProfissional = idProfissional;
		this.pessoa = pessoa;
		this.funcao = funcao;
		this.dtAdimissao = dtAdimissao;
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

	@Override
	public String toString() {
		return this.getNome() + " id: " + this.getIdProfissional() + "Função: " + this.getFuncao() + " Data Admissão: " + this.getDtAdimissao();
	}

}
