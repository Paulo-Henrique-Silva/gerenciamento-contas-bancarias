package Interfaces;

import Excecoes.DiaInvalido;
import Excecoes.ValorTransacaoInvalido;

public interface ContaRentavel {
	double PORCENTAGEM_RENDIMENTO_MENSAL = 0.5;
	
	void render() throws DiaInvalido, ValorTransacaoInvalido;
}
