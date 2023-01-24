import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Cliente;
import Classes.ContaBancaria;
import Enums.Sexo;

public class Main {
	static List<ContaBancaria> contas = new ArrayList<>();
	static List<Cliente> clientes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int opcaoMenuPrincipal = 0;
		
		while (opcaoMenuPrincipal != 8) {
			scan = new Scanner(System.in);
			
			System.out.println("\tGERENCIMENTO DE CONTAS\n");
			
			System.out.println(String.format("Contas: %d / 15", contas.size()));
			System.out.println(String.format("Clientes: %d / 5\n", clientes.size()));
			
			System.out.println("[1] - Entrar em uma conta");
			System.out.println("[2] - Criar conta");
			System.out.println("[3] - Criar cliente");
			System.out.println("[4] - Deletar conta");
			System.out.println("[5] - Deletar cliente");
			System.out.println("[6] - Ver contas");
			System.out.println("[7] - Ver clientes");
			System.out.println("[8] - Sair do aplicativo\n");
			System.out.println("Digite a operação: ");
			
			try {
				opcaoMenuPrincipal = scan.nextInt();
			} catch (Exception e) {
				opcaoMenuPrincipal = 0;
			}
			
			switch (opcaoMenuPrincipal) {
				case 3:
					criarCliente();
					break;
					
				case 8:
					sairAplicativo();
					break;
					
				default:
					System.out.println("Entrada inválida!");
					break;
			}
			
			System.in.read();
			scan.close();
		}		
	}
	
	
	public static void entrar() {
		
	}
	
	public static void criarConta() {
		
	}
	
	public static void criarCliente() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Digite o nome do cliente: ");
			String nome = scanner.next();
			
			System.out.println("Digite o email do cliente: ");
			String email = scanner.next();
			
			System.out.println("Digite o telefone do cliente: ");
			String telefone = scanner.next();
			
			System.out.println("Selecione o sexo do cliente: ");
			System.out.println("[1] - Masculino");
			System.out.println("[2] - Feminino");
			System.out.println("Digite: ");
			int sexoNumero = scanner.nextInt();
			
			Sexo sexo;
			
			if (sexoNumero == 1) {
				sexo = Sexo.Masculino;
			}
			else if (sexoNumero == 2) {
				sexo = Sexo.Feminino;
			}
			else {
				throw new Exception();
			}
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        System.out.println("Informe a data de nascimento (dd/MM/yyyy):");
	        String dataNascimentoString = scanner.next();
	        
	        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, formatter);
			
			clientes.add(new Cliente(nome, dataNascimento, email, telefone, sexo));
		} catch (Exception ex) {
			System.out.println("Entrada inválida!");
		}
		finally {
			scanner.close();
		}
		
	}
	
	public static void deletarConta() {
		
	}
	
	public static void deletarCliente() {
		
	}
	
	public static void verContas() {
		
	}
	
	public static void verClientes() {
		
	}

	public static void sairAplicativo() {
		System.out.println("Saindo...");
	}
}
