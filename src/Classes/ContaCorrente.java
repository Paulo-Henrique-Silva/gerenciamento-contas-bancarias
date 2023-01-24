package Classes;

import Interfaces.ContaPagamentos;

public final class ContaCorrente extends ContaBancaria implements ContaPagamentos {
	private final int diaCobranca;

	public ContaCorrente(Cliente cliente, String numero, int diaCobranca) {
		super(cliente, numero);
		this.diaCobranca = diaCobranca;
	}
	
	public int getDiaCobranca() {
		return diaCobranca;
	}

	@Override
	public void transferir(double valor) {
		
	}

	@Override
	public void cobrarTaxa() {
		
	}

	@Override
	public String toString() {
		String s = "";
		
		s += "\nCliente: " + getCliente().getNome();
		s += "\nNúmero conta: " + getNumero();
		s += "\nSaldo: R$" + getSaldo();
		s += "\nDia Cobrança: " + diaCobranca;
		
		return s;
	}
	
}
