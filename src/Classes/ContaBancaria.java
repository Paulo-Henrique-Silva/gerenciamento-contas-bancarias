package Classes;

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
	
	public void depositar(double valor) {
		
	}
	
	public void retirar(double valor) {
		
	}
	
}
