package pjrLoja;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String email;
	private String telefone;

	public Cliente(int id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public void cadastrar() {
		System.out.println("Cliente cadastrado: " + nome);
	}

	public void atualizar() {
		System.out.println("Cliente atualizado: " + nome);
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}
}
