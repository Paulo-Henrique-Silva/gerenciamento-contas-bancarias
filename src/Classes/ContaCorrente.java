package Classes;

import java.time.LocalDate;

import Excecoes.DiaInvalido;
import Excecoes.ValorTransacaoInvalido;
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
	public void cobrarTaxa() throws DiaInvalido, ValorTransacaoInvalido {
		int diaAtual = LocalDate.now().getDayOfMonth();
		
		if (diaAtual != diaCobranca) {
			throw new DiaInvalido(String.format("O dia atual '%d' não condiz com o dia de cobrança '%d'", diaAtual, diaCobranca));
		}
		
		retirar(TAXA_MENSAL);
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
