import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Classes.ContaBancaria;
import Classes.ContaPoupanca;
import Excecoes.DiaInvalido;
import Excecoes.ValorTransacaoInvalido;

public class MenuContaPoupanca {
	private static Scanner scanner = new Scanner(System.in);
	private static ContaPoupanca contaPoupanca;
	
	public static void mostraMenu(ContaBancaria conta) throws IOException {
		contaPoupanca = (ContaPoupanca)conta;
		int opcaoMenu = 0;
		
		while (opcaoMenu != 5) {
			scanner = new Scanner(System.in);
			
			System.out.println("\tCONTA POUPANÇA\n");
			
			System.out.println(String.format("Número: %s", conta.getNumero()));
			System.out.println(String.format("Saldo: %.2f", conta.getSaldo()));
			System.out.println(String.format("Cliente: %s\n", conta.getCliente().getNome()));
			
			System.out.println("[1] - Depositar");
			System.out.println("[2] - Retirar");
			System.out.println("[3] - Render");
			System.out.println("[4] - Voltar");
			System.out.println("[5] - Sair do aplicativo");
			
			System.out.println("Digite a operação: ");
			
			try {
				opcaoMenu = scanner.nextInt();
			} catch (Exception e) {
				opcaoMenu = 0;
			}
			
			switch (opcaoMenu) {
				case 1:
					depositar();
					break;
					
				case 2:
					retirar();
					break;
					
				case 3:
					render();
					break;
					
				case 4:
					return; //encerra o método e volta ao arquivo Main
					
				case 5:
					 sairAplicativo();
					break;
					
				default:
					System.out.println("Entrada inválida!");
					break;
			}
			
			System.in.read();
		}
		
		System.exit(0);
	}
	
	private static void depositar() {
		try {
			System.out.println(String.format("Saldo disponível: R$%.2f", contaPoupanca.getSaldo()));
			System.out.println("Digite o valor a ser depositado: ");
			double valor = scanner.nextDouble();
			
			contaPoupanca.depositar(valor);
			
			System.out.println("Depósito realizado com sucesso.");
		} catch (ValorTransacaoInvalido ex) {
			System.out.println(ex.getMessage());
		} 
		catch (InputMismatchException ex) {
			System.out.println("Entrada inválida!");
		}
	}
	
	private static void retirar() {
		try {
			System.out.println(String.format("Saldo disponível: R$%.2f", contaPoupanca.getSaldo()));
			System.out.println("Digite o valor a ser sacado: ");
			double valor = scanner.nextDouble();
			
			contaPoupanca.retirar(valor);
			
			System.out.println("Saque realizado com sucesso.");
		} catch (ValorTransacaoInvalido ex) {
			System.out.println(ex.getMessage());
		}
		catch (InputMismatchException ex) {
			System.out.println("Entrada inválida!");
		}
	}
	
	private static void render() {
		try {
			double saldoAnterior = contaPoupanca.getSaldo();
			contaPoupanca.render();
			double saldoAtual = contaPoupanca.getSaldo();
			
			System.out.println(String.format("Saldo anterior: R$%.2f", saldoAnterior));
			System.out.println(String.format("Taxa rendimento: %.2f", ContaPoupanca.PORCENTAGEM_RENDIMENTO_MENSAL));
			System.out.println(String.format("Rendimento: R$%.2f", saldoAtual - saldoAnterior));
			System.out.println(String.format("Saldo atual: R$%.2f", saldoAtual));
			
			System.out.println("\nRendimento feito com sucesso."); 
		} catch (ValorTransacaoInvalido | DiaInvalido ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void sairAplicativo() {
		System.out.println("Saindo...");
	}
}
