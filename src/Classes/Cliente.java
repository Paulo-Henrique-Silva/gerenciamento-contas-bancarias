package Classes;

import java.time.LocalDate;

import Enums.Sexo;

public final class Cliente {
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	private String telefone;
	private Sexo sexo;
	
	public Cliente(String nome, LocalDate dataNascimento, String email, String telefone, Sexo sexo) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
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
