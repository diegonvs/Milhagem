package com.acme.ado.conta;

import com.acme.ado.classesGerais.InterfaceRepositorioContaMilhagem;
import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

//ARRUMADA!
public class RepositorioContaMilhagem extends RepositorioIdentificaveis
		implements InterfaceRepositorioContaMilhagem {
	// Atributos:
	RepositorioIdentificaveis ri;

	// Construtor:
	public RepositorioContaMilhagem() {
		ri = new RepositorioIdentificaveis();
		/*
		 * elementos = new ContaMilhagem[150]; quantidade = 0;
		 */
	}

	// Métodos:
	public ContaMilhagem buscar(IdentificadorConta c1)
			throws AtributoInvalidoException {
		if (c1.equals(null)) {
			throw new AtributoInvalidoException("Identificador Nulo!");
		}
		ContaMilhagem cm;
		try {
			cm = (ContaMilhagem) ri.buscar(c1.toString());
			return cm;
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ContaMilhagem buscarpeloCpf(String cpf)
			throws AtributoInvalidoException, ObjetoNaoExistenteException {
		ContaMilhagem cm;
		if (cpf.equals(null)) {
			throw new AtributoInvalidoException("Cpf nulo!");
		}
		try {
			cm = (ContaMilhagem) ri.buscar(cpf);
			return cm;
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void incluir(ContaMilhagem cm) throws AtributoInvalidoException,
			ObjetoExistenteException {
		if (cm.equals(null)) {
			throw new AtributoInvalidoException("Conta Milhagem Null!");
		}
		try {
			ri.incluir(cm);
		} catch (ObjetoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

	public void alterar(IdentificadorConta existente, ContaMilhagem cm)
			throws AtributoInvalidoException, ObjetoNaoExistenteException {
		if (cm.equals(null) || existente.equals(null)) {
			throw new AtributoInvalidoException(
					"Identificador ou ContaMilhagem null!");
		}
		try {
			ri.alterar(cm);
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

	public void excluir(ContaMilhagem cm) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		if (cm.equals(null)) {
			throw new AtributoInvalidoException("ContaMilhagem null!");
		}
		if (ri.excluir(cm.toString())) {
		} else {
			throw new ObjetoNaoExistenteException("Objeto não encontrado!");
		}
	}

	public ContaMilhagem[] listar(){
		return (ContaMilhagem[]) ri.listar();
		/*System.out.println("-- Contas Milhagem Existentes: --");
		for (int i = 0; i < ri.qtd; i++) {
			System.out.println("Dados: " + (i + 1));
			System.out.println(elementos[i]);
		}
		System.out.println("---------------------------------");
	*/
	}

}
