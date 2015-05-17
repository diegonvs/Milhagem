package com.acme.ado.cliente;

import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;

public class RepositorioClientes {
	/*
	 * private Cliente[] elementos; private int qtd;
	 */
	private RepositorioIdentificaveis ri;

	public RepositorioClientes() {
		ri = new RepositorioIdentificaveis();
		/*
		 * elementos = new Cliente[150]; qtd = 0;
		 */
	}

	public Cliente buscarporChave(String chave) {
		return (Cliente) ri.buscar(chave);
	}

	public void incluir(Cliente c) {
		if (ri.qtd < this.ri.elementos.length && c != null) {
			this.ri.elementos[ri.qtd++] = c;
		} else {
			System.out
					.println("O repositório está cheio ou cliente é nulo! ");
		}
	}

	public void alterar(Cliente cliente) {
		for (int i = 0; i < ri.qtd; i++) {
			if (ri.elementos[i].equals(cliente)) {
				ri.elementos[i] = cliente;
				break;
			}
		}
	}

	public boolean excluir(Cpf cpf) {
		boolean r = false;
		for (int i = 0; i < ri.qtd; i++) {
			if (ri.elementos[i].getChave().equals(cpf.getCpf())) {
				ri.elementos[i] = null;
				ri.elementos[i] = ri.elementos[ri.qtd--];
				ri.elementos[ri.qtd] = null;
				r = true;
				break;
			}
		}
		return r;
	}

	public Cliente[] buscaTodos() {
		Cliente[] clientes = new Cliente[ri.qtd];
		for (int i = 0; i < ri.qtd; i++) {
			clientes[i] = (Cliente) ri.elementos[i];
		}
		return clientes;
	}
}
