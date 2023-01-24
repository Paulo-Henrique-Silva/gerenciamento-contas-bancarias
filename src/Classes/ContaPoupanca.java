package Classes;

import java.time.LocalDate;

import Interfaces.ContaRentavel;

public final class ContaPoupanca extends ContaBancaria implements ContaRentavel {
	private final LocalDate diaRendimento;

	public ContaPoupanca(Cliente cliente, String numero, double saldo, LocalDate diaRendimento) {
		super(cliente, numero, saldo);
		this.diaRendimento = diaRendimento;
	}

	public LocalDate getDiaRendimento() {
		return diaRendimento;
	}

	@Override
	public void render() {
		
	}
	
}
