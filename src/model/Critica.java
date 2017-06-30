package model;

public class Critica {
	
	private int idcritica;
	private int idfilme;
	private int idusuario;
	private String critica;
	
	public Critica(int idcritica, int idfilme, int idusuario, String critica) {
		super();
		this.idcritica = idcritica;
		this.idfilme = idfilme;
		this.idusuario = idusuario;
		this.critica = critica;
	}

	public int getIdcritica() {
		return idcritica;
	}

	public void setIdcritica(int idcritica) {
		this.idcritica = idcritica;
	}

	public int getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getCritica() {
		return critica;
	}

	public void setCritica(String critica) {
		this.critica = critica;
	}
	
	

}
