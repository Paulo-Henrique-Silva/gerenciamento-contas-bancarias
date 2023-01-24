package Classes;

import java.util.Calendar;

import Enums.Sexo;

public final class Cliente {
	private String nome;
	private Calendar dataNascimento;
	private String email;
	private String telefone;
	private Sexo sexo;
	
	public Cliente(String nome, Calendar dataNascimento, String email, String telefone, Sexo sexo) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public Sexo getSexo() {
		return sexo;
	}
	
}
