package model;

import java.sql.Date;

public class Filme {
	
	private int idFilme;
	private String titulo;
	private String sinopse;
	private int classificacao;
	private double avaliacao;
	private int duracao;
	private Date data_lancamento;
	private String poster;
	
	
	public Filme(int idFilme, String titulo, String sinopse, int classificacao, double avaliacao, 
				 int duracao, Date data_lancamento, String poster) {
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.classificacao = classificacao;
		this.avaliacao = avaliacao;
		this.duracao = duracao;
		this.data_lancamento = data_lancamento;
		this.poster = poster;
	}
	
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Date getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public String getPoster() {
		return poster;
	}
	public void setImagem(String poster) {
		this.poster = poster;
	}

	
}
