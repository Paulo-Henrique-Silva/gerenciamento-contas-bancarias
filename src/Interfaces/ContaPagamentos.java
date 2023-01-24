package Interfaces;

public interface ContaPagamentos {
	double TAXA_MENSAL = 13.25;
	
	void transferir(double valor);
	void cobrarTaxa();
}
