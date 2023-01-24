package Classes;

import java.util.Calendar;

import Interfaces.ContaRentavel;

public final class ContaPoupanca extends ContaBancaria implements ContaRentavel {
	private final Calendar diaRendimento;

	public ContaPoupanca(Cliente cliente, String numero, double saldo, Calendar diaRendimento) {
		super(cliente, numero, saldo);
		this.diaRendimento = diaRendimento;
	}

	public Calendar getDiaRendimento() {
		return diaRendimento;
	}

	@Override
	public void render() {
		
	}
	
}
