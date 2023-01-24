import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Cliente;
import Classes.ContaBancaria;
import Classes.ContaCorrente;
import Classes.ContaCorrenteEPoupanca;
import Classes.ContaPoupanca;
import Enums.Sexo;
import Interfaces.Constantes;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static List<ContaBancaria> contas = new ArrayList<>();
	static List<Cliente> clientes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int opcaoMenuPrincipal = 0;
		
		while (opcaoMenuPrincipal != 8) {
			scanner = new Scanner(System.in);
			
			System.out.println("\tGERENCIMENTO DE CONTAS\n");
			
			System.out.println(String.format("Contas: %d / %d", contas.size(), Constantes.NUMERO_MAX_CONTAS));
			System.out.println(String.format("Clientes: %d / %d\n", clientes.size(), Constantes.NUMERO_MAX_CLIENTES));
			
			System.out.println("[1] - Entrar em uma conta");
			System.out.println("[2] - Criar conta");
			System.out.println("[3] - Cadastrar cliente");
			System.out.println("[4] - Deletar conta");
			System.out.println("[5] - Deletar cliente");
			System.out.println("[6] - Ver contas");
			System.out.println("[7] - Ver clientes");
			System.out.println("[8] - Sair do aplicativo\n");
			System.out.println("Digite a operação: ");
			
			try {
				opcaoMenuPrincipal = scanner.nextInt();
			} catch (Exception e) {
				opcaoMenuPrincipal = 0;
			}
			
			switch (opcaoMenuPrincipal) {
				case 2:
					criarConta();
					break;
					
				case 3:
					cadastrarCliente();
					break;
					
				case 6:
					verContas();
					break;
					
				case 7:
					verClientes();
					break;
					
				case 8:
					sairAplicativo();
					break;
					
				default:
					System.out.println("Entrada inválida!");
					break;
			}
			
			System.in.read();
		}
		
		scanner.close();
	}
	
	
	public static void entrar() {
		
	}
	
	public static void criarConta() {
		if (contas.size() >= Constantes.NUMERO_MAX_CONTAS) {
			System.out.println("Número máximo de contas cadastradas atingido.");
			return;
		}
		else if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente foi cadastrado e, por isso, não é possível criar uma conta.");
			return;
		}
		
		try {
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println(String.format("%d - %s", i + 1, clientes.get(i).getNome()));
			}
			
			System.out.println("Selecione um cliente: ");
			int numeroCliente = scanner.nextInt();
			
			if (numeroCliente <= 0 || numeroCliente > clientes.size()) {
				throw new Exception();
			}
			
			System.out.println("Digite o número da conta: ");
			String numeroConta = scanner.next();
			
			for (ContaBancaria conta : contas) {
				if (conta.getNumero().equals(numeroConta)) {
					System.out.println("Este número de conta já está sendo utilizado.");
					return;
				}
			}
			
			System.out.println("Selecione o tipo de conta: ");
			System.out.println("[1] - Conta Poupança");
			System.out.println("[2] - Conta Corrente");
			System.out.println("[3] - Conta Poupança e Corrente");
			System.out.println("Digite: ");
			int tipoContaNumero = scanner.nextInt();
			
			if (tipoContaNumero == 1) {
				contas.add(new ContaPoupanca(clientes.get(numeroCliente - 1), numeroConta, LocalDate.now().getDayOfMonth()));
			}
			else if (tipoContaNumero == 2) {
				contas.add(new ContaCorrente(clientes.get(numeroCliente - 1), numeroConta, LocalDate.now().getDayOfMonth()));
			}
			else if (tipoContaNumero == 3) {
				contas.add(new ContaCorrenteEPoupanca(clientes.get(numeroCliente - 1), numeroConta, LocalDate.now().getDayOfMonth(), LocalDate.now().getDayOfMonth()));
			}
			else {
				throw new Exception();
			}
			
			System.out.println("Conta adicionada com sucesso!");
			
		} catch (Exception ex) {
			System.out.println("Entrada inválida!");
		}
	}
	
	public static void cadastrarCliente() {
		if (clientes.size() >= Constantes.NUMERO_MAX_CLIENTES) {
			System.out.println("Número máximo de clientes cadastrados atingido.");
			return;
		}
		
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
				throw new Exception(); //significa que digitou algo incorretamente
			}
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constantes.FORMATO_DATA); //coloca no formato dd/mm/yyyy

	        System.out.println(String.format("Informe a data de nascimento (%s): ", Constantes.FORMATO_DATA));
	        String dataNascimentoString = scanner.next();
	        
	        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, formatter);
			
			clientes.add(new Cliente(nome, dataNascimento, email, telefone, sexo));
			System.out.println("Cliente cadastrado com sucesso!");
		} catch (Exception ex) {
			System.out.println("Entrada inválida!");
		}
	}
	
	public static void deletarConta() {
		
	}
	
	public static void deletarCliente() {
		
	}
	
	public static void verContas() {
		if (contas.isEmpty()) {
			System.out.println("Nenhuma conta cadastrada.");
			return;
		}
		
		for (ContaBancaria conta : contas) {
			System.out.println(conta);
		}
	}
	
	public static void verClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
			return;
		}
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	public static void sairAplicativo() {
		System.out.println("Saindo...");
	}
}
