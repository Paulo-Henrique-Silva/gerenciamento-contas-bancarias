package Interfaces;

import Excecoes.DiaInvalido;
import Excecoes.ValorTransacaoInvalido;

public interface ContaPagamentos {
	double TAXA_MENSAL = 13.25;
	
	void cobrarTaxa() throws DiaInvalido, ValorTransacaoInvalido;
}
