package Classes;

import Excecoes.ValorTransacaoInvalido;

public abstract class ContaBancaria {
	private final Cliente cliente;
	private final String numero;
	private double saldo = 0;
	
	public ContaBancaria(Cliente cliente, String numero) {
		this.cliente = cliente;
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) throws ValorTransacaoInvalido {
		if (valor <= 0) {
			throw new ValorTransacaoInvalido("O valor de depósito precisa ser um número maior que zero.");
		}
		
		saldo += valor;
	}
	
	public void retirar(double valor) throws ValorTransacaoInvalido {
		if (valor <= 0) {
			throw new ValorTransacaoInvalido("O valor de saque precisa ser um número maior que zero.");
		}
		else if (saldo - valor < 0) {
			throw new ValorTransacaoInvalido("Saldo insuficiente.");
		}
		
		saldo -= valor;
	}
	
}
