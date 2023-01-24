package Classes;

import Interfaces.ContaPagamentos;
import Interfaces.ContaRentavel;

public final class ContaCorrenteEPoupanca extends ContaBancaria implements ContaRentavel, ContaPagamentos {
	private final int diaCobranca;
	private final int diaRendimento;
	
	public ContaCorrenteEPoupanca(Cliente cliente, String numero, int diaCobranca,
			int diaRendimento) {
		super(cliente, numero);
		this.diaCobranca = diaCobranca;
		this.diaRendimento = diaRendimento;
	}

	public int getDiaCobranca() {
		return diaCobranca;
	}

	public int getDiaRendimento() {
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
	
	@Override
	public String toString() {
		String s = "";
		
		s += "\nCliente: " + getCliente().getNome();
		s += "\nNúmero conta: " + getNumero();
		s += "\nSaldo: R$" + getSaldo();
		s += "\nDia Cobrança: " + diaCobranca;
		s += "\nDia Rendimento: " + diaRendimento;
		
		return s;
	}
}
