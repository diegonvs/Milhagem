package com.acme.ado.conta;

import com.acme.rn.conta.MovimentoConta;

public class RepositorioMovimentoConta {
	private MovimentoConta[] repositorio;
	private int qtd;

	public MovimentoConta buscar(String nome) {
		MovimentoConta cm = null;
		for (int i = 0; i < qtd; i++) {
			if (repositorio[i].getNomedaFonte().equals(nome)) {
				cm = repositorio[i];
				break;
			}
		}
		return cm;
	}

	public void incluir(MovimentoConta mc1) {
		if (qtd < this.repositorio.length) {
			if (this.buscar(mc1.getNomedaFonte()) == null) {
				this.repositorio[qtd++] = mc1;
			} else {
				System.out.println("Elemento já existente no repositório!");
			}
		} else {
			System.out.println("Repositório cheio!");
		}
	}

	public void listar() {
		System.out.println("-- Contas Milhagem Existentes: --");
		for (int i = 0; i < qtd; i++) {
			System.out.println("Movimento de Conta nº: " + (i + 1));
			System.out.println(repositorio[i]);
			System.out.println("\n");
		}
		System.out.println("---------------------------------");

	}

	public RepositorioMovimentoConta() {
		repositorio = new MovimentoConta[150];
		qtd = 0;
	}

}
