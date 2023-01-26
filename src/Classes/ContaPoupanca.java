package Classes;

import java.time.LocalDate;

import Excecoes.DiaInvalido;
import Excecoes.ValorTransacaoInvalido;
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
	public void render() throws DiaInvalido, ValorTransacaoInvalido {
		int diaAtual = LocalDate.now().getDayOfMonth();
		
		if (diaAtual != diaRendimento) {
			throw new DiaInvalido(String.format("O dia atual '%d' não condiz com o dia de rendimento '%d'", diaAtual, diaRendimento));
		}
		
		double rendimento = getSaldo() * PORCENTAGEM_RENDIMENTO_MENSAL / 100;
		
		depositar(rendimento);
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
