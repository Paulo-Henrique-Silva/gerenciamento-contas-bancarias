package Classes;

import java.time.LocalDate;

import Interfaces.ContaPagamentos;
import Interfaces.ContaRentavel;

public final class ContaCorrenteEPoupanca extends ContaBancaria implements ContaRentavel, ContaPagamentos {
	private final LocalDate diaCobranca;
	private final LocalDate diaRendimento;
	
	public ContaCorrenteEPoupanca(Cliente cliente, String numero, double saldo, LocalDate diaCobranca,
			LocalDate diaRendimento) {
		super(cliente, numero, saldo);
		this.diaCobranca = diaCobranca;
		this.diaRendimento = diaRendimento;
	}

	public LocalDate getDiaCobranca() {
		return diaCobranca;
	}

	public LocalDate getDiaRendimento() {
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
