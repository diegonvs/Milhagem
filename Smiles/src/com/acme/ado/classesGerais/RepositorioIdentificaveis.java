package com.acme.ado.classesGerais;

import com.acme.rn.classesGerais.Identificavel;

public class RepositorioIdentificaveis {

	public Identificavel[] elementos;
	public int qtd;

	// Construtor
	public RepositorioIdentificaveis() {
		elementos = new Identificavel[150];
		this.qtd = 0;
	}

	public Identificavel buscar(String chave) {
		Identificavel r = null;
		for (int i = 0; i < qtd; i++) {
			if (chave.equals(elementos[i].getChave())) {
				r = elementos[i];
				return r;
			}
		}
		return null;
	}

	public void incluir(Identificavel id) {
		if (qtd < elementos.length && id != null) {
			elementos[qtd++] = id;
		} else {
			System.out.println("O repositório está cheio ou cliente é nulo! ");
		}
	}

	public void alterar(Identificavel id) {
		for (int i = 0; i < qtd; i++) {
			if (elementos[i].equals(id)) {
				elementos[i] = id;
				break;
			}
		}
	}

	public boolean excluir(String s) {
		boolean r = false;
		for (int i = 0; i < qtd; i++) {
			if (this.elementos[i].getChave().equals(s)) {
				elementos[i] = null;
				elementos[i] = elementos[--qtd];
				elementos[qtd] = null;
				r = true;
				break;
			}
		}
		return r;
	}

	public void listar() {
		System.out.println("--- Identificáveis: ---");
		for (int i = 0; i < qtd; i++) {
			System.out.println("Dados do cliente: " + (i + 1));
			System.out.println(elementos[i].toString());
		}
		System.out.println("----------------------------");
	}

	// Getters and setters
	/*public Identificavel[] getElementos() {
		return elementos;
	}

	public void setElementos(Identificavel[] elementos) {
		this.elementos = elementos;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}*/

}
