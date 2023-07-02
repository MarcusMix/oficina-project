package model.vo;

public class Orcamento {
	private int idOrcamento;
	private String tempoManutencao;
	private String pecas;
	private String valorTrabalho;
	private String valorTotal;
	private String situacao;
	
	public Orcamento(int idOrcamento, String tempoManutencao, String pecas, String valorTrabalho, String valorTotal,
			String situacao) {
		super();
		this.idOrcamento = idOrcamento;
		this.tempoManutencao = tempoManutencao;
		this.pecas = pecas;
		this.valorTrabalho = valorTrabalho;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
	}
	
	public Orcamento() {
		super();
	}

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}


	public String getTempoManutencao() {
		return tempoManutencao;
	}

	public void setTempoManutencao(String tempoManutencao) {
		this.tempoManutencao = tempoManutencao;
	}

	public String getPecas() {
		return pecas;
	}

	public void setPecas(String pecas) {
		this.pecas = pecas;
	}

	public String getValorTrabalho() {
		return valorTrabalho;
	}

	public void setValorTrabalho(String valorTrabalho) {
		this.valorTrabalho = valorTrabalho;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
		
}
