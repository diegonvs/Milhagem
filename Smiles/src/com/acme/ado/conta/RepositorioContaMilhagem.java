package com.acme.ado.conta;

import java.util.Scanner;

import com.acme.rn.cliente.Cpf;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

public class RepositorioContaMilhagem {
	private ContaMilhagem[] elementos;
	private int quantidade;

	public ContaMilhagem buscar(IdentificadorConta c1) {
		ContaMilhagem cm = null;
		for (int i = 0; i < quantidade; i++) {
			if (elementos[i].identificadorconta.equals(c1.getNumero())) {
				cm = elementos[i];
				break;
			}
		}
		return cm;
	}

	public ContaMilhagem buscarpeloCpf(Cpf cpf) {
		ContaMilhagem cm = null;
		for (int i = 0; i < quantidade; i++) {
			if (elementos[i].cliente.getCpf().equals(cpf)) {
				cm = elementos[i];
				break;
			}
		}
		return cm;
	}

	public void incluir(ContaMilhagem cm) {
		if (quantidade < this.elementos.length) {
			if (this.buscar(cm.identificadorconta) == null) {
				this.elementos[quantidade++] = cm;
			} else {
				System.out.println("Elemento já existente no repositório!");
			}
		} else {
			System.out.println("Repositório cheio!");
		}
	}

	public void alterar(ContaMilhagem cm) {
		for (int i = 0; i < quantidade; i++) {
			ContaMilhagem a = cm;
			if (elementos[i].equals(cm)) {
				elementos[i] = cm;

				Scanner s = new Scanner(System.in);
				System.out.println();
				System.out.println("Conta alterada com sucesso!");
				break;
			}
		}
	}

	public boolean excluir(ContaMilhagem cm) {
		boolean r = false;
		for (int i = 0; i < quantidade; i++) {
			if (elementos[i].identificadorconta.getNumero() == (cm.identificadorconta
					.getNumero())) {
				elementos[i] = null;
				elementos[i] = elementos[--quantidade];
				elementos[quantidade] = null;
				r = true;
				System.out.println("Conta de " + cm.cliente.getNome()
						+ " removida com sucesso!");
				break;
			}
		}
		return r;
	}

	public void listar() {
		System.out.println("-- Contas Milhagem Existentes: --");
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Dados: " + (i + 1));
			System.out.println(elementos[i]);
		}
		System.out.println("---------------------------------");
	}

	public RepositorioContaMilhagem() {
		elementos = new ContaMilhagem[150];
		quantidade = 0;
	}
}
