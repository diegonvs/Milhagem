package com.acme.ado.cliente;

import com.acme.ado.classesGerais.InterfaceRepositorioClientes;
import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.cliente.Cliente;
import com.acme.rn.cliente.Cpf;

public class RepositorioClientes implements InterfaceRepositorioClientes {
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

	public Cliente buscarporChave(String chave)
			throws AtributoInvalidoException {
		if (chave.equals(null)) {
			throw new AtributoInvalidoException("Chave é null!");
		}
		try {
			return (Cliente) ri.buscar(chave);
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void incluir(Cliente c) throws AtributoInvalidoException {
		if(c.equals(null)){
			throw new AtributoInvalidoException("Cliente nulo!");
		}
		if (ri.qtd < this.ri.elementos.length) {
			this.ri.elementos[ri.qtd++] = c;
		} else {
			throw new AtributoInvalidoException("Parâmetro Cliente inválido");
		}
	}

	public void alterar(Cliente cliente) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		if (cliente.equals(null)) {
			throw new AtributoInvalidoException("Cliente nulo!");
		} else {
			for (int i = 0; i < ri.qtd; i++) {
				if (ri.elementos[i].equals(cliente)) {
					ri.elementos[i] = cliente;
					break;
				} else {
					throw new ObjetoNaoExistenteException(
							"Cliente não encontrado!");
				}
			}

		}
	}

	public boolean excluir(Cpf cpf) throws AtributoInvalidoException {
		boolean r = false;
		if (cpf.equals(null)) {
			throw new AtributoInvalidoException("Cpf nulo!");
		} else {

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
	}

	public Cliente[] buscaTodos() {
		Cliente[] clientes = new Cliente[ri.qtd];
		for (int i = 0; i < ri.qtd; i++) {
			clientes[i] = (Cliente) ri.elementos[i];
		}
		return clientes;
	}
}
