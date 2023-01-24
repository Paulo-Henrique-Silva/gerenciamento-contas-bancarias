package Classes;

public abstract class ContaBancaria {
	private final Cliente cliente;
	private final String numero;
	private double saldo;
	
	public ContaBancaria(Cliente cliente, String numero, double saldo) {
		this.cliente = cliente;
		this.numero = numero;
		this.saldo = saldo;
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
