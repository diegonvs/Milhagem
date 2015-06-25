package com.acme.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.*;
import com.acme.ado.classesGerais.IOClientes;
import com.acme.ado.classesGerais.IOConta;
import com.acme.ado.classesGerais.IOMovimento;
import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.excecoes.SaldoInsuficienteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;
import com.acme.rn.conta.MovimentoConta;
import com.acme.rn.conta.MovimentoContaCredito;
import com.acme.rn.conta.MovimentoContaDebito;
import com.acme.rn.conta.MovimentoContaTransferencia;

/*.-----------------------------------------------------------------.
 /  .-.                                                         .-.  \
 |  /   \                                                       /   \  |
 | |\_.  |  	Smiles                                            |    /| |
 |\|  | /|                                                     |\  | |/|
 | `---' |   Por: Diego Nascimento                             | `---' |
 |       |                                                     |       | *
 |       |-----------------------------------------------------|       |
 \       |                                                     |       /
 \     /                                                       \     /
 `---'                                                         `---'
 */

public class Main {
	public static IOClientes ioC = new IOClientes();
	public static IOConta ioConta = new IOConta();
	public static Scanner s = new Scanner(System.in);
	public static IOMovimento ioM = new IOMovimento();

	public static void main(String[] args) throws AtributoInvalidoException {
		int op = 0;
		while (op != 6) {

			System.out.println("Cadastro de clientes [0]");
			System.out.println("Operacões de Crédito [1]");
			System.out.println("Operações de Débito [2]");
			System.out.println("Transferir [3]");
			System.out.println("Consultar Conta de Milhas [4]");
			System.out.println("Consultar Extrato do Cliente [5]");
			System.out.println("Sair do programa [6]");
			op = s.nextInt();
			switch (op) {
			case 0:
				cadastroClientes();
				break;
			case 1:
				creditarCliente();
				break;
			case 2:
				debitarCliente();
				break;
			case 3:
				tranferirMilhas();
				break;
			case 4:
				listar();
				break;
			default:
				break;
			}

		}

	}

	public static void cadastroClientes() throws AtributoInvalidoException {
		s.nextLine();
		System.out.println("Digite seu nome: ");
		String nome = s.nextLine();
		System.out.println("Digite seu Cpf: ");
		String cpf = s.nextLine();
		System.out.println("Digite a idade do cliente: ");
		int idade = s.nextInt();
		System.out.println("Digite a renda do cliente: ");
		double renda = s.nextDouble();
		System.out.println("Digite o sexo:\n 0 - Masculino\n 1 - Feminino\n ");
		int sexo = s.nextInt();
		Cpf Cpf = new Cpf(cpf);
		Cliente c = new Cliente(Cpf, nome, idade, renda, sexo);
		ContaMilhagem cm = new ContaMilhagem(new IdentificadorConta(
				Long.parseLong(cpf)), c);

		try {
			ioConta.incluir(cm);
			ioC.incluir(c);
		} catch (ObjetoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void creditarCliente() {
		s.nextLine();
		System.out.println("Digite a chave do cliente(Cpf): ");
		String cpf = s.nextLine();
		System.out
				.println("Digite a quantidade de milhas que você deseja creditar: ");
		int milhas = s.nextInt();
		try {
			ContaMilhagem novocm = ioConta.buscarpeloCpf(cpf);
			System.out.println(novocm.getChave());
			novocm.Creditar(milhas);
			System.out.println(novocm.getSaldo());
			ioConta.excluir(ioConta.buscarpeloCpf(cpf));
			ioConta.incluir(novocm);
			

		} catch (AtributoInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
		} catch (ObjetoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void debitarCliente() {
		s.nextLine();
		System.out.println("Digite a chave do cliente(Cpf): ");
		String cpf = s.nextLine();
		System.out
				.println("Digite a quantidade de milhas que você deseja debitar: ");
		int milhas = s.nextInt();
		try {
			ContaMilhagem novocm = ioConta.buscar(new IdentificadorConta(Long
					.parseLong(cpf)));
			novocm.Debitar(milhas);
			ioConta.excluir(ioConta.buscarpeloCpf(cpf));
			ioConta.incluir(novocm);
		} catch (AtributoInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		} catch (ObjetoExistenteException e) {
			e.printStackTrace();
		}
	}

	public static void tranferirMilhas() {
		s.nextLine();
		System.out.println("Digite o Cpf da conta de débito: ");
		String cpf1 = s.nextLine();
		System.out.println("Digite o Cpf da conta de crédito: ");
		String cpf2 = s.nextLine();
		System.out
				.println("Digite a quantidade de milhas que você deseja transferir: ");
		int valor = s.nextInt();
		try {
			ContaMilhagem origem = ioConta.buscarpeloCpf(cpf1);
			ContaMilhagem destino = ioConta.buscarpeloCpf(cpf2);

			origem.Debitar(valor);
			destino.Creditar(valor);
			ioConta.excluir(ioConta.buscarpeloCpf(cpf1));
			ioConta.excluir(ioConta.buscarpeloCpf(cpf2));
			ioConta.incluir(destino);
			ioConta.incluir(origem);
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
		} catch (AtributoInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		} catch (ObjetoExistenteException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void listar() {
		try {
			System.out.println(Arrays.toString(ioConta.listar()));
		} catch (AtributoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
