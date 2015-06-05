package com.acme.ado.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.conta.MovimentoConta;

public interface InterfaceRepositorioMovimentoConta {

	public void incluir(MovimentoConta mc1) throws AtributoInvalidoException, ObjetoExistenteException;

	public void listar();

	public MovimentoConta buscar(String nome) throws AtributoInvalidoException,
			ObjetoNaoExistenteException;

}
