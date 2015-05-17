package com.acme.ado.conta;

import com.acme.ado.classesGerais.RepositorioIdentificaveis;
import com.acme.rn.conta.MovimentoConta;

public class RepositorioMovimentoConta {
	/*private MovimentoConta[] repositorio;
	private int qtd;*/
	RepositorioIdentificaveis ri;
	public MovimentoConta buscar(String nome) {
		MovimentoConta mc =(MovimentoConta) ri.buscar(nome);
		return mc;
	}

	public void incluir(MovimentoConta mc1) {
		ri.incluir(mc1);
	}

	public void listar() {
		ri.listar();
	}

	public RepositorioMovimentoConta() {
		ri = new RepositorioIdentificaveis();
		/*repositorio = new MovimentoConta[150];
		qtd = 0;*/
	}

}
