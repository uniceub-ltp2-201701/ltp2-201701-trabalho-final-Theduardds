package model;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String senha;
	private int privilegio;
	
	public Usuario(int idUsuario, String nome, String senha, int privilegio){
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
		this.privilegio = privilegio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(int privilegio) {
		this.privilegio = privilegio;
	}
	
	

}
