package Classes;

import Interfaces.ContaRentavel;

public final class ContaPoupanca extends ContaBancaria implements ContaRentavel {
	private final int diaRendimento;

	public ContaPoupanca(Cliente cliente, String numero, int diaRendimento) {
		super(cliente, numero);
		this.diaRendimento = diaRendimento;
	}

	public int getDiaRendimento() {
		return diaRendimento;
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
		s += "\nDia Rendimento: " + diaRendimento;
		
		return s;
	}
	
}
