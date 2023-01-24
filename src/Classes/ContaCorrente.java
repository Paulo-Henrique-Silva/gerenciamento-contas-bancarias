package Classes;

import java.time.LocalDate;

import Interfaces.ContaPagamentos;

public final class ContaCorrente extends ContaBancaria implements ContaPagamentos {
	private final LocalDate diaCobranca;

	public ContaCorrente(Cliente cliente, String numero, double saldo, LocalDate diaCobranca) {
		super(cliente, numero, saldo);
		this.diaCobranca = diaCobranca;
	}
	
	public LocalDate getDiaCobranca() {
		return diaCobranca;
	}

	@Override
	public void transferir(double valor) {
		
	}

	@Override
	public void cobrarTaxa() {
		
	}
}
