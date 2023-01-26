import java.io.IOException;
import java.util.Scanner;

import Classes.ContaBancaria;
import Interfaces.Constantes;

public class MenuContaPoupanca {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void mostraMenu(ContaBancaria conta) throws IOException {
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
					//entrar();
					break;
					
				case 2:
					//criarConta();
					break;
					
				case 3:
					//cadastrarCliente();
					break;
					
				case 4:
					return;
					
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
	
	private static void sairAplicativo() {
		System.out.println("Saindo...");
	}
}
