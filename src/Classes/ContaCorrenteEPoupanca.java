package Classes;

import java.time.LocalDate;

import Excecoes.DiaInvalido;
import Excecoes.ValorTransacaoInvalido;
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
	public String toString() {
		String s = "";
		
		s += "\nCliente: " + getCliente().getNome();
		s += "\nNúmero conta: " + getNumero();
		s += "\nSaldo: R$" + getSaldo();
		s += "\nDia Cobrança: " + diaCobranca;
		s += "\nDia Rendimento: " + diaRendimento;
		
		return s;
	}

	@Override
	public void cobrarTaxa() throws DiaInvalido, ValorTransacaoInvalido {
		int diaAtual = LocalDate.now().getDayOfMonth();
		
		if (diaAtual != diaCobranca) {
			throw new DiaInvalido(String.format("O dia atual '%d' não condiz com o dia de cobrança '%d'", diaAtual, diaCobranca));
		}
		
		retirar(TAXA_MENSAL);
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
}
