package com.acme.ado.classesGerais;

import com.acme.excecoes.AtributoInvalidoException;
import com.acme.excecoes.ObjetoExistenteException;
import com.acme.excecoes.ObjetoNaoExistenteException;
import com.acme.rn.conta.ContaMilhagem;
import com.acme.rn.conta.IdentificadorConta;

public interface InterfaceRepositorioContaMilhagem {

	public ContaMilhagem buscar(IdentificadorConta c1)
			throws AtributoInvalidoException;

	public ContaMilhagem buscarpeloCpf(String cpf)
			throws AtributoInvalidoException, ObjetoNaoExistenteException;

	public void incluir(ContaMilhagem cm) throws AtributoInvalidoException,
			ObjetoExistenteException;

	public void alterar(IdentificadorConta existente, ContaMilhagem cm)
			throws AtributoInvalidoException, ObjetoNaoExistenteException;

	public boolean excluir(ContaMilhagem cm) throws AtributoInvalidoException,
			ObjetoNaoExistenteException;

	public void listar() throws AtributoInvalidoException;

}
