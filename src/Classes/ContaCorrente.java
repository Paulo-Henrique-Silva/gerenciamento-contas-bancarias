package Classes;

import java.util.Calendar;

import Interfaces.ContaPagamentos;

public final class ContaCorrente extends ContaBancaria implements ContaPagamentos {
	private final Calendar diaCobranca;

	public ContaCorrente(Cliente cliente, String numero, double saldo, Calendar diaCobranca) {
		super(cliente, numero, saldo);
		this.diaCobranca = diaCobranca;
	}
	
	public Calendar getDiaCobranca() {
		return diaCobranca;
	}

	@Override
	public void transferir(double valor) {
		
	}

	@Override
	public void cobrarTaxa() {
		
	}
}
