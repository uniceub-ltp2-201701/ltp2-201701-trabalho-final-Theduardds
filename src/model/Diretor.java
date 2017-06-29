package model;

import java.sql.Date;

public class Diretor {

	private int idDiretor;
	private int idFilme;
	private String nome;
	private String biografia;
	private Date data_nasc;
	private String url;
	
	public Diretor(int idDiretor, int idFilme, String nome, String biografia, Date data_nasc, String url) {
		this.idDiretor = idDiretor;
		this.idFilme = idFilme;
		this.nome = nome;
		this.biografia = biografia;
		this.data_nasc = data_nasc;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdDiretor() {
		return idDiretor;
	}

	public void setIdDiretor(int idDiretor) {
		this.idDiretor = idDiretor;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	
}
