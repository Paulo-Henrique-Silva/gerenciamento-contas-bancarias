package Classes;

import java.util.Calendar;

import Interfaces.ContaPagamentos;
import Interfaces.ContaRentavel;

public final class ContaCorrenteEPoupanca extends ContaBancaria implements ContaRentavel, ContaPagamentos {
	private final Calendar diaCobranca;
	private final Calendar diaRendimento;
	
	public ContaCorrenteEPoupanca(Cliente cliente, String numero, double saldo, Calendar diaCobranca,
			Calendar diaRendimento) {
		super(cliente, numero, saldo);
		this.diaCobranca = diaCobranca;
		this.diaRendimento = diaRendimento;
	}

	public Calendar getDiaCobranca() {
		return diaCobranca;
	}

	public Calendar getDiaRendimento() {
		return diaRendimento;
	}

	@Override
	public void transferir(double valor) {
		
	}

	@Override
	public void cobrarTaxa() {
		
	}

	@Override
	public void render() {
		
	}
	
}
