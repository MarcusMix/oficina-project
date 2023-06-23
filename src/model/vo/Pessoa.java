package model.vo;

public class Pessoa {
	private int idpessoa;
    private String nome;
    private String cpf;
    private String dtNascimento;
    private String telefone;
    private String email;
    
	public Pessoa() {
		super();
	}
	
	public Pessoa(int idpessoa, String nome, String cpf, String dtNascimento, String telefone, String email) {
		super();
		this.idpessoa = idpessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.telefone = telefone;
		this.email = email;
	}

	public int getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    

}
