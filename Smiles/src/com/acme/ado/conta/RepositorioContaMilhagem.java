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
			if (elementos[i].identificadorconta.getNumero() == (c1.getNumero())) {
				cm = elementos[i];
			}
		}
		return cm;
	}

	public ContaMilhagem buscarpeloCpf(String cpf) {
		for (int i = 0; i < quantidade; i++) {
			if (elementos[i].cliente.getCpf().equals(cpf)) {
				return elementos[i];
			}
		}
		return null;
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

	public void alterar(IdentificadorConta existente, ContaMilhagem cm) {
		if (existente.equals(null)) {
			System.out.println("Identificador nulo!");
		} else {
			for (int i = 0; i < quantidade; i++) {
				if ((elementos[i].identificadorconta.equals(existente))) {
					elementos[i] = cm;
					System.out.println("Conta alterada com sucesso!");
					break;
				} else {
					System.out.println("Erro!");
				}
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
