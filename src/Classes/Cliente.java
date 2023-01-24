package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Enums.Sexo;
import Interfaces.Constantes;

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

	@Override
	public String toString() {
		String s = "";
		
		s += "\nNome: " + nome;
		s += "\nData de nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern(Constantes.FORMATO_DATA));
		s += "\nEmail: " + email;
		s += "\nTelefone: " + telefone;
		s += "\nSexo: " + sexo.toString();
		
		return s;
	}
}
