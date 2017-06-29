package model;

public class Categoria {
	
	private int idcategoria;
	private int idfilme;
	private String nome;
	
	public Categoria(int idcategoria, int idfilme, String nome) {
		super();
		this.idcategoria = idcategoria;
		this.idfilme = idfilme;
		this.nome = nome;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public int getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(int idfilme) {
		this.idfilme = idfilme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
