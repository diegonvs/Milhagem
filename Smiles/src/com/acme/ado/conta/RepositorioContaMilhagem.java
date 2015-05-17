package com.acme.ado.conta;

import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

//ARRUMADA!
public class RepositorioContaMilhagem extends RepositorioIdentificaveis {
	// Atributos:
	/*
	 * private ContaMilhagem[] elementos; private int quantidade;
	 */
	RepositorioIdentificaveis ri;

	// Getters and Setters
	/*
	 * public ContaMilhagem[] getElementos() { return elementos; }
	 * 
	 * public void setElementos(ContaMilhagem[] elementos) { this.elementos =
	 * elementos; }
	 * 
	 * public int getQuantidade() { return quantidade; }
	 * 
	 * public void setQuantidade(int quantidade) { this.quantidade = quantidade;
	 * }
	 */

	// Construtor:
	public RepositorioContaMilhagem() {
		ri = new RepositorioIdentificaveis();
		/*
		 * elementos = new ContaMilhagem[150]; quantidade = 0;
		 */
	}

	// Métodos:
	public ContaMilhagem buscar(IdentificadorConta c1) {
		ContaMilhagem cm = (ContaMilhagem) ri.buscar(c1.toString());
		return cm;
	}

	public ContaMilhagem buscarpeloCpf(String cpf) {
		ContaMilhagem cm = (ContaMilhagem) ri.buscar(cpf);
		return cm;
	}

	public void incluir(ContaMilhagem cm) {
		ri.incluir(cm);
	}

	public void alterar(IdentificadorConta existente, ContaMilhagem cm) {
		ri.alterar(cm);
	}

	public boolean excluir(ContaMilhagem cm) {
		if (ri.excluir(cm.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public void listar() {
		System.out.println("-- Contas Milhagem Existentes: --");
		for (int i = 0; i < ri.qtd; i++) {
			System.out.println("Dados: " + (i + 1));
			System.out.println(elementos[i]);
		}
		System.out.println("---------------------------------");
	}

}
