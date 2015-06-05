package com.acme.ado.conta;

import com.acme.ado.classesGerais.InterfaceRepositorioMovimentoConta;
import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.conta.MovimentoConta;

public class RepositorioMovimentoConta implements
		InterfaceRepositorioMovimentoConta {
	/*
	 * private MovimentoConta[] repositorio; private int qtd;
	 */
	RepositorioIdentificaveis ri;

	public MovimentoConta buscar(String nome) throws AtributoInvalidoException,
			ObjetoNaoExistenteException {
		try {
			MovimentoConta mc = (MovimentoConta) ri.buscar(nome);
			return mc;
		} catch (ObjetoNaoExistenteException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void incluir(MovimentoConta mc1) throws AtributoInvalidoException,
			ObjetoExistenteException {
		if (mc1.equals(null)) {
			throw new AtributoInvalidoException("Movimento Conta nulo!");
		}
		try {
			ri.incluir(mc1);
		} catch (ObjetoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listar() {
		ri.listar();
	}

	public RepositorioMovimentoConta() {
		ri = new RepositorioIdentificaveis();
		/*
		 * repositorio = new MovimentoConta[150]; qtd = 0;
		 */
	}

}
